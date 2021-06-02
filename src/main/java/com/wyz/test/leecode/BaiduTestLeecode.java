package com.wyz.test.leecode;

/**
 * 消除字符串中重复的字符串 好像妈祖的那个游戏
 */
public class BaiduTestLeecode extends AbstractLeecode{
    @Override
    public void onRun() {
        char[] chars = new char[test.length()] ;
        int point = -1 ;
        int idx = 0 ;
        for( ; idx < test.length() ; idx++){
            char c = test.charAt(idx);
            if(point == -1){
                chars[++point] = c ;
            }else{
                char d = chars[point] ;
                if(c == d){
                    point-- ;
                }else{
                    chars[++point] = c ;
                }
            }
        }
        idx = 0 ;
        System.out.print("--------------------\n");
        for (; idx <= point ; idx++  ){
            System.out.print(chars[idx]);
        }
        System.out.print("\n");
    }

    String test = "asdasdasd" ;
    @Override
    public void before() {

    }
}
