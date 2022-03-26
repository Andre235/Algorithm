package com.geek.tree;


import com.geek.list.linked.Queue;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/1/3 16:57
 * @description: 二叉树
 */
public class BinaryTree<K extends Comparable<K>, V> {

    /**
     * 根节点
     */
    private Node root;
    /**
     * 记录树中元素个数
     */
    private int count;

    public int size() {
        return count;
    }

    public void put(K key,V value) {
        root = put(root, key, value);
    }

    /**
     * 向指定的node树中添加节点,并返回添加元素之后的树
     * @param node
     * @param key
     * @param value
     * @return
     */
    public Node put(Node node, K key,V value) {
        // 1.如果node子树为空
        if (node == null) {
            count++;
            return new Node(key, value, null, null);
        }
        // 2.如果node子树不为空
        // 2.1比较node节点的键和key的值的大小
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            // 如果key大于node节点的键，则继续寻找node节点的右子树
            node.right = put(node.right, key, value);
        } else if (compare < 0){
            // 如果key小于node节点的键，则继续寻找node节点的左子树
            node.left = put(node.left, key, value);
        } else {
            // 如果key等于node节点的键，则替换node节点的值为value即可
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    /**
     * 从指定的树node中，查找指定的key
     * @param node
     * @param key
     * @return
     */
    public V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        // 如果node子树不为空，比较node节点的键和key的大小
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            // 如果node.key < key，继续找node节点的右子树，重复以上步骤
            return get(node.right, key);
        } else if (compareResult < 0) {
            // 如果node.key > key，继续找node节点的左子树，重复以上步骤
            return get(node.left, key);
        } else {
            // 如果node.key == key，直接将value值赋值给node.value
            return node.value;
        }
    }

    public void delete(K key) {
        delete(root, key);
    }

    /**
     * 删除指定树node中 key对应的value，并且返回删除后的新树
     * @param node
     * @param key
     */
    public Node delete(Node node, K key) {
        // 如果node树为null，则直接返回
        if (node == null) {
            return null;
        }

        // node树不为null
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            // 如果key大于node节点的键，则继续寻找node节点的右子树
            // 使删除后的新树等于node节点的右子树
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            // 如果key小于node节点的键，则继续寻找node节点的左子树
            node.left = delete(node.left, key);
        } else {
            // 让元素个数减一
            count --;

            // 如果key等于node节点的键，完成真正删除节点的动作，要删除的节点就是node
            // 1.找到右子树中最小的节点
            // 右子树为空，左子树不为空，则直接返回左子树
            if (node.right == null && node.left != null) {
                return node.left;
            }
            // 左子树为空，右子树不为空，则直接返回右子树
            if (node.left == null && node.right!= null) {
                return node.right;
            }
            // 2.如果node节点左子树不为空，并且右子树也不为空，则开始寻找右子树中最小的节点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 3.删除node节点的右子树的最小的节点
            Node tempNode = node.right;
            while (tempNode.left != null) {
                if (tempNode.left.left == null) {
                    tempNode.left = null;
                } else {
                    // 变换temp节点即可
                    tempNode = tempNode.left;
                }
            }

            // 4.让找出来的最小节点称为代替当前节点为位置（使最小节点成为当前节点的左子树的父节点，
            // 使最小节点成为当前节点的右子树的父节点，使当前节点的父节点称为最小节点的父节点）
            // 让node节点的左子树成为minNode节点的左子树
            minNode.left = node.left;
            // 让node节点的右子树成为minNode节点的右子树
            minNode.right = node.right;
            // 让node节点的父节点执行minNode
            node = minNode;
        }
        return node;
    }

    /**
     * 前序遍历
     * @return 获取整个树中所有的键
     */
    public Queue<K> preErgodic() {
        Queue<K> queue = new Queue<>();
        preErgodic(root, queue);
        return queue;
    }

    /**
     * 前序遍历
     * 获取指定树x中所有的键，并把所有的键放到keys队列中
     * @param x
     * @param keys
     */
    public void preErgodic(Node x, Queue<K> keys) {
        // 递归方法出口
        if (x == null) {
            return;
        }
        // 把x节点的key放入队列keys中
        keys.enqueue(x.key);

        // 递归遍历x节点的左子树
        if(x.left != null) {
            preErgodic(x.left, keys);
        }

        // 递归遍历x节点的右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    /**
     * 查找整个树中最下的键
     * @return
     */
    public K minKey() {
        return root != null ? minNode(root).key : null;
    }

    /**
     * 在指定树node中，查找最小键所在的节点
     * @param node
     * @return
     */
    public Node minNode(Node node) {
        // 需要判断node节点还有没有左子节点，如果有则继续找左子树，如果没有则node节点就是最小键所在节点
        if (node.left != null) {
            return minNode(node.left);
        } else {
            return node;
        }
    }

    /**
     * 在整个树中找到最大的键
     * @return
     */
    public K maxKey() {
        return root != null ? maxNode(root).key : null;
    }

    /**
     * 在node树中，找到最大键所在的节点
     * @param node
     * @return
     */
    public Node maxNode(Node node) {
        if (node.right != null) {
            return maxNode(node.right);
        } else {
            return node;
        }
    }


    private class Node {
        /**
         * 键
         */
        private K key;
        /**
         * 值
         */
        private V value;
        /**
         * 左子节点
         */
        private Node left;
        /**
         * 右子节点
         */
        private Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
