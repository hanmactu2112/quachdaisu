#include <bits/stdc++.h>
using namespace std;
int a[15], n, b[15]={0};
bool check1(){
    for(int i=1; i<n; i++){
        if(abs(a[i]-a[i+1])==1) return false;
    }
    return true;
}
void in(){
    if(check1()){
        for(int i=1; i<=n; i++) cout << a[i];
        cout << endl;
    }
}
void Try(int i){
    for(int j=1; j<=n; j++){
        if(b[j]==0){
            a[i] = j; b[j] = 1;
            if(i==n) in();
            else Try(i+1);
            b[j] = 0;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        cin >> n;
        Try(1);
    }
}

