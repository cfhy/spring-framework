package com.rhr;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: yyb
 * @date: 2023/12/15 23:41
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportAware.class)
public @interface EnableMyDb {
	int maxConnections() default 1000;
}
