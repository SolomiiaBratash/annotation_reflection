package com.bratash.task1_2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        TaskClass taskClass = new TaskClass();
        taskClass.getAll(TaskClass.class);
        System.out.println();

        taskClass.getValue(TaskClass.class);
        System.out.println();

        TaskClass.invokeMethod(taskClass, 2, 3, "invokeMethod");
        System.out.println();

        Field field = taskClass.getClass().getDeclaredField("age");
        if (field.getType().equals(int.class))
            field.setInt(taskClass, 23);
        System.out.println("Changed age: " + taskClass.age);

        TaskClass.invokeMyMethod();
        System.out.println();

        InfoClass.info(taskClass);
    }
}
