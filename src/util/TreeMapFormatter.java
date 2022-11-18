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
            if (trees.containsKey(entry.getKey()))
                tree = trees.get(entry.getKey());
            else {
                tree = findTreeFromChildren(entry.getKey(), trees);
                if (tree == null)
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

    private Tree<Integer> findTreeFromChildren(int key, Map<Integer, Tree<Integer>> trees) {

        for (Map.Entry<Integer, Tree<Integer>> entry : trees.entrySet()) {
            for (int i = 0; i < entry.getValue().getChildren().size(); i++) {
                if (key == entry.getValue().getChildren().get(i).getItem())
                    return entry.getValue().getChildren().get(i);
            }
        }
        return null;
    }


}
