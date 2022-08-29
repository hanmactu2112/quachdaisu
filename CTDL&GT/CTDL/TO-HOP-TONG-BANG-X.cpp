#include<bits/stdc++.h>
using namespace std;
int a[25], c[25], n, x , ok;
void in(int m){
    cout << "[";
    for(int i=1;i<m;i++){
        cout << c[i] << " ";
    }
    cout << c[m] << "]";
}
void Try(int i, int j, int sum){
    int k;
    for(k=j;k<=n;k++){
        if(sum+a[k]<=x&&a[k]>=c[i-1]){
            sum=sum+a[k];
            c[i]=a[k];
            if(sum==x){
                ok=1;
                in(i);
            }
            else Try(i+1,j+1,sum);
            sum=sum-a[k];
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        ok=0;
        cin>> n >> x;
        for(int i=1;i<=n;i++){
            cin>>a[i];

        }
        Try(1,1,0);
        if(ok==0) cout << "-1" << endl;
        cout << endl;
    }
}
