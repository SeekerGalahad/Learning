package com.wagic.code.learn;
/**
 * 题目描述： 请实现一个函数，将字符串的每个空格替换为"%20"。
 * 例如输入"We are happy",则输出"We%20are%20happy."。
 */
public class ReplaceBlankInString {

    public static String replace(String input) {

        StringBuilder output = new StringBuilder();

        if (input == null || input.length() == 0) {
            return null;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output.append("%");
                output.append("2");
                output.append("0");
            } else {
                output.append(input.charAt(i));
            }
        }

        return output.toString();
    }

    // 测试用例
    public static void main(String[] args) {
        ReplaceBlankInString test = new ReplaceBlankInString();
        // 输入的字符串包含空格：最后面，最前面，中间，连续空格
        String str1 = "We are happy.";
        String str2 = " Wearehappy.";
        String str3 = "Wearehappy. ";
        String str4 = "We   are   happy  .";
        //输入的字符串没有空格
        String str5="Wearehappy.";
        //特殊输入测试：字符串只有连续空格、只有一个空格、字符串是一个null指针、字符串是一个空字符串;
        String str6="    ";
        String str7=" ";
        String str8=null;
        String str9="";
        System.out.println(test.replace(str1));
        System.out.println(test.replace(str2));
        System.out.println(test.replace(str3));
        System.out.println(test.replace(str4));
        System.out.println(test.replace(str5));
        System.out.println(test.replace(str6));
        System.out.println(test.replace(str7));
        System.out.println(test.replace(str8));
        System.out.println(test.replace(str9));
    }
}
