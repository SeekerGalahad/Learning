package com.wagic.jdk8_learn;

import com.wagic.jdk8_learn.model.Person;
import org.junit.jupiter.api.Test;

public class JDK8Test {

    private int num = 1;
    private Converter<String, Integer> converter = (from) -> Integer.valueOf(from + num);
//    private Converter<String, Integer> converter = Integer::valueOf;

    @Test
    public void lambdaTest() {

        /*ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("abc");
        arrayList.add("hhh");

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        })

        Collections.sort(arrayList, Comparator.reverseOrder());

        Collections.sort(arrayList, Comparator.reverseOrder());*/

        // 隐式声明是final,该变量后续不能改动
//        int num = 1;
//        final int num = 1;

        Integer fromString = converter.convert("123");
        System.out.println(fromString);

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }

    @Test
    public void personTest() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("wagic", "galahad");
        System.out.println(person);
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String secondName);

}

interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class Lambda4 {

        static int outerStaticNum;
        int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter =
                (from) -> {
                    outerNum = 23;
                    return String.valueOf(outerNum);
                };

        Converter<Integer, String> stringConverter2 =
                (from) -> {
                    outerStaticNum = 72;
                    return String.valueOf(outerStaticNum);
                };
    }

}