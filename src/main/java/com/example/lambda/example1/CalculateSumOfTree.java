package com.example.lambda.example1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateSumOfTree {


    private static class TNode{
        public int value;
        public List<TNode> subNodes;

        public TNode(int value) {
            this.value = value;
        }

        public TNode(int value, TNode...arrSubNodes) {
            this.value = value;
            this.subNodes = Arrays.asList(arrSubNodes);
        }
    }

//    public static int sumAllNodes(TNode root){
//        List<TNode> nodes = root.subNodes;
//        int sum = root.value;
//        for(TNode node : nodes) {
//            if (node.subNodes.size() > 0 ) {
//                sum += sumAllNodes(node);
//            } else {
//                sum += node.value;
//            }
//        }
//
//        return sum;
//    }

    public static int sumAllNodes(TNode root){
//        return root.value + root.subNodes.stream().flatMapToInt(TNode::sumAllNodes(root)).collect(Collectors.summingInt()).sum();
//        return root.value + root.subNodes.stream();
        return -1;
    }
}