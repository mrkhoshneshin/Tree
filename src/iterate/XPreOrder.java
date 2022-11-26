package iterate;

import data.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class XPreOrder {
    public Queue<Integer> iterate(Tree<Integer> root) {
        if(root == null) return null;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root.getItem());
        root = root.getMostLeftChild();
        while (root != null){
            Tree<Integer> tree = root;
            while (tree != null) {
                queue.add(tree.getItem());
                if (tree.getMostLeftChild() == null)
                    tree = tree.getNextSibling();
                else tree = tree.getMostLeftChild();
            }
            root = root.getNextSibling();
        }
        return queue;
    }
}
