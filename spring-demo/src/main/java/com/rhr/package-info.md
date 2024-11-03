### Import注解的使用

#### 情况一：

 如果需要注册的类是在第三方的jar中，那么我们如果想注册这些bean有2种方式：
 通过@Bean的方式一个一个注册
 通过@ComponentScan的方式。默认的@ComponentScan是无能为力的，他只能注册@Component,@Service等那四个注解标记的类，所以我们需要用自定义过滤器的方式

 #### 情况二：

 通常我们的项目中有很多子模块，可能每个模块都是独立开发的，最后通过jar的方式引进来，
 每个模块中都有各自的@Configuration或者使用@CompontentScan标注的类，此时如果我们只想使用其中几个模块的配置类，怎么办？

 ### @import的value参数常见的六种用法

 使用@Import的时候，也会连@Import标记的类一起注册到容器中。

#### value为普通的类

 ```java
 public class Service1 {
  }
  public class Service2 {
  }
  @Import({Service1.class, Service2.class})
 ```

#### value为@Configuration标注的类，前提是@Configuration不能被自动扫描到

@Import注解将普通类对象注册到容器后，但是这些bean的名称是全类名，如果想指定名称的话，在对应的类上加上@Component注解指定名称即可。
```java
@Configuration
 public class ConfigModule1 {
    @Bean
    public String module1(){
 		return "我是模块一配置类";
    }
 }
 @Import({ConfigModule1.class})
```

####  value为@CompontentScan标注的类

```java
public class Service1 {
}

@ComponentScan(
		useDefaultFilters = false,
		includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Service1.class)
)
public class ConfigModule2 {
}

@Import({ConfigModule2.class})
```

#### value为ImportBeanDefinitionRegistrar接口类型

```java
public class Service1 {
}

public class Service2 {

	private Service1 service1;

	public void setService1(Service1 service1) {
		this.service1 = service1;
	}

	@Override
	public String toString() {
		return "Service2{" +
				"service1=" + service1 +
				'}';
	}
}

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		//定义一个bean：Service1
		BeanDefinition service1BeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition();
		//注册bean
		registry.registerBeanDefinition("service1", service1BeanDefinition);
		//定义一个bean：Service2，通过addPropertyReference注入service1
		BeanDefinition service2BeanDefinition = BeanDefinitionBuilder
				.genericBeanDefinition(Service2.class)
				.addPropertyReference("service1", "service1")
				.getBeanDefinition();
		//注册bean

		registry.registerBeanDefinition("service2", service2BeanDefinition);
	}
}

@Import({MyImportBeanDefinitionRegistrar.class})
```

#### value为ImportSelector接口类型

```java
public class Service1 {
}
@Configuration
public class ConfigModule1 {

	@Bean
	public String module1(){
		return "我是模块一配置类";
	}
}

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
				Service1.class.getName(),
				ConfigModule1.class.getName()
		};
	}
}
```

 value为DeferredImportSelector接口类型

DeferredImportSelector是ImportSelector的子接口，既然是ImportSelector的子接口，所以也可以通过@Import进行导入，这个接口和ImportSelector不同地方有两点：

- 延迟导入

- 指定导入的类的处理顺序,如果有多个DeferredImportSelector类型的呢，这个时候就需要实现Oedered接口了

  

  比如@Import的value包含了多个普通类、多个@Configuration标注的配置类、多个ImportSelector接 口的实现类，多个ImportBeanDefinitionRegistrar接口的实现类，还有DeferredImportSelector接口实现类，此时spring处理这些被导入的类的时候，会将DeferredImportSelector类型的放在最后处理， 会先处理其他被导入的类，其他类会按照value所在的前后顺序进行处理。 那么我们是可以做很多事情的，比如我们可以在DeferredImportSelector导入的类中判断一下容器中是否已经注册了某个bean，如果没有注册过，那么再来注册。 以后我们会讲到另外一个注解@Conditional，这个注解可以按条件来注册bean，比如可以判断某个 bean不存在的时候才进行注册，某个类存在的时候才进行注册等等各种条件判断，通过@Conditional来结合DeferredImportSelector可以做很多事情。

#### 实现接口ImportAware，实现功能enableXXX

比如@EnableRedissonHttpSession源码

```java
public class MyImportAware implements ImportAware {
   private int maxConnections;

   @Override
   public void setImportMetadata(AnnotationMetadata annotationMetadata) {
      Map<String, Object> attributesMap = annotationMetadata.getAnnotationAttributes(EnableMyDb.class.getName());
      AnnotationAttributes attrs = AnnotationAttributes.fromMap(attributesMap);
      this.maxConnections = attrs.getNumber("maxConnections");
      System.out.println(this.maxConnections);
   }
}
```

```java
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportAware.class)
public @interface EnableMyDb {
   int maxConnections() default 1000;
}

@Configuration
@EnableMyDb(maxConnections = 2000)
public class Config {}
```
