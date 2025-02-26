#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N, M, r, s, e;
    cin >> N >> M;
    int answer = 0;

    vector<int> limit(100);

    e = 0;
    for(int i = 0; i < N; i++){
        cin >> r >> s;
        for(int j = e; j < e + r; j++){
            limit[j] = s;
        }
        e += r;
    }

    e = 0;
    for(int i = 0; i < M; i++){
        cin >> r >> s;
        for(int j = e; j < e + r; j++){
            answer = max(answer, s - limit[j]);
        }
        e += r;
    }

    cout << answer;

    return 0;
}