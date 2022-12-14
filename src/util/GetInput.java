package util;

import data.Tree;
import iterate.*;

import java.util.*;

public class GetInput {
    public Map<Integer, ArrayList<Integer>> getTree() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, ArrayList<Integer>> treesMap = new HashMap<>();
        System.out.println("Enter your Tree with this format : index value\nExample: 1 2\nTo exit just write -1");
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("-1")) return treesMap;

            int key = Integer.parseInt(str.split(" ")[0]);
            int value = Integer.parseInt(str.split(" ")[1]);

            if (treesMap.containsKey(key)) {
                ArrayList<Integer> children = treesMap.get(key);
                children.add(value);
                treesMap.put(key, children);
            } else {
                ArrayList<Integer> child = new ArrayList<>();
                child.add(value);
                treesMap.put(key, child);
            }
        }
    }


    public static void main(String[] args) {
        GetInput input = new GetInput();
        Map<Integer, ArrayList<Integer>> trees = input.getTree();
        TreeMapFormatter formatter = new TreeMapFormatter();
        Tree<Integer> tree = formatter.format(trees);

        PreOrder<Integer> preOrder = new PreOrder<>();
        InOrder inOrder = new InOrder();
        PostOrder postOrder = new PostOrder();
        XPreOrder xPreOrder = new XPreOrder();
        XInOrder xInOrder = new XInOrder();

        Queue<Integer> queue = preOrder.iterate(tree, new ArrayDeque<>());
        queue.forEach(integer -> System.out.print(" "+integer));
        System.out.println();

        Queue<Integer> inOrderQueue = inOrder.iterate(tree, new ArrayDeque<>());
        inOrderQueue.forEach(integer -> System.out.print(" "+integer));
        System.out.println();

        Queue<Integer> postOrderQueue = postOrder.iterate(tree, new ArrayDeque<>());
        postOrderQueue.forEach(integer -> System.out.print(" "+integer));

        System.out.println("\n");
        Queue<Integer> xPreOrderQueue = xPreOrder.iterate(tree);
        xPreOrderQueue.forEach(integer -> System.out.print(" "+integer));

//        System.out.println();
//        Queue<Integer> xInOrderQueue = xInOrder.iterate(tree);
//        xInOrderQueue.forEach(integer -> {
//            System.out.print(" "+integer);
//        });
    }
}
