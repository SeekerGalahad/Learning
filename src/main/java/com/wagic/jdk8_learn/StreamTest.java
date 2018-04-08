package com.wagic.jdk8_learn;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        System.out.println("===============groupCount=================");
        groupCount();

        System.out.println("===============getCharAtOne=================");
        getCharAtOne();


        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        Map<List<? extends Serializable>, Long> collect = items.stream().collect(
                Collectors.groupingBy((Item f) -> Arrays.asList(f.getName(), f.getPrice()),
                        Collectors.counting()));

        System.out.println(collect);
        System.out.println(sum);



    }

    private static void groupCount() {

        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        LinkedHashMap<String, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        System.out.println(result);
    }

    private static void getCharAtOne() {
        List<String> list = Lists.newArrayList(
                "bcd", "cde", "def", "abc");

        List<String> results = list.stream().filter(e -> e.length() >= 3)
                .map(e -> e.charAt(0)).map(String::valueOf)
                .collect(Collectors.toList());

        for (String result : results) {
            System.out.println(result);
        }
    }
}
