#include<bits/stdc++.h>
using namespace std;
int F[40005], A[2005], n,s;
int kt(){
    int i,j;
    memset(F,0,sizeof(F));
    F[0]=1;
    for(int i=1;i<=n;i++){
        for(int j=s;j>=A[i];j--){
            if(F[j]==0 && F[j-A[i]]==1){
                F[j]=1;
            }
        }
    }
    return F[s];
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>s;
        for(int i=1;i<=n;i++) cin>>A[i];
        if(kt()) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
}