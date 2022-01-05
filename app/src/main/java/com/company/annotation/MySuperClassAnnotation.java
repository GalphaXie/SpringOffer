package com.company.annotation;

import org.springframework.core.MethodParameter;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyAnnotation(method = "superClass", code = 11)
public class MySuperClassAnnotation implements MyInterfaceAnnotation{

    @Override
    public Annotation get() {
        Class<?> clazz = this.getClass();
//        Annotation[] annotations = clazz.getAnnotations();
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class<?> inter: interfaces){
           System.out.println(Arrays.toString(inter.getAnnotations()));
        }
        return null;
    }

    public static void main(String[] args) {
        MySuperClassAnnotation mySuperClassAnnotation = new MySuperClassAnnotation();
        System.out.println(mySuperClassAnnotation.get());
    }
}
