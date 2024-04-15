package ss12_Java_Collection_FrameWork;

public class BST {
    static class TreeNode<E> {
        protected E element;
        protected
        TreeNode<E> left;
        protected TreeNode<E> right;
        public TreeNode(E e) {
            element = e;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
    }
//    public boolean search(E element) {
//        TreeNode<E> current = root;
//
//        while (current != null) {
//            if (element < current.element) {
//                current = current.left;
//            } else if (element > current.element) {
//                current = current.right;
//            } else
//                return true;
//        }
//        return false;
//    }
}
