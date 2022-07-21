
class Solution(object):
    def romanToInt(self, s: str) -> int:
        symbolValue = {'I': 1, 'IV':4, 'V': 5, 'IX':9, 'X': 10, 'XL':40, 'L': 50, 'XC':90, 'C': 100, 'CD': 400, 'D': 500, 'CM': 900, 'M': 1000}
        sum = 0
        i = 0

        while(self.indexInString(i, s)):
            if(self.indexInString(i+1, s) and s[i: i+2] in symbolValue):
                sum += symbolValue[s[i: i+2]]
                i += 2
            else:
                sum += symbolValue[s[i]]
                i += 1
        return sum

    def indexInString(self, i: int, s:str)-> bool:
        return i < len(s)



input = ["III","LVIII","MCMXCIV"]

for i in input:
    print(Solution().romanToInt(i))

# Solution().romanToInt(input[2])