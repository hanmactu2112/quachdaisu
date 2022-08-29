#include<bits/stdc++.h>
using namespace std;
long long mod = 1e9+7;
long long xuly(int a, long long b){
    if(b==0) return 1;
    if(b%2==0) return xuly(a,b/2)*xuly(a,b/2)%mod;
    else return a*xuly(a,b-1)%mod;
}
int main(){
    while(1){
        int n;
        long long m;
        cin>>n>>m;
        if(n==0&&m==0) break;
        else {
            cout << xuly(n,m) << endl;
        }
    }
}
