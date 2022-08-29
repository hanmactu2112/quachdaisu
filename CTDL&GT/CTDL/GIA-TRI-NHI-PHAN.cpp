#include<bits/stdc++.h>
using namespace std;
main(){
    int n, t;
    cin>>n>>t;
    int a[n+5];
    memset(a,0,sizeof(a));
    while(t--){
        int x,y; cin>>x>>y;
        for(int i=x;i<=y;i++){
            if(a[i]==1) a[i]=0;
            else a[i]=1;
        }
    }
    for(int i=1;i<=n;i++){
        cout << a[i] << " ";
    }
}