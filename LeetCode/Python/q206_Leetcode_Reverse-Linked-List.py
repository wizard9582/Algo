class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if(not head or not head.next):
            return head
        
        rest = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return rest

input = ListNode(1,ListNode(2, ListNode(3,ListNode(4, ListNode(5,None)))))
# input = None

answer = Solution().reverseList(input)
while(answer):
    print(answer.val)
    answer = answer.next