#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    cin >> N;

    if(620 <= N){
        cout << "Red";
    }
    else if(590 <= N){
        cout << "Orange";
    }
    else if(570 <= N){
        cout << "Yellow";
    }
    else if(495 <= N){
        cout << "Green";
    }
    else if(450 <= N){
        cout << "Blue";
    }
    else if(425 <= N){
        cout << "Indigo";
    }
    else{
        cout << "Violet";
    }

    return 0;
}