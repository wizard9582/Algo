from pprint import pprint

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
        root = ListNode()
        index = root
        
        while(list1 and list2):
            if(list1.val > list2.val):
                index.next = list2
                list2 = list2.next
                index = index.next
            else:
                index.next = list1
                list1 = list1.next
                index = index.next
        
        if(list1):
            index.next = list1
        elif(list2):
            index.next = list2
        
        return root.next
    

input = [[ListNode(1,ListNode(2, ListNode(4,None))),ListNode(1,ListNode(3, ListNode(4,None)))],
         [None,None],
         [None,ListNode(1,ListNode(3, ListNode(4,None)))],
         [ListNode(1,None),None]]

for i in input:
    answer = Solution().mergeTwoLists(i[0],i[1])
    while(answer):
        print(answer.val)
        answer = answer.next