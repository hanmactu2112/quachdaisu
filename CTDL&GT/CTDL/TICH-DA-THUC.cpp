#include<bits/stdc++.h>
using namespace std;
void xuly(int a[], int n, int b[], int m){
    int res[10000]={0};
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            res[i+j]=res[i+j]+a[i]*b[j];
        }
    }
    for(int i=0;i<n+m-1;i++){
        cout << res[i] << " ";
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n, m; cin>>n>>m;
        int a[n],b[m];
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        for(int j=0;j<m;j++){
            cin>>b[j];
        }
        xuly(a,n,b,m);
        cout << endl;
    }
}
