package com.wyz.test.leecode;

import com.wyz.test.Utils;

public class IsValid extends AbstractLeecode {
    /**
     * 使用栈  先进后出的思想
     * 只有对应的才能弹出 ,
     */
    @Override
    public void onRun() {
        final char[] push = new char[10]; // 创建一个简单的栈
        int point = 0; // 指针指向栈底
        boolean isok = true; // 字符串是否合格
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i); // 取第一个字符
            if (c == '{' || c == '(' || c == '[') {
                push[point++] = c; // 入栈操作
            } else {
                int curr  = point - 1 ; // 判断是否能够进行出栈
                if(curr >= 0){ // 可以进行出栈
                    if (c == ')' && push[curr] == '(') { // 正确出
                        point--;
                    } else if (c == ']' && push[curr] == '[') {// 正确出
                        point--;
                    } else if (c == '}' && push[curr] == '{') {// 正确出
                        point--;
                    } else { // 异常 可能 不对应  比如 [) 这一类
                        isok = false;
                    }
                }else{
                    isok = false; // 如果不能 祖父可能是 ] ]} }]) 这一类 直接错误
                }
            }
        }
        if(point != 0){ // 判断栈是否为空 如果不为空 则失败 [][][][
            isok = false;
        }
        Utils.println("%b" , isok);
    }

    String s;

    @Override
    public void before() {
        s = "[][][][";
    }
}
