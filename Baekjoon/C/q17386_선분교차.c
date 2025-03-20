#include <stdio.h>

long ccw(long ax, long ay, long bx, long by, long cx, long cy){
    long res = (bx - ax)*(cy - ay) - (by - ay)*(cx - ax);

    if (res > 0){
        return 1;
    }
    else if (res < 0){
        return -1;
    }
    else {
        return 0;
    }
}

int main() {
    long x1, y1, x2, y2, x3, y3, x4, y4;
    scanf("%ld %ld %ld %ld", &x1, &y1, &x2, &y2);
    scanf("%ld %ld %ld %ld", &x3, &y3, &x4, &y4);

    int c1 = ccw(x1, y1, x2, y2, x3, y3);
    int c2 = ccw(x1, y1, x2, y2, x4, y4);
    int c3 = ccw(x3, y3, x4, y4, x1, y1);
    int c4 = ccw(x3, y3, x4, y4, x2, y2);

    if (c1 * c2 < 0 && c3 * c4 < 0) {
        printf("1");
    } else {
        printf("0");
    }

    return 0;
}
