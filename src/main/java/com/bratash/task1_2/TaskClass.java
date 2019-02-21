package com.bratash.task1_2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskClass {
    @TaskAnnotation(name = "Solomiia")
    String name;

    public int age = 20;

    @TaskAnnotation(name = "NULP")
    String univer;

    void getAll(Class classN){
        List<Field>fields = new ArrayList<Field>(Arrays.asList(classN.getDeclaredFields()));

        for (Field fieldsi: fields) {
            System.out.println(fieldsi);
        }
    }

    void getValue(Class classN){
        List<Field>fields = new ArrayList<Field>(Arrays.asList(classN.getDeclaredFields()));

        for (Field fieldsi: fields){
            List<Annotation> annotationValues = Arrays.asList(fieldsi.getDeclaredAnnotations());
            if (!annotationValues.isEmpty())
                System.out.println(annotationValues.get(0));
        }
    }

    public int method1(int num1, int num2){
        return num1+num2;
    }

    public boolean method2(int num){
        return num == 2;
    }

    public String method3(String str){
        return str;
    }

    static void invokeMethod(TaskClass taskClass, int num1, int num2, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class cl = TaskClass.class;
        Method method1 = cl.getDeclaredMethod("method1",int.class, int.class);
        System.out.println("Method1: " + method1.invoke(taskClass, num1, num2));
        Method method2 = cl.getDeclaredMethod("method2", int.class);
        System.out.println("Method2: " + method2.invoke(taskClass, num1));
        Method method3 = cl.getDeclaredMethod("method3", String.class);
        System.out.println("Method3: " + method3.invoke(taskClass, str));
    }

    public void myMethod(String str, int... args){
        System.out.println("String: " + str + "\nArgs: " + Arrays.toString(args));
    }

    public void myMethod(String... args){
        System.out.println("Args: " + Arrays.toString(args));
    }

    static void invokeMyMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TaskClass taskClass = new TaskClass();
        Method method = taskClass.getClass().getDeclaredMethod("myMethod", String[].class);
        method.invoke(taskClass, new Object[]{new String[]{"myMethod1", "myMethod2", "myMethod3"}});
        method = taskClass.getClass().getDeclaredMethod("myMethod", String.class, int[].class);
        method.invoke(taskClass, "Invoke", new int[]{0, 1, 2});
    }
}

