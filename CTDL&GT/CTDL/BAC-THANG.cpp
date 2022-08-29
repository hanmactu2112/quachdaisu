#include<bits/stdc++.h>
using namespace std;
long long MOD=1e9+7;
void xuly(int n, int m){
    int F[1000+5]={0};
    F[0]=1;F[1]=1;
    for(int i=2;i<=n;i++){
        for(int j=0;j<=min(i,m);j++){
            F[i]=F[i]+F[i-j];
            F[i]=F[i]%MOD;
        }
    }
    cout << F[n] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n,m; cin>>n>>m;
        xuly(n,m);
    }
}