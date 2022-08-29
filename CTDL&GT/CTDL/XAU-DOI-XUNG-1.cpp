#include<bits/stdc++.h>
using namespace std;
long long F[1000][1000];
void qhd(string s){
    string s1=s;
    reverse(s1.begin(),s1.end());
    memset(F,0,sizeof(F));
    int n=s.size();
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(s[i-1]==s1[j-1]){
                F[i][j]=F[i-1][j-1]+1;
            }
            else F[i][j]=max(F[i-1][j],F[i][j-1]);
        }
    }
    cout << n-F[n][n];
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        qhd(s);
        cout << endl;
    }
}