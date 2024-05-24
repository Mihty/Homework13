package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            Class<A> clazz = A.class;

            Constructor<A> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            A instance = constructor.newInstance();
            Field idField = clazz.getDeclaredField("id");
            Field nameField = clazz.getDeclaredField("name");
            idField.setAccessible(true);
            nameField.setAccessible(true);
            idField.set(instance, "456");
            nameField.set(instance, "B");

            System.out.println(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    private String id = "123";
    private String name = "A";

    private A() {
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
