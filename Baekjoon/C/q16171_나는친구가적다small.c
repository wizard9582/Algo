#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char s1[100], s2[100];
    char pre_s[100];
    int j = 0;

    scanf("%s", s1);
    scanf("%s", s2);

    for (int i = 0; i < strlen(s1); i++) {
        if (s1[i] < 48 || s1[i] > 57) {
            pre_s[j++] = s1[i];
        }
    }

    if (strstr(pre_s, s2) != NULL){
        printf("1");
    }else{
        printf("0");
    }

    return 0;
}
