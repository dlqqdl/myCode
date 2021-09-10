package edu.ncu.dongli.leetcode.codelist;

import edu.ncu.dongli.leetcode.codelist.Struct.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 尝试使用一趟扫描实现
 */
public class RemoveNthFormEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
            return null;
        ListNode preHead=new ListNode();
        preHead.next=head;//有可能有删除头节点的情况
        ListNode slow=preHead;
        ListNode fast=preHead;
        int sub=0;
        //遍历，使slow和fast之间差n个
        while (sub<n){
            fast=fast.next;
            sub++;
        }
        //slow和fast都往后走，直到fast到末尾
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        //此时slow就指向倒数第n-1个,删除后面一个
        slow.next=slow.next.next;
        return preHead.next;
    }
}
