package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 12:25 2025/5/12
 */
public class MergeKSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode MergeKSortedLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeList(lists,0,lists.length-1);
    }

    public static ListNode mergeList(ListNode[] lists,int left,int right){
        if(left == right){
            return lists[left];
        }
        int mid = left+(right-left)/2;
        ListNode l = mergeList(lists,left,mid);
        ListNode r = mergeList(lists, mid+1, right);
        return merge2List(l,r);
    }

    public static ListNode merge2List(ListNode l,ListNode r){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l != null && r != null){
            if(l.val<r.val){
                cur.next = l;
                l = l.next;
            }else{
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        cur.next = l == null? r:l;
        return dummy.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num  = sc.nextInt();
        sc.nextLine();
        ListNode[] lists = new ListNode[num];
        for(int i = 0;i< lists.length;i++){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            ListNode head = new ListNode(Integer.parseInt(split[0]));
            lists[i] = head;
            ListNode cur = head;
            for(int j = 1;j< split.length;j++){
                cur.next = new ListNode(Integer.parseInt(split[j]));
                cur = cur.next;
            }
        }
        ListNode node = MergeKSortedLists(lists);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }

    }

}
