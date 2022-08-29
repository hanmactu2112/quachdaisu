#include<bits/stdc++.h>
using namespace std;
long long mod=123456789;
long long luythua(long long a, long long b){
    if(b==0) return 1;
    if(b%2==0) return ((luythua(a,b/2)%mod)*(luythua(a,b/2)%mod))%mod;
    else return a*(luythua(a,b-1)%mod)%mod;
}
main(){
    int t; cin>>t;
    while(t--){
        long long n; cin>>n;
        cout << luythua(2,n-1) << endl;
    }
}
