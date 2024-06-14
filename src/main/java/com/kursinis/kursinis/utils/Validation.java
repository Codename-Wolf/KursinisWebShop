package com.kursinis.kursinis.utils;

public class Validation {
    public static String validateString(String str, String fieldName) throws Exception {
        if (str.isEmpty()) {
            throw new Exception(fieldName + " is empty");
        }
        else {
            return str;
        }
    }
}
