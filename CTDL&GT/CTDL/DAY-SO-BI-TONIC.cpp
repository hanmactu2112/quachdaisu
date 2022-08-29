#include<bits/stdc++.h>
using namespace std;
long long F[1000],C[1000];
int a[100],n;
void qhd(){
    memset(F,0,sizeof(F));
    memset(C,0,sizeof(C));
    long long ans = 0 ;
    for(int i=0;i<n;i++){
        F[i]=a[i];
        for(int j=0;j<i;j++){
            if(a[i]>a[j]){
                F[i]=max(F[i],F[j]+a[i]);
            }
        }
    }
    for(int i=n-1;i>=0;i--){
        C[i]=a[i];
        for(int j=n-1;j>i;j--){
            if(a[i]>a[j]){
                C[i]=max(C[i],C[j]+a[i]);
            }
        }
    }
    for(int i=0;i<n;i++){ 
        ans=max(ans,F[i]+C[i]-a[i]);
    }
    cout << ans << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n; 
        for(int i=0;i<n;i++) cin>>a[i];
        qhd();
    }
}