package data;

import java.util.ArrayList;

public class Tree<T> {

    public Tree(
            T item,
            Tree<T> parent
    ) {
        this.parent = parent;
        this.item = item;
    }

    private Tree<T> parent;

    public ArrayList<Tree<T>> getChildren() {
        return children;
    }

    public void setNextSibling(Tree<T> nextSibling) {
        this.nextSibling = nextSibling;
    }

    private final ArrayList<Tree<T>> children = new ArrayList<>();
    private Tree<T> nextSibling;
    private T item;

    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }

    public Tree<T> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(Tree<T> last, Tree<T> next) {
        if (next.parent == last.parent)
            last.nextSibling = next;
        else
            System.out.println("both tree parents is not equal");
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void addChild(Tree<T> tree) {
        tree.parent = this;
        children.add(tree);
        if(children.size() == 1) return;
        Tree<T> lastSiblingChildren = findLastSiblingOfChildren();
        if (lastSiblingChildren != null)
            setNextSibling(lastSiblingChildren, tree);
    }

    public void addChild(T value) {
        Tree<T> tree = new Tree<>(value, this);
        tree.parent = this;
        children.add(tree);
        if(children.size() <= 1) return;
        Tree<T> lastSiblingChildren = findLastSiblingOfChildren();
        if (lastSiblingChildren != null)
            setNextSibling(lastSiblingChildren, tree);
    }

    public Tree<T> getMostLeftChild() {
        if (children.stream().findFirst().isPresent())
            return children.stream().findFirst().get();
        return null;
    }

    private Tree<T> findLastSiblingOfChildren() {
        return children.get(children.size() - 2);
    }

}
