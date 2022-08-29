#include<bits/stdc++.h>
using namespace std;
int tim(int a[], int n, int x){
    for(int i=0;i<n;i++){
        if(x==a[i]) return i;
    }
    return -1;
}
void xuly(int a[], int b[], int n){
    int x = tim(a,n,b[0]);
    if(x!=0){
        xuly(a,b+1,x);
    }
    if(x!=n-1){
        xuly(a+x+1,b+x+1,n-x-1);
    }
    cout << b[0] << " ";
}
main(){
    int t; cin>>t;
    while(t--){
        int n;
        cin>>n;
        int a[n+5],b[n+5];
        for(int i=0;i<n;i++) cin>>a[i];
        for(int i=0;i<n;i++) cin>>b[i];
        xuly(a,b,n);
        cout << endl;
    }
}