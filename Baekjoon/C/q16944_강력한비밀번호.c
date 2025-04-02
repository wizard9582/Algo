#include <stdio.h>
#include <string.h>

int main() {
    int n;
    scanf("%d", &n);
    char s[n];
    scanf("%s", s);
    
    char special[] = "!@#$%^&*()-+";

    int num = 0, lowc = 0, upc = 0, spec = 0;

    for(int i = 0; i < n; i++){
        char c = s[i];
        if (c >= 48 && c <= 57) num = 1;
        if (c >= 97 && c <= 122) lowc = 1; 
        if (c >= 65 && c <= 90) upc = 1;
        for (int j = 0; j < 12; j++) {
            if (c == special[j]) {
                spec = 1;
                break;
            }
        }

    }

    int answer = 4 - (num + lowc + upc + spec);
    answer = (answer > 6 - n) ? answer : 6 - n;

    printf("%d", answer);

    return 0;
}
