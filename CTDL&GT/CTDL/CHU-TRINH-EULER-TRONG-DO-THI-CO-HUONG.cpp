#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int a[1005]={0};
        int n,m; cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            a[x]++;
            a[y]--;
        }
        int kt=1;
        for(int i=1;i<=n;i++){
            if(a[i]!=0){
                kt=0;
                break;
            }
        }
        if(kt==0) cout << "0" << endl;
        else cout << "1" << endl;
    }
}