#include<bits/stdc++.h>
using namespace std;
int kt;
void tim(int *a, int n, int m, int x){
    for(int i=n;i<=m;i++){
        if(a[i]>=x){
            kt=0;
        }
    }
}
void tim1(int *a,int n, int m, int x){
    for(int i=n;i<=m;i++){
        if(a[i]<=x){
            kt=0;
        }
    }
}
void xuly(int *a, int st, int en){
    if(st>en) return;
    int mid=(st+en)/2;
    tim(a,st,mid-1,a[mid]);
    tim1(a,mid+1,en,a[mid]);
    xuly(a,st,mid-1);
    xuly(a,mid+1,en);
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n+5];
        for(int i=1;i<=n;i++) cin>>a[i];
        kt=1;
        xuly(a,1,n);
        cout << kt << endl;
    }
}