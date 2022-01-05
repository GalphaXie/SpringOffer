package com.company.annotation;


import java.lang.annotation.Annotation;

@MyAnnotation(method = "interface", code = 1)
public interface MyInterfaceAnnotation {

    Annotation get();
}
