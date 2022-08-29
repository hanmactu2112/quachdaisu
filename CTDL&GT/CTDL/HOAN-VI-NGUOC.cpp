#include<bits/stdc++.h>
using namespace std;
int n, a[20], b[20]={0};
void in(){
    for(int i=1;i<=n;i++) cout << a[i];
    cout << " ";
}
void Try(int i){
    for(int j=n;j>=1;j--){
        if(b[j]==0){
            a[i]=j;
            b[j]=1;
            if(i==n) in();
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        cin >> n;
        Try(1);
        cout << endl;
    }
}
