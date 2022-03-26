package com.geek.tree;

import com.geek.list.linked.Queue;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/26 11:37
 * @description: 二叉树迭代测试类
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

//        preErgodic(tree);

//        middleErgodic(tree);

//        afterErgodic(tree);
        layerErgodic(tree);
    }


    /**
     * 二叉树前序遍历
     * @param tree
     */
    private static void preErgodic(BinaryTree<String, String> tree) {
        Queue<String> keys = tree.preErgodic();
        iteration(tree, keys);
    }

    private static void middleErgodic(BinaryTree<String, String> tree) {
        Queue<String> keys = tree.middleErgodic();
        iteration(tree, keys);
    }

    private static void afterErgodic(BinaryTree<String, String> tree) {
        Queue<String> keys = tree.afterErgodic();
        iteration(tree, keys);
    }

    private static void layerErgodic(BinaryTree<String, String> tree) {
        Queue<String> keys = tree.layerErgodic();
        iteration(tree, keys);
    }

    private static void iteration(BinaryTree<String, String> tree, Queue<String> keys) {
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key + "------" + value);
        }
    }
}
