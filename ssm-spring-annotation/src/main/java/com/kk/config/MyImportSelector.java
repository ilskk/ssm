package com.kk.config;

import com.kk.entity.Import.Banana;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
               "com.kk.entity.Import.Banana",
                "com.kk.entity.Import.Apple"
        }; //返回值就是要加入IOC容器的bean的全类名
    }
}
