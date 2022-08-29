#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n,m; cin>>n>>m;
        vector<int> a;
        for(int i=0;i<n;i++){
            int x; cin>>x;
            a.push_back(x);
        }
        sort(a.begin(),a.end());
        //for(int i=0;i<n;i++) cout << a[i] << " ";
        cout << endl;
        long long ans=0;
        for(int i=0;i<n;i++){
            int k=upper_bound(a.begin(),a.end(),a[i]-m)-a.begin();
            if(i-k>0) ans = ans + i-k;
        }
        cout << ans << endl;
    }
}