package com.mslc.training.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {


    public static void main(String[] args) throws Exception {


        String className = "com.mslc.training.java.model.NewCustomer";

        Class c = Class.forName(className);

        Method[] methods = c.getDeclaredMethods();

        for(Method m : methods) {
            System.out.println(m.getName());
        }

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        Constructor constructor = c.getConstructor( new Class[] {});

        Object newInstance = constructor.newInstance(new Object[] {});

        System.out.println(newInstance);

        Method setterMethod = c.getDeclaredMethod("setName", new Class[] {String.class});

        setterMethod.invoke(newInstance, new Object[] {"Shakir"});

        Method getterMethod = c.getDeclaredMethod("getName", new Class[] {});
        Object result = getterMethod.invoke(newInstance, new Object[] {});
        System.out.println(result);













    }
}
