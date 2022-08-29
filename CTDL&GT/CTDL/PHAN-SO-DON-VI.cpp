#include<bits/stdc++.h>
using namespace std;
void xuly(long long n, long long m){
    while(1){
        if(m%n==0){
            cout << "1" << "/" << m/n;
            break;
        }
        else {
            long long kq=m/n+1;
            cout << "1" << "/" << kq << " + ";
            n=kq*n-m;
            m=kq*m;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        long long n,m; cin>>n>>m;
        xuly(n,m);
        cout << endl;
    }
}