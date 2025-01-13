import sys


def myprint(n):
    if n % 3 == 0:
        if n % 5 == 0:
            print("FizzBuzz")
        else:
            print("Fizz")
    elif n % 5 == 0:
        print("Buzz")

    else:
        print(n)


a, b, c = sys.stdin.readline(), sys.stdin.readline(), sys.stdin.readline()

if a[0] != "F" and a[0] != "B":
    myprint(int(a) + 3)
elif b[0] != "F" and b[0] != "B":
    myprint(int(b) + 2)
else:
    myprint(int(c) + 1)