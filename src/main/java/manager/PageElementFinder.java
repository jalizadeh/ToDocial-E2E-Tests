package main.java.manager;

import org.openqa.selenium.By;

public class PageElementFinder {

    public static final String VIEWS_PATH = "main.java.views.";

    public static By findPageElement(String className, String variableName) {
        try {
            Class<?> clazz = Class.forName(VIEWS_PATH + className);
            Object instance = clazz.newInstance();

            java.lang.reflect.Field field = clazz.getDeclaredField(variableName);
            field.setAccessible(true);
            Object element = field.get(instance);

            if (element instanceof By) {
                return (By) element;
            } else {
                throw new IllegalArgumentException("The specified variable is not of type By.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            System.err.println("Error accessing field: " + variableName);
            e.printStackTrace();
        }
        return null;
    }

}
