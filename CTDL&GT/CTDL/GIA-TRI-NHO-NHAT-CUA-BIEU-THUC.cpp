#include<bits/stdc++.h>
using namespace std;
bool cmp(int a,int b){
    return a>b;
}
main(){
    int t; cin>>t;
    while(t--){
        long long n;
        cin>>n;
        long long a[n],b[n];
        for(long long i=0;i<n;i++) cin>>a[i];
        for(long long i=0;i<n;i++) cin>>b[i];
        sort(a,a+n);
        sort(b,b+n,cmp);
        long long ans=0;
        for(int i=0;i<n;i++){
            ans=ans+a[i]*b[i];
        }
        cout << ans << endl;
    }
}