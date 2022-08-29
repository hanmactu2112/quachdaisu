#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        long long n; cin>>n;
        queue<long long> Q;
        Q.push(1);
        long long dem=0;
        while(!Q.empty()){
            long long m=Q.front();
            Q.pop();
            if(m<=n){
                dem++;
                Q.push(m*10);
                Q.push(m*10+1);
            }
        }
        cout << dem << endl;
    }
}