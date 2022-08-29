#include<bits/stdc++.h>
using namespace std;
int a[20], n;
void in(){
    cout << a[1];
    for(int i=2;i<=n;i++){
        if(a[i]==a[i-1]&& a[i]==0){
            cout << "0";
        }
        else if(a[i]==a[i-1] && a[i]==1){
            cout << "0";
        }
        if(a[i]!=a[i-1]){
            cout << "1";
        }
    }
    cout << " ";
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==n) in();
        else Try(i+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n;
        Try(1);
        cout << endl;
    }
}