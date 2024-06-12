package com.anhtester.constants;

import com.anhtester.helpers.PropertiesHelper;

public class ConfigData {

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static String URL = PropertiesHelper.getValue("url");
    public static String EMAIL = PropertiesHelper.getValue("email");
    public static String PASSWORD = PropertiesHelper.getValue("password");
}
