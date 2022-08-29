#include<bits/stdc++.h>
using namespace std;
long long F[105][105][105];
void xuly(string a, string b, string c, int n, int m, int k){
    memset(F,0,sizeof(F));
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            for(int l=1;l<=k;l++){
                if(a[i-1]==b[j-1] && b[j-1]==c[l-1]){
                    F[i][j][l]=F[i-1][j-1][l-1]+1;
                }
                else F[i][j][l]=max(F[i-1][j][l] , max(F[i][j-1][l],F[i][j][l-1]));
            }
        }
    }
    cout << F[n][m][k] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n,m,k;
        string a,b,c;
        cin>>n>>m>>k;
        cin>>a>>b>>c;
        xuly(a,b,c,n,m,k);
    }
}