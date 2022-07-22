class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if(len(s) > len(t)):
            return False
        if(len(s) == 0):
            return True

        idx = 0
        for i in t:
            if(i == s[idx]):
                idx += 1
            if(len(s) == idx):
                return True
        return False

input = [["abc", "ahbgdc"],["axc", "ahbgdc"]]

for i in input:
    print(Solution().isSubsequence(i[0],i[1]))