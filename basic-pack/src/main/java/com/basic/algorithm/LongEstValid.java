package com.basic.algorithm;

/**
 * 最长有效性
 */
public class LongEstValid {
    public static boolean isValid(String str) {
        if (str == null || str == "") {
            return false;
        }
        char[] chas = str.toCharArray();
        int status=0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ')' && chas[i] != '(') {
                return false;
            }
            if (chas[i] == ')' && --status < 0) {
                return false;
            }
            if (chas[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()())"));

    }
}
