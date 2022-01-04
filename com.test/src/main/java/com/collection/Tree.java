package com.collection;

public class Tree {
    private static Tree createdTree = new Tree();
    private Tree leftNode;
    private int value = 0;
    private Tree rightNode;

    public static void main(String[] args) {
        int[] array = new int[]{6, 3, 2, 5, 4, 1, 8, 7, 9};
        for (int i = 0; i < array.length; i++) {
            CreateTree(array[i], createdTree);
        }
        FindTreeValue(createdTree, 7, 0);
    }

    public static void CreateTree(int value, Tree tree) {
        // 如果当前二叉树是空的，拿第一个元素做头节点
        if (tree.getValue() == 0) {
            tree.setValue(value);
        }
        // 小放左，相等暂时不用管
        if (tree.getValue() > value) {
            if (tree.getLeftNode() == null) {
                // 如果左节点空，直接设置
                Tree leftTree = new Tree();
                leftTree.setValue(value);
                tree.setLeftNode(leftTree);
            } else if (tree.getLeftNode() != null) {
                // 如果左节点不为空，递归调用继续找左节点数据比较大小
                CreateTree(value, tree.getLeftNode());
            }
        }
        // 大放右，相等暂时不用管
        if (tree.getValue() < value) {
            if (tree.getRightNode() == null) {
                Tree rightTree = new Tree();
                rightTree.setValue(value);
                tree.setRightNode(rightTree);
            } else if (tree.getRightNode() != null) {
                CreateTree(value, tree.getRightNode());
            }
        }
    }

    public static void FindTreeValue(Tree tree, int value, int findTimes) {
        if (tree.getValue() == value) {
            System.out.println("第" + findTimes + "次找到了");
        } else {
            if (tree.getValue() > value && tree.getLeftNode() != null) {
                System.out.println("左");
                FindTreeValue(tree.getLeftNode(), value, findTimes + 1);
            } else if (tree.getValue() < value && tree.getRightNode() != null) {
                System.out.println("右");
                FindTreeValue(tree.getRightNode(), value, findTimes + 1);
            } else {
                System.out.println("树中没有该数值");
            }
        }
    }

    public Tree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Tree leftNode) {
        this.leftNode = leftNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getRightNode() {
        return rightNode;
    }

    public void setRightNode(Tree rightNode) {
        this.rightNode = rightNode;
    }

}
