package Assignment2.Assign1LL;
import java.io.*;
import java.util.*;
public class ListNode {
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    class GFG {

        static ListNode getNode(int data)
        {
            ListNode temp = new ListNode(data);
            return temp;
        }
        static void printList(ListNode head)
        {
            while (head.next != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.print(head.val);
        }
        static ListNode removeZeroSum(ListNode head, int K)
        {
            ListNode root = new ListNode(0);
            root.next = head;

            Map<Integer, ListNode> umap
                    = new HashMap<Integer, ListNode>();

            umap.put(0, root);
            int sum = 0;
            while (head != null) {


                sum += head.val;
                if (umap.containsKey(sum - K)) {

                    ListNode prev = umap.get(sum - K);
                    ListNode start = prev;
                    int aux = sum;
                    sum = sum - K;
                    while (prev != head) {
                        prev = prev.next;
                        aux += prev.val;
                        if (prev != head) {
                            umap.remove(aux);
                        }
                    }
                    start.next = head.next;
                }
                else if (!umap.containsKey(sum)) {
                    umap.put(sum, head);
                }

                head = head.next;
            }
            return root.next;
        }
        public static void main(String[] args)
        {
            ListNode head;
            head = getNode(1);
            head.next = getNode(2);
            head.next.next = getNode(-3);
            head.next.next.next = getNode(3);
            head.next.next.next.next = getNode(1);
            int K = 5;
            head = removeZeroSum(head, K);
            if (head != null)
                printList(head);
        }
    }

