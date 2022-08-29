#include<bits/stdc++.h>
using namespace std;
int F[1000][1000];
void xuly(string s){
    int n=s.size();
    memset(F,0,sizeof(F));
    for(int i=0;i<n;i++) F[i][i]=1;
    int i,j,k;
    int ans=1;
    for(k=1;k<n;k++){
        for(i=0;i<n-k;i++){
            j=i+k;
            if(s[i]==s[j] && k==1) F[i][j]=1;
            else if(s[i]==s[j]) F[i][j]=F[i+1][j-1];
            else F[i][j]=0;
            if(F[i][j]==1) ans=max(ans,j-i+1);
        }
    }
    cout << n-ans << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}