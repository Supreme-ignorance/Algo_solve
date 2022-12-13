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
    public boolean isPalindrome(ListNode head) {
        StringBuilder input = new StringBuilder();

        ListNode now = head;
        input.append(now.val);

        while (now.next != null){
            now = now.next;
            input.append(now.val);
        }

        String palindrome = input.toString();
        int len = palindrome.length();

        for (int i = 0; i < len / 2; i++){
            if(palindrome.charAt(i) != palindrome.charAt(len - i - 1)){
                return false;
            }
        }

        return true;
    }
}