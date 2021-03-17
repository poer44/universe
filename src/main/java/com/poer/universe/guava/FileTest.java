package com.poer.universe.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * @author 93807
 * @create 2021-03-16 15:58
 * @desc filetest
 **/
public class FileTest {
    public static void main(String[] args) throws IOException {
        CharSource charSource= Files.asCharSource(new File("1.java"), Charsets.UTF_8);
        CharSink charSink= Files.asCharSink(new File("Copy1.java"), Charsets.UTF_8);

        charSource.copyTo(charSink);
    }
}
