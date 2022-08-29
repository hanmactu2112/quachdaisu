#include <bits/stdc++.h>
using namespace std;
int t;
long long n,k;
long long mod=1e9+7;
long long luythua(long long a, long long b){
    if(b==0) return 1;
    if(b%2==0) return ((luythua(a,b/2)%mod)*(luythua(a,b/2)%mod))%mod;
    else return a*(luythua(a,b-1)%mod)%mod;
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		cout<<luythua(n,k)<<endl;
	}
}
 
