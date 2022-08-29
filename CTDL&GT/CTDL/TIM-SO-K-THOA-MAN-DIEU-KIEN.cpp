#include<bits/stdc++.h>
using namespace std;
bool check(int n){
    priority_queue<int,vector<int>> p;
    while(n>0){
        int m=n%10;
        if(m>5) return false;
        p.push(m);
        n=n/10;
    }
    while(p.size()>1){
        int m=p.top();
        p.pop();
        if(m==p.top()){
            return false;
        }
    }
    return true;
}
main(){
    int t; cin>>t;
    while(t--){
        int dem=0;
        int n,m; cin>>n>>m;
        if(n>m) swap(n,m);
        for(int i=n;i<=m;i++){
            if(check(i)==true){
                dem++;
            }
        }
        cout << dem << endl;
    }
}