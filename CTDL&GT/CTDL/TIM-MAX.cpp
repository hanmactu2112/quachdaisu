#include<bits/stdc++.h>
using namespace std;
long long MOD=1e9+7;
int main(){
    long long t; cin>>t;
    while(t--){
        long long n; cin>>n;
        vector<long long> a(n);
        for(int i=0;i<n;i++) cin>>a[i];
        sort(a.begin(),a.end());
        long long sum=0;
        for(int i=0;i<n;i++){
            sum = sum + (i*a[i]%MOD);
            sum=sum%MOD;
        }
        cout << sum << endl;
    }
}