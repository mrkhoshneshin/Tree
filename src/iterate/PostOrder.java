package iterate;

import data.Tree;

import java.util.Queue;

public class PostOrder {
    public Queue<Integer> iterate(Tree<Integer> tree, Queue<Integer> queue){
        Tree<Integer> tree1 = tree.getMostLeftChild();
        while (tree1 != null){
            iterate(tree1, queue);
            tree1 = tree1.getNextSibling();
        }
        queue.add(tree.getItem());
        return queue;
    }
}
