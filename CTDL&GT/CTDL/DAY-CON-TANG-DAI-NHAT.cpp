#include<bits/stdc++.h>
using namespace std;
void xl(int a[] ,int n){
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
    cout << ans ;
}
main(){
    int n; cin>>n;
    int a[n];
    for(int i=0;i<n;i++) cin>>a[i];
    xl(a,n);
}