package iterate;

import data.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class XInOrder {
    public Queue<Integer> iterate(Tree<Integer> root) {
        int counter = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Tree<Integer> currentTree = root.getMostLeftChild();
        Tree<Integer> tree = root;
        while (tree.getMostLeftChild() != null) {
            if (tree.getMostLeftChild() != null)
                tree = tree.getMostLeftChild();
            else {
                queue.add(tree.getItem());
                if (!queue.contains(tree.getParent().getItem()))
                    queue.add(tree.getParent().getItem());
                if (tree.getNextSibling() != null)
                    tree = tree.getNextSibling();
                else {
                    if (counter == 0)
                        queue.add(root.getItem());
                    counter++;
                    if(currentTree.getNextSibling() != null)
                        currentTree = currentTree.getNextSibling();
                    else break;
                }
            }
        }
        return queue;
    }
}
