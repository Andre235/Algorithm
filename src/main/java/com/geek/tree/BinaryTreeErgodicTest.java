package com.geek.tree;

import com.geek.list.linked.Queue;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/26 11:37
 * @description:
 */
public class BinaryTreeErgodicTest {

    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        preErgodic(tree);
    }

    /**
     * 二叉树前序遍历
     * @param tree
     */
    private static void preErgodic(BinaryTree<String, String> tree) {
        Queue<String> keys = tree.preErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key + "------" + value);
        }
    }
}
