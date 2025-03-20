#include <iostream>
#include <unistd.h>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int N, M, i, j, k;
    cin >> N >> M;

    vector<int> arr(N + 1);

    for(int m = 0; m < M; m++){
        cin >> i >> j >> k;
        
        for(int t = i; t <= j; t++){
            arr[t] = k;
        }
    }

    string output;
    for(i = 1; i <= N; i++){
        output += to_string(arr[i]) + ' ';
    }

    write(1, output.c_str(), output.size());

    return 0;
}