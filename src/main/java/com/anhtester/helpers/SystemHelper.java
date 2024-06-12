package com.anhtester.helpers;

import java.io.File;

public class SystemHelper {
    //Lấy ra đường dẫn của file cụ thể cần đọc
    public static String getCurrentDirectory(){
        String path = System.getProperty("user.dir") + File.separator;
        return path;
    }
}
