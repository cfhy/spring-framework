package com.rhr;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: yyb
 * @date: 2023/12/15 23:29
 * @description:
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
				Service1.class.getName(),
				ConfigModule1.class.getName(),
				ConfigModule2.class.getName()
		};
	}
}