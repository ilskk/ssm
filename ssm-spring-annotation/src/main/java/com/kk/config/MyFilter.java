package com.kk.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //扫描器通过"com.kk.*"包中的所有类,getClassName()可以拿到该包及子包的所有类的名字
       String classNames=metadataReader.getClassMetadata().getClassName();
       //只过滤和person相关的三层组件
        if(classNames.contains("Person")){
            return true;
        }
        return false;
    }
}
