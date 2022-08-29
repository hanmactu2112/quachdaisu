#include<bits/stdc++.h>
using namespace std;
long long mod=1e9+7;
long long dao(long long a){
    long long sum=0;
    while(a>0){
        sum=sum*10+(a%10);
        a=a/10;
    }
    return sum;
}
long long luythua(long long a, long long b){
    if(b==0) return 1;
    if(b%2==0) return ((luythua(a,b/2)%mod)*(luythua(a,b/2)%mod))%mod;
    else return a*(luythua(a,b-1)%mod)%mod;
}
main(){
    int t; cin >> t;
    while(t--){
        long long n;
        cin>>n;
        long long m=dao(n);
        cout << luythua(n,m) << endl;
    }
}

