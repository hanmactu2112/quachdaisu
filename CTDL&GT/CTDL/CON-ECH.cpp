#include<bits/stdc++.h>
using namespace std;
main(){
    long long F[1000+5];
    memset(F,0,sizeof(F));
    F[1]=1; F[2]=2; F[3]=4;
    for(int i=4;i<1000+5;i++) F[i]=F[i-1]+F[i-2]+F[i-3];
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        cout << F[n] << endl;
    }
}