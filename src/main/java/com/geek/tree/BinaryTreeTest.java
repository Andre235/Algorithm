package com.geek.tree;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/2/20 18:27
 * @description: 二叉树简单测试
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建二叉查找树对象
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();

        // 插入功能测试
        binaryTree.put(1, "张三");
        binaryTree.put(2, "李四");
        binaryTree.put(3, "王五");
        System.out.println("插入完毕后元素的个数：" + binaryTree.size());

        // 查询功能测试
        System.out.println("键2对应的的值是：" + binaryTree.get(2));

        // 删除功能测试
        binaryTree.delete(2);
        System.out.println("删除键2后元素的个数：" + binaryTree.size());
        System.out.println("删除键2后,再次查询值为：" + binaryTree.get(2));
    }
}
