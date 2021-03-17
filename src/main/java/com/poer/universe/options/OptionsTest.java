package com.poer.universe.options;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 93807
 * @create 2021-03-16 15:20
 * @desc tets
 **/
public class OptionsTest {
    public static void test(List<String> list) {
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        test(null);
    }
}
