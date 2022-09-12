/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
  let cnt = 0;
  let cur = head;
  while (cur) {
    cur = cur.next;
    cnt++;
  }
  let prev;
  cur = head;
  if (cnt - n === 0) {
    head = cur.next;
  } else {
    // prev, cur
    let index = 0;
    while (index < cnt - n) {
      index++;
      prev = cur;
      cur = cur.next;
    } // move
    prev.next = cur.next;
  }
  return head;
};
