package com.rhr;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: yyb
 * @date: 2023/12/15 23:35
 * @description:
 */
public class DeferredImportSelector1 implements DeferredImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
				ConfigModule1.class.getName()
		};
	}
}
