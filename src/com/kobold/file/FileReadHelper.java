package com.kobold.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileReadHelper {
    private String path;
    private int count;
    private Map<Integer, String> resultMap;
    private String encode;

    public static final String EMPTY = "";

    public FileReadHelper(String path) {
        this.path = path;
        this.count = 0;
        this.resultMap = new HashMap<>();
        this.encode = "GBK";
    }

    public FileReadHelper(String path, String encode) {
        this(path);
        this.encode = encode;
    }

    public static String getExtension(String fileName) {
        if (null == fileName)
            return EMPTY;
        int pointIndex = fileName.lastIndexOf('.');
        return pointIndex > 0 && pointIndex < fileName.length() ?
                fileName.substring(pointIndex + 1).toLowerCase() : EMPTY;
    }


    /*
     *本函数对于中文默认支持GBK编码
     */
    public static String readToEnd(String path, String encode) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encode));
        String str = "";
        StringBuilder sb = new StringBuilder();
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        return sb.toString();
    }



    public String readLine() throws IOException {
        if (!resultMap.isEmpty()) {
            return resultMap.get(count++);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encode));
        String str;
        while ((str = reader.readLine()) != null) {
            resultMap.put(count, str);
            count++;
        }
        count = 0;
        return resultMap.get(count++);
    }
}
