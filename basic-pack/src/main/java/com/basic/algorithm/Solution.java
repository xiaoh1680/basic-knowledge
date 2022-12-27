package com.basic.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public class Solution {

    public static String get(String a,String b) {
        LinkedList<Integer> alist = new LinkedList<>();
        LinkedList<Integer> blist = new LinkedList<>();
        for (int i = 0; i < a.length(); i++) {
            alist.add(Integer.parseInt(a.charAt(i)+""));
        }
        for (int i = 0; i < b.length(); i++) {
            blist.add(Integer.parseInt(b.charAt(i)+""));
        }
        int blength = blist.size();
        StringBuilder result = new StringBuilder("0");
        for (int i = blength-1; i >=0; i--) {
            int s=blength-i-1;
            LinkedList<Integer> astr = new LinkedList<>();
            while (s > 0) {
                s--;
                astr.offerLast(0);
            }
            int mul = blist.get(i);
            int r = 0;
            for (int j = alist.size()-1; j>=0; j--) {
                int res = alist.get(j) * mul + r;
                astr.offerLast(res % 10);
                r = res / 10;
            }
            if (r > 0) {
                astr.offerLast(r);
            }
            StringBuilder temp = new StringBuilder();
            while (astr.peek()!=null) {
                temp.append(astr.pollLast());
            }
            result = addString(result, temp);
        }
        return result.toString();
    }

    public static StringBuilder addString(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int r=0;
        while (i >= 0 || j >= 0 || r != 0) {
            int ta = i > -1 ? a.charAt(i) - '0' : 0;
            int tb = j > -1 ? b.charAt(j) - '0' : 0;
            int res = ta + tb + r;
            r = res / 10;
            result.append(res % 10);
            i--;
            j--;
        }
        return result.reverse();
    }
    public static void main(String[] args) {
        System.out.println(get("100", "1000"));
    }
}
