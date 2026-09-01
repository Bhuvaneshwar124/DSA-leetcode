/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode curr = head.next;
        ListNode right = curr.next;
        int[] ans = new int[2];
        int firstIdx = -1;
        int currIdx = 1;
        int prevIdx = -1;
        int minDist = Integer.MAX_VALUE;

        while(right != null){
            if(curr.val > left.val && curr.val > right.val || curr.val < left.val && curr.val < right.val){
                firstIdx = currIdx;
                prevIdx = firstIdx;
                left = curr;
                curr = right;
                right = right.next;
                currIdx++;
                break;
            }
            left = curr;
            curr = right;
            right = right.next;
            currIdx++;
        }
        if(prevIdx == -1){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        while(right != null){
            if(curr.val > left.val && curr.val > right.val || curr.val < left.val && curr.val < right.val){
                minDist = Math.min(minDist, currIdx - prevIdx);
                prevIdx = currIdx;
            }
            left = curr;
            curr = right;
            right = right.next;
            currIdx++;
        }
        if(prevIdx == firstIdx){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = minDist;
        ans[1] = prevIdx - firstIdx;

        return ans;
    }
}