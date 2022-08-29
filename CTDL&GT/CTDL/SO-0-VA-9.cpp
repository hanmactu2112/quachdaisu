#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        queue<long long> Q;
        Q.push(9);
        long long n; cin>>n;
        while(1){
            long long m=Q.front();
            Q.pop();
            if(m%n==0){
                cout << m << endl;
                break;
            }
            Q.push(m*10);
            Q.push(m*10+9);
        }
    }
}