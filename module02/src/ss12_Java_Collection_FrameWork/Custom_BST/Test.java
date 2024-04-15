package ss12_Java_Collection_FrameWork.Custom_BST;

public class Test {
    public static void main(String[] args) {
        CustomBST<Integer> customBST = new CustomBST<>();
        customBST.add(1);
        customBST.add(2);
        customBST.add(5);
        customBST.add(3);
        customBST.add(8);
        customBST.delete(8);
        customBST.traversePostOrder(customBST.getRoot());
    }
}
