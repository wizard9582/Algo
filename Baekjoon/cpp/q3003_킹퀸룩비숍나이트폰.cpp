#include <iostream>
#include <vector>

using namespace std;

int main() 
{
    vector<int> arr = {1, 1, 2, 2, 2, 8};
    
    for (int i = 0; i < 6; i++) {
        int n;
        cin >> n;
        cout << arr[i] - n << " ";
    }
    
    return 0;
}