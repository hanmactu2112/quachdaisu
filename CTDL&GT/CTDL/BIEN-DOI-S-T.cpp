#include<bits/stdc++.h>
using namespace std;
void xuly(int n, int m){
    int a[2005];
    for(int i=1;i<=2000;i++) a[i]=INT_MAX;
    queue<int> Q;
    Q.push(n);
    a[n]=0;
    while(a[m]==INT_MAX){
        int j=Q.front();
        Q.pop();
        if(j-1>0 && a[j-1]==INT_MAX){
            a[j-1]=a[j]+1;
            Q.push(j-1);
        }
        if(j*2<=2000 &&a[j*2]==INT_MAX){
            a[j*2]=a[j]+1;
            Q.push(j*2);
        }
    }
    cout << a[m] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n,m; cin>>n>>m;
        xuly(n,m);
    }
}