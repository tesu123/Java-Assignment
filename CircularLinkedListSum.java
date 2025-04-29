import java.util.Scanner;

public class CircularLinkedListSum {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void sumOfEven() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int sum = 0;
        Node temp = head;
        do {
            if (temp.data % 2 == 0)
                sum += temp.data;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Sum of even numbers: " + sum);
    }

    public static void main(String[] args) {
        CircularLinkedListSum list = new CircularLinkedListSum();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the linked list");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Enter a valid size for linked list");
            sc.close();
            return;
        }
        System.out.println("Enter the nodes in the linked list");
        for (int i = 0; i < num; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }
        list.sumOfEven();
        sc.close();
    }
}