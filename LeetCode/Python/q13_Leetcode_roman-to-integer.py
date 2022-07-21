class Solution(object):
    def romanToInt(self, s: str) -> int:
        sum = 0
        i = 0
        symbol = {'I': 1, 'V': 5,'X': 10,'L': 50,'C': 100,'D': 500,'M': 1000}

        while(i < len(s)):
            if( i < len(s) - 1) :
                if(s[i] == 'I'):
                    if(s[i+1] == 'V'):
                        sum += 4
                        i += 1
                    elif(s[i+1] == 'X'):
                        sum += 9
                        i += 1
                    else : 
                        sum += symbol[s[i]]
                elif(s[i] == 'X'):
                    if(s[i+1] == 'L'):
                        sum += 40
                        i += 1
                    elif(s[i+1] == 'C'):
                        sum += 90
                        i += 1
                    else : 
                        sum += symbol[s[i]]
                elif(s[i] == 'C'):
                    if(s[i+1] == 'D'):
                        sum += 400
                        i += 1
                    elif(s[i+1] == 'M'):
                        sum += 900
                        i += 1
                    else : 
                        sum += symbol[s[i]]
                else : 
                    sum += symbol[s[i]]
            else:
                sum += symbol[s[i]]
            i += 1
        return sum


input = ["III","LVIII","MCMXCIV"]

for i in input:
    print(Solution().romanToInt(i))

# Solution().romanToInt(input[2])