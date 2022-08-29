#include<bits/stdc++.h>
using namespace std;
int t, n, k, a[20], b[20];
void xuat(){
    int dem=0;
    for(int i=1;i<=n;i++){
        if(a[i] == 1) dem++;
    }
    if(dem==k){
        for(int i=1;i<=n;i++){
            cout << a[i];
        }
    }
    cout << endl;
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==n) xuat();
        else Try(i+1);
    }
}
main(){
    cin >> t;
    while(t--){
        cin >> n >> k;
        Try(1);
    }
}
