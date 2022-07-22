class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        sDict = {}
        tDict = {}
        idx = 0

        for i in range(0,len(s)):
            if(not (s[i] in sDict) and not (t[i] in tDict)):
                sDict[s[i]] = idx
                tDict[t[i]] = idx
                idx += 1
            elif(s[i] in sDict and t[i] in tDict):
                if(sDict[s[i]] != tDict[t[i]]):
                    return False
            else: 
                return False
        
        return True

input = [["egg","add"],["foo","bar"],["paper","title"]]

for i in input:
    print(Solution().isIsomorphic(i[0],i[1]))