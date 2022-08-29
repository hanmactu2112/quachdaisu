#include<bits/stdc++.h>
using namespace std;
int a[20], n;
void in(int m){
    cout << "(";
    for(int i=1;i<m;i++){
        cout << a[i] << " ";
    }
    cout << a[m] << ")";
    cout << " ";
}
void Try(int i, int j, int sum){
    int k;
    for(k=j;k>=1;k--){
        if(sum+k<=n&&k<=a[i-1]){
            sum=sum+k;
            a[i]=k;
            if(sum==n) in(i);
            else Try(i+1,j,sum);
            sum=sum-k;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        a[0]=1e6;
        cin>>n;
        Try(1,n,0);
        cout << endl;
    }
}
