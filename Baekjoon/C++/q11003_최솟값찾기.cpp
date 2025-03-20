#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int main() 
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int N, L;
    cin >> N >> L;

    vector<int> arr(N);
    
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    
    deque<pair<int, int>> deq;
    
    for (int i = 0; i < N; i++) {
        if (!deq.empty() && deq.front().second <= i - L) {
            deq.pop_front();
        }
        
        while (!deq.empty() && deq.back().first > arr[i]) {
            deq.pop_back();
        }
        
        deq.emplace_back(arr[i], i);
        cout << deq.front().first << ' ';
    }
    
    return 0;
}
