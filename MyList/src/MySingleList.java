/**
 * ClassName: MySingleList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/19 21:14
 * @Version 1.0
 */
public class MySingleList implements IList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;

//    public void createList() {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//
//        this.head = listNode1;
//    }

    @Override
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
//        if (this.head == null) {
//            this.head = listNode;
//            return;
//        }
        listNode.next = this.head;
        this.head = listNode;
    }

    @Override
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        ListNode tmp = this.head;
        if (tmp == null) {
            this.head = listNode;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = listNode;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new IndexIllegality("插入元素位置异常:" + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode tmp = searchPrev(index);
        ListNode listNode = new ListNode(data);
        listNode.next = tmp.next;
        tmp.next = listNode;
    }

    private ListNode searchPrev(int index) {
        ListNode tmp = this.head;
        while (index - 1 != 0) {
            tmp = tmp.next;
            --index;
        }
        return tmp;
    }

    @Override
    public boolean contains(int key) {
        ListNode tmp = this.head;
        while (tmp != null) {
            if (tmp.val == key) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("当前链表无数据，无法进行删除！");
            return;
        }

        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }

        ListNode tmp = findPrev(key);
        if (tmp == null) {
            System.out.println("要删除的数不存在！");
            return;
        }
        ListNode del = tmp.next;
        tmp.next = del.next;
    }

    private ListNode findPrev(int key) {
        ListNode tmp = this.head;
        while (tmp.next != null) {
            if (tmp.next.val == key) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int size() {
        int count = 0;
        ListNode tmp = this.head;
        while (tmp != null) {
            ++count;
            tmp = tmp.next;
        }
        return count;
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {
        ListNode tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}