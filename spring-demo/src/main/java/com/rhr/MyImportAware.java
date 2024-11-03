package com.rhr;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author: yyb
 * @date: 2023/12/15 23:40
 * @description:
 */
public class MyImportAware implements ImportAware {


	private int maxConnections;


	@Override
	public void setImportMetadata(AnnotationMetadata annotationMetadata) {
		Map<String, Object> attributesMap = annotationMetadata.getAnnotationAttributes(EnableMyDb.class.getName());
		AnnotationAttributes attrs = AnnotationAttributes.fromMap(attributesMap);
		this.maxConnections = attrs.getNumber("maxConnections");
		System.out.println(this.maxConnections);
	}


	public void store() {
		System.out.println(this.maxConnections);
	}
}