import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Class reflection = Reflection.class;

        List<Method> set = new ArrayList<Method>();
        List<Method> get = new ArrayList<Method>();

        Method[] methods = reflection.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                get.add(method);
            } else if (method.getName().startsWith("set")) {
                set.add(method);
            }
        }

        get.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(getter ->
                        System.out.printf("%s will return class %s%n",
                                getter.getName(), getter.getReturnType().getSimpleName()));

        set.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(setter -> {
                    System.out.printf("%s will set field of class ", setter.getName());
                    Arrays.stream(setter.getParameterTypes()).forEach(
                            type -> System.out.printf("%s%n", type.getSimpleName())
                    );
                }
        );

    }
}


