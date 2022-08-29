#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while (t--){
        int n; cin>>n;
        vector<int> a(n);
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        sort(a.begin(),a.end());
        int mid;
        if(n%2==0) mid = n/2-1;
        else mid = n/2;
        int r=n-1, ans=0;
        for(int i=mid;i>=0;i--){
            if(a[r]>=2*a[i]){
                ans++;
                r--;
            }
        }
        cout << n - 2*ans + ans << endl;
    }
}