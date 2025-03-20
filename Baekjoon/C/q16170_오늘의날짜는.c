#include <stdio.h>
#include <time.h>

int main(void) {
	time_t t = time(NULL);
    struct tm tm = *localtime(&t);

    int year = tm.tm_year + 1900;
    int month = tm.tm_mon + 1;
    int day = tm.tm_mday;

    printf("%d\n%02d\n%02d", tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday);

	return 0;
}