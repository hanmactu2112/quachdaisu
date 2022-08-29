#include<bits/stdc++.h>
using namespace std;
long long mod=1e9+7;
void xuly(int a[],int n,int s){
    long long F[1000+5]={0};
    F[0]=1;
    for(int i=1;i<=s;i++){
       for(int j=0;j<n;j++){
            if(i>=a[j]){
                F[i]=F[i]+F[i-a[j]];
                F[i]=F[i]%mod;
            }
       }
    }
    cout << F[s] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n,s;
        cin>>n>>s;
        int a[n];
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        xuly(a,n,s);
    }
}
