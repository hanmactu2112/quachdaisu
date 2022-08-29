#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        long long a[n];
        for(int i=0;i<n;i++){
            cin >> a[i];
        }
        map<long long, int> mp;
        for(int i=0;i<n;i++){
            mp[a[i]]++;
        }
        int kt=1;
        for(int i=0;i<n;i++){
            if(mp[a[i]]!=1){
                kt=0;
                cout << a[i];
                break;
            }
        }
        if(kt==1) cout << "NO" ;
        cout << endl;
    }
}
