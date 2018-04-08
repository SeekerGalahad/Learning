package com.wagic.code.learn;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuavaTest {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b", "c", null);
        String csv = Joiner.on(",").skipNulls().join(strList);
        assertEquals("a,b,c", csv);
        System.out.println(csv);
    }
}
