#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char s1[200001], s2[200001];
    char pre_s[200001];
    int j = 0;

    scanf("%s", s1);
    scanf("%s", s2);

    for (int i = 0; s1[i] != '\0'; i++) {
        if (s1[i] < 48 || s1[i] > 57) {
            pre_s[j++] = s1[i];
        }
    }
    pre_s[j] = '\0';

    if (strstr(pre_s, s2) != NULL){
        printf("1");
    }else{
        printf("0");
    }

    return 0;
}
