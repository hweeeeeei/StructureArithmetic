package com.hwei.structure.linkedlist;

import java.util.Stack;

// 栈的基本使用
public class TestStack {


     public static void main(String [] args){

         Stack<String> stack = new Stack<>();

         // 入栈
         stack.add("jack");
         stack.add("tom");
         stack.add("smith");

         while (stack.size()>0){
             // 取出栈顶数据
             String pop = stack.pop();
             System.out.println(pop);
         }

     }
}
