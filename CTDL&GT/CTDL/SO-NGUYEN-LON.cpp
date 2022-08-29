#include<bits/stdc++.h>
using namespace std;
long long F[1000+5][1000+5];
void xuly(string a, string b){
    int n1=a.size(),n2=b.size();
    memset(F,0,sizeof(F));
    for(int i=1;i<=n1;i++){
        for(int j=1;j<=n2;j++){
            if(a[i-1]==b[j-1]){
                F[i][j]=F[i-1][j-1]+1;
            } else {
                F[i][j]=max(F[i-1][j],F[i][j-1]);
            }
        }
    }
    cout << F[n1][n2];
}
main(){
    int t; cin>>t;
    while(t--){
        string a, b; cin>>a>>b;
        xuly(a,b);
        cout << endl;
    }
}