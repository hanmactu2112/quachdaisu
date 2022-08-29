#include<bits/stdc++.h>
using namespace std;
void xl(int a[] ,long long n){
    long long F[1005]={0};
    long long ans=0;
    for(int i=0;i<n;i++){
        F[i]=1;
        for(int j=0;j<i;j++){
            if(a[i]>a[j]){
                F[i]=max(F[i],F[j]+1);
                ans=max(ans,F[i]);
            }
        }
    }
    cout << n-ans << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        long long n; cin>>n;
        int a[n];
        for(int i=0;i<n;i++) cin>>a[i];
        xl(a,n);
    }
}