#include<bits/stdc++.h>
using namespace std;
main(){
    long long F[30][30];
    for(int i=0;i<30;i++){
        for(int j=0;j<30;j++){
            if(i==0||j==0) F[i][j]=1;
            else {
                F[i][j]=F[i-1][j]+F[i][j-1];
            }
        }
    }
    int t; cin>>t;
    while(t--){
        int n,m; cin>>n>>m;
        cout << F[n][m] << endl;
    }
}