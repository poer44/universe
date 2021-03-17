package com.poer.universe.lambda;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

/**
 * @author 93807
 * @create 2021-03-16 10:41
 * @desc 文件服务
 **/
public class FileServer {
    public void FileHandle(String url, FileContent content) {
        File file = new File(url);
        content.filetest(file.getAbsolutePath());
    }
    public static void main(String[] args) {
        FileServer fileServer=new FileServer();
        fileServer.FileHandle("com/poer/universe/lambda/FileServer.java", str->System.out.println(str));

        // 创建出一个数组
        List<String> strList = Arrays.asList("YangHang", "AnXiaoHei", "LiuPengFei");
        strList.forEach(System.out::println);
    }
}


