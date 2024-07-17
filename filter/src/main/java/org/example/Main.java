package org.example;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        //Так в данной задаче оперируем классом Object и у нас нет сведений о возможном подтипе и методах,
        //его индивидуализируюших, то в качестве метода, преобразующего элементы массива,
        //выбрал toString(), как наиболее наглядный
        Filter filter = o -> o.toString().toUpperCase();
        Object[] array = {"first", "second", "third"};
        Object[] filteredObj = filter(array, filter);
        for (Object o : filteredObj) {
            System.out.println(o);
        }
    }

    public static Object[] filter(Object[] array, Filter filter) {
        Class<?> clazz = array[0].getClass();
        Object[] reuslt = (Object[]) Array.newInstance(clazz, array.length);
        for (int i = 0; i < array.length; i++) {
            reuslt[i] = clazz.cast(filter.apply(array[i]));
        }
        return reuslt;
    }
}