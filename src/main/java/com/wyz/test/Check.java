package com.wyz.test;

public class Check {

    public static <T> boolean checkArray(T[] src, T[] now) {
        if (src.length != now.length) return false;
        for (int i = 0; i < src.length; i++) {
            if (!src[i].equals(now[i])) return false;
        }
        return true ;
    }
}
