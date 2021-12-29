package com.geek.symbol.test;

import com.geek.symbol.SymbolTable;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/29 18:20
 * @description:
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> map = new SymbolTable<>();
        map.put(1, "vincy");
        map.put(2, "lucas");
        map.put(3, "natasha");
        System.out.println("符号表个数" + map.size());

        map.put(1, "VINCY");
        System.out.println(map.get(1));
        System.out.println("符号表个数" + map.size());

        map.delete(1);
        System.out.println("符号表个数" + map.size());
    }
}
