package iterate;

import data.Tree;

import java.util.Queue;

public class PreOrder<T> {
    public void iterate(Tree<T> tree, Queue<T> queue){
        queue.add(tree.getItem());
        Tree<T> leftChild = tree.getMostLeftChild();

        while (leftChild != null){
            iterate(leftChild, queue);
            leftChild = leftChild.getNextSibling();
        }
    }
}
