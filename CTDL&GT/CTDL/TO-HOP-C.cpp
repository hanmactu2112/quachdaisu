#include<bits/stdc++.h>
using namespace std;
long long F[1000+5][1000+5];
int n,m;
long long mod=1e9+7;
void tinh(){
    memset(F,0,sizeof(F));
    for(int i=0;i<=1000;i++){
        for(int j=0;j<=i;j++){
            if(j==0||i==j) F[i][j]=1;
            else{
                F[i][j]=F[i-1][j]+F[i-1][j-1];
                F[i][j]=F[i][j]%mod;
            }  
        }
    }
}
main(){
    tinh();
    int t; cin>>t;
    while(t--){
        cin>>n>>m;
        cout <<F[n][m] << endl;
    }
}