#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, x; cin >> n >> x;
        long long a[n];
        for(int i=0;i<n;i++) cin >> a[i];
        multiset<long long> b;
        for(int i=0;i<x;i++){
            b.insert(a[i]);
        }
        for(int i=x;i<n;i++){
            cout << *b.rbegin() << " ";
            b.erase(b.find(a[i-x]));
            b.insert(a[i]);
        }
        cout << *b.rbegin() << " ";
        cout << endl;
    }
}
