#include<bits/stdc++.h>
using namespace std;
void xuly(int n){
    vector<int>a;
    while(n>=4){
        if(n%7==0){
            a.push_back(7);
            n=n-7;
            continue;
        } else if(n>=4){
            a.push_back(4);
            n=n-4;
            continue;
        } 
    }
    if(n>0) cout << "-1";
    else {
        for(int i=0;i<a.size();i++){
            cout << a[i];
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        xuly(n);
        cout << endl;
    }
}