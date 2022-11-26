package iterate;

import data.Tree;

import java.util.Queue;

public class InOrder {
    public Queue<Integer> iterate(Tree<Integer> tree, Queue<Integer> queue){
        Tree<Integer> tree1 = tree.getMostLeftChild();
        if(tree1 != null){
            iterate(tree1,queue);
            queue.add(tree.getItem());
            tree1 = tree1.getNextSibling();
            while (tree1 != null){
                iterate(tree1,queue);
                tree1 = tree1.getNextSibling();
            }
        }
        else queue.add(tree.getItem());
        return queue;
    }
}
