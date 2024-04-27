package dsd_create;

import java.util.Scanner;

public class Task3 {
    static Scanner sc=new Scanner(System.in,"cp1251");
    public static Node CreateHead()
    {System.out.print("\nРазмер списка с головы -> ");
        int n = sc.nextInt();
        System.out.print((1)+") -> ");
        Node head=new Node(sc.nextInt(), null);
        Node tail=head;
        for (int i=0;i<n-1; i++)
        {
            System.out.print((i+2)+") -> ");
            int e = sc.nextInt();
            tail.next=new Node(e, null);
            tail=tail.next;
        }
        return head;
    }

    public static void toString(Node head)
    { // ref – рабочая переменная для текущего узла
        Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }}
    public static Node CreateTail()
    {System.out.print("\nРазмер списка с хвоста -> ");
        int n = sc.nextInt();
        Node head=null;
        for (int i=n;i>0; i--)
        {
            System.out.print((i)+") -> ");
            int e = sc.nextInt();
            head=new Node(e, head);
        }
        return head;
    }
    public static Node AddFirst(Node head)
    {
        System.out.print("\nДобавление элемента в начало списка -> ");
        int newValue = sc.nextInt();
        head = new Node(newValue, head);
        return head;
    }
    public static Node AddLast(Node head)
    {
        System.out.print("\nДобавление элемента в конец списка -> ");
        int newValue = sc.nextInt();
        Node newtail=new Node(newValue, null);
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next=newtail;
        return head;
    }
    public static Node Insert(Node head) {
        System.out.print("\nДобавление элемента в список в указанное место -- > ");
        int n = sc.nextInt();
        System.out.print("Элемент -- > ");
        int newValue = sc.nextInt();
        Node newNode = new Node(newValue, null);
        Node ref = head;
        int k = 1;
        while (ref.next != null && (k<n)) {
            ref = ref.next;
            k++;
        }
        newNode.next = ref.next.next;
        ref.next = newNode;
        return head;

    }
    public static Node RemoveFirst(Node head)
    {
        System.out.print("\nУдаление элемента с начала списка ");
        return head.next;
    }
    public static Node RemoveLast(Node head) {
        System.out.print("\nУдаление последнего элемента списка ");
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }
    public static Node Remove(Node head) {
        System.out.print("\nУдаление элемента с заданным номером из списка --> ");
        int n = sc.nextInt();
        Node ref = head;
        int k = 1;
        while (ref.next!= null && (k<n )) {
            ref = ref.next;
            k++;
        }
        ref.next = ref.next.next;
        return head;
    }
    public static Node сreateHeadRec(int index, int n) {
        if (index > n) {
            return null;
        }
        System.out.print((index) + ") -> ");

        Node node = new Node(sc.nextInt(), null);
        node.next = сreateHeadRec(index + 1, n);

        return node;
    }
    public static Node createTailRec(int n, Node head) {
        if (n <= 0) {
            return head;
        }

        System.out.print((n) + ") -> ");
        int e = sc.nextInt();
        return createTailRec(n - 1, new Node(e, head));
    }
    public static void toStringRec(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(" " + head.value);
        toString(head.next);
    }
    public static void main(String[] args) {
    Node head = CreateHead();
    toString(head);
    Node head2 = CreateTail();
    toString(head2);
    head = AddFirst(head);
    toString(head);
    head2 = AddLast(head2);
    toString(head2);
    head = Insert(head);
    toString(head);
    head2 = RemoveFirst(head2);
    toString(head2);
    head = RemoveLast(head);
    toString(head);
    head2 = Remove(head2);
    toString(head2);
    System.out.print("\nРазмер списка (рекурсивного) с головы -> ");
    int n = sc.nextInt();
    Node head3 = сreateHeadRec(1,n);
    toStringRec(head3);
    System.out.print("\nРазмер списка (рекурсивного) с хвоста -> ");
    n = sc.nextInt();
    Node head4 = createTailRec(n, null);
    toStringRec(head4);
    }

}

