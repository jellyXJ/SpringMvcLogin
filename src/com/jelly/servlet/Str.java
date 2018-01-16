package com.jelly.servlet;

public class Str {
    public static void main(String[] args) {
        String s="2017;2018;17846;;;";
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i =0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)==stringBuilder.charAt(i+1)&& stringBuilder.charAt(i)==';'){



            }

        }

    }
}
