package ss12_Java_Collection_FrameWork.practice_BST;

public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    boolean insert(E e);

    /**
     * Inorder traversal from the root
     */
    void inorder();

    /**
     * Get the number of nodes in the tree
     */
    int getSize();
}
