package com.poer.universe.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;

/**
 * @author 93807
 * @create 2021-03-16 15:35
 * @desc test
 **/
public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> mset= HashMultiset.create();
        ImmutableList<String> list=ImmutableList.of("0101","0101","0102");
        list.stream().forEach(str->{
            mset.add(str);
        });
        System.out.println(mset.count("0101"));
        System.out.println(mset.size());
    }
}
