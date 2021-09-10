package edu.ncu.dongli.leetcode.codelist;

import edu.ncu.dongli.leetcode.codelist.Struct.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoNodeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode dummy=head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if (l1!=null)
            head.next=l1;
        if (l2!=null)
            head.next=l2;
        return dummy.next;
    }
}
