package com.bratash.task1_2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InfoClass {
    public static void info(Object object){
        Class cl = object.getClass();

        System.out.println("Full name: " + cl.getName());
        System.out.println("Name: " + cl.getSimpleName());
        System.out.println("Package: " + cl.getPackage());
        System.out.println("Super class: " + cl.getSuperclass());
        System.out.println("Annotation: " + cl.isAnnotation());
        System.out.println("Primitive: " + cl.isPrimitive());
        System.out.println("Array: " + cl.isArray());
        System.out.println("Enum: " + cl.isEnum());

        System.out.println("Declared fields: ");
        for(Field field : cl.getDeclaredFields())
            System.out.println(field.getName());

        System.out.println("Declared methods: ");
        for(Method method : cl.getDeclaredMethods())
            System.out.println(method.getName());
    }
}
