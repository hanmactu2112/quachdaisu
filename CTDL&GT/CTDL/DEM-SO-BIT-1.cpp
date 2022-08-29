#include<bits/stdc++.h>
using namespace std;
long long tim(long long i, long long n, long long k){
    if(i%2==1) return 1;
    if(i==k){
        return n%2;
    }
    if(i>k) return tim(i-k,n/2,k/2);
    return tim(i,n/2,k/2);
}
main(){
    int t; cin>>t;
    while(t--){
        long long n,l,r;
        cin>>n>>l>>r;
        long long ans=0;
        long long k = pow(2,(long long)(log2(n)));
        for(long long i=l;i<=r;i++){
            ans=ans+tim(i,n,k);
        }
        cout << ans << endl;
    }
}