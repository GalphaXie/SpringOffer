package com.company.annotation;

import java.lang.annotation.Annotation;

public class MyClassAnnotation extends MySuperClassAnnotation{

    @Override
    public Annotation get(){
        System.out.println("in children class");
        Class<?> clazz = this.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        return annotations[0];
    }

    public static void main(String[] args) {
        MySuperClassAnnotation mySuperClassAnnotation = new MyClassAnnotation();
        System.out.println(mySuperClassAnnotation.get());
    }
}
