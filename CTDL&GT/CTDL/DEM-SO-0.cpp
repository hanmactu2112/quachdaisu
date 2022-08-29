#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin>>n;
        vector<int> a(n);
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        int ans=upper_bound(a.begin(),a.end(),0)-a.begin();
        cout << ans << endl;
    }
}
