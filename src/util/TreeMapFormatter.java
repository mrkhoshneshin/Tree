package util;

import data.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TODO change all map to tree
public class TreeMapFormatter {
    public Tree<Integer> format(Map<Integer, ArrayList<Integer>> treeMap) {
        Map<Integer, Tree<Integer>> trees = new HashMap<>();
        int counter = 1;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {
            Tree<Integer> tree;
            tree = findTree(entry.getKey(), trees.get(1), new ArrayList<>());
            if (tree == null){
                tree = new Tree<>(entry.getKey(), null);
            }
            for (int i = 0; i < entry.getValue().size(); i++) {
                tree.addChild(entry.getValue().get(i));
            }
            if (counter == 1)
                trees.put(entry.getKey(), tree);
            counter += 1;
        }
        return trees.get(1);
    }

    public Tree<Integer> findTree(int key, Tree<Integer> tree, ArrayList<Tree<Integer>> trees) {
        if (tree == null) return null;
        trees.add(tree);
        Tree<Integer> leftChild = tree.getMostLeftChild();

        while (leftChild != null) {
            findTree(key, leftChild, trees);
            leftChild = leftChild.getNextSibling();
        }

        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).getItem() == key)
                return trees.get(i);
        }
        return null;
    }
}
