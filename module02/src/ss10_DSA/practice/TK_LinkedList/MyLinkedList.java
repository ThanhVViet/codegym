package ss10_DSA.practice.TK_LinkedList;

public class MyLinkedList {
    private  Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, Object data) {
        Node temp = head;
        //Nút tạm thời này được sử dụng để duyệt danh sách liên kết và tìm vị trí chèn mới.
        Node holder;
        //Khai báo một nút holder để lưu giữ nút tiếp theo của nút tạm thời (temp) ban đầu.
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
     /*   Vòng lặp for được sử dụng để di chuyển nút tạm thời (temp) đến vị trí chèn mới trong danh sách liên kết.
        Vòng lặp dừng lại khi đạt đến vị trí chèn hoặc khi nút tiếp theo của temp là null (đã đến cuối danh sách).*/
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
       /* Gán nút tiếp theo của nút mới (temp.next.next) bằng holder.
        Điều này đảm bảo rằng nút mới được chèn đúng vị trí và trỏ tới nút ban đầu của vị trí chèn.*/
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    // lay phan tu index
    public Node get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
