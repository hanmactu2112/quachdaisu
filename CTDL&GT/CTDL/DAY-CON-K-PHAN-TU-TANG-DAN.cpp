#include<bits/stdc++.h>
using namespace std;
int a[20], b[20], n, m;
void in(){
    for(int i=1;i<=m;i++){
        cout << a[b[i]] << " ";
    }
    cout << endl;
}
void Try(int i){
    for(int j=b[i-1]+1;j<=n;j++){
        b[i]=j;
        if(i==m) in();
        else Try(i+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m;
        for(int i=1;i<=n;i++){
            cin>>a[i];
        }
        sort(a,a+n+1);
        Try(1);
    }
}