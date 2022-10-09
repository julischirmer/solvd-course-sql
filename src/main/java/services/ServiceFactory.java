package services;

import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {
    public static IService create (String serviceClass) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object o = Class.forName(serviceClass).getDeclaredConstructor().newInstance();
        return (IService) o;
    }
}
