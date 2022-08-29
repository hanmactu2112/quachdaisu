#include<bits/stdc++.h>
using namespace std;
void xuLy(int a[], int n, int k){
    int i=k-1;
    while(i>=0 && a[i]> n-k+i){
        i--;
    }
    if(i==-1){
        for(int ii=1;ii<=k;ii++){
            cout << ii << " ";
        }
    } else {
        a[i]=a[i]+1;
        for(int j=i+1;j<n;j++){
            a[j]=a[i]+j-i;
        }
        for(int j=0;j<k;j++){
            cout << a[j] << " " ;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        int n, k; cin >> n >> k;
        int a[n];
        for(int i=0;i<k;i++) cin >> a[i];
        xuLy(a,n,k);
        cout << endl;
    }
}
