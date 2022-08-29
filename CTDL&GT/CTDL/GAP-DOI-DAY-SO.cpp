#include<bits/stdc++.h>
using namespace std;
long long xuly(long long n, long long m){
    long long x=pow(2,n-1);
    if(m==x) return n;
    else if(m<x) return xuly(n-1,m);
    else return xuly(n-1,m-x);
}
main(){
    int t; cin >> t;
    while(t--){
        long long n,m;
        cin>>n>>m;
        cout << xuly(n,m);
        cout << endl;
    }
}
