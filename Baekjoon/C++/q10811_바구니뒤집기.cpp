#include <iostream>
#include <unistd.h>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int N, M, i, j;
    cin >> N >> M;

    vector<int> arr(N + 1);

    for(i = 1; i <= N; i++){
        arr[i] = i;
    }

    for(int m = 0; m < M; m++){
        cin >> i >> j;
        
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1;
            j -= 1;
        }
    }

    string output;
    for(i = 1; i <= N; i++){
        output += to_string(arr[i]) + ' ';
    }

    write(1, output.c_str(), output.size());

    return 0;
}