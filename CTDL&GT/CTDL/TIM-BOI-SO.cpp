#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        queue<long long> Q;
        Q.push(9);
        int ok=1;
        while(1){
            long long x=Q.front();
            Q.pop();
            if(x%n==0){
                cout << x << endl;
                ok=0;
                break;
            }
            if(ok==0) break;
            Q.push(x*10);
            Q.push(x*10+9);
        }
    }
}