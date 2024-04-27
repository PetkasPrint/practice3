package dsd_create;

import java.util.Scanner;

public class Task4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Вариант 10.");
        Node head = CreateHead();
        toString(head);
        // а) Найти сумму, количество и среднее значение среди чисел, которые не делятся на 9.
        System.out.print("\na)");
        findSumCountAverage(head);
        // б) Найти среди отрицательных чисел, которые не делятся на 7, минимальное и максимальное значения и их номера и поменять их местами
        System.out.print("\nb)");
        swapMinMaxNegativeNumbers(head);
        toString(head);
    }

    private static void toString(Node head) {
    Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.data);
            ref = ref.next;
        }
        System.out.print("\n");
    }

    public static Node CreateHead() {
        System.out.print("\nРазмер списка с головы -> ");
        int n = sc.nextInt();
        System.out.print("1) -> ");
        Node head = new Node(sc.nextInt(), null);
        Node tail = head;
        for (int i = 0; i < n - 1; i++) {
            System.out.print((i + 2) + ") -> ");
            int e = sc.nextInt();
            tail.next = new Node(e, null);
            tail = tail.next;
        }
        return head;
    }

    public static void findSumCountAverage(Node head) {
        int sumNonDivisibleBy9 = 0;
        int countNonDivisibleBy9 = 0;
        Node current = head;
        while (current != null) {
            if (current.data % 9 != 0) {
                sumNonDivisibleBy9 += current.data;
                countNonDivisibleBy9++;
            }

            current = current.next;
        }

        double averageNonDivisibleBy9 = (double) sumNonDivisibleBy9 / countNonDivisibleBy9;

        System.out.println("Сумма чисел, не делящихся на 9: " + sumNonDivisibleBy9);
        System.out.println("Количество чисел, не делящихся на 9: " + countNonDivisibleBy9);
        System.out.println("Среднее значение чисел, не делящихся на 9: " + averageNonDivisibleBy9);
    }

    public static void swapMinMaxNegativeNumbers(Node head) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data < 0 && current.data % 7 != 0) {
                if (current.data < min) {
                    min = current.data;
                    minIndex = index;
                }
                if (current.data > max) {
                    max = current.data;
                    maxIndex = index;
                }
            }
            current = current.next;
            index++;
        }

        if (minIndex != -1 && maxIndex != -1) {
            System.out.println("Минимальное отрицательное число, не делящееся на 7: " + min + " с индексом " + minIndex);
            System.out.println("Максимальное отрицательное число, не делящееся на 7: " + max + " с индексом " + maxIndex);

            // Обмен местами минимального и максимального значения
            Node first = head;
            Node second = head;
            for (int i = 0; i < minIndex; i++) {
                first = first.next;
            }
            for (int i = 0; i < maxIndex; i++) {
                second = second.next;
            }

            int temp = first.data;
            first.data = second.data;
            second.data = temp;

            System.out.println("Обмен местами выполнен.");
        } else {
            System.out.println("Нет отрицательных чисел, не делящихся на 7, для обмена местами.");
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}