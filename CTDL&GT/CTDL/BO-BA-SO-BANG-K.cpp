#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        long long n, k; cin >> n >> k;
        long long a[n];
        for(long long i=0;i<n;i++) cin >> a[i];
        int kt = 1;
        sort(a,a+n);
        for(long long i=0;i<n;i++){
            long long x=a[i];
            long long l=i+1, r=n-1;
            while(l<r){
                if(x+a[l]+a[r]==k){
                    kt=0;
                    break;
                }
                else if(x+a[l]+a[r]<k) l++;
                else r--;
            }
            if(kt==0) break;
        }
        if(kt==1) cout << "NO" << endl;
        else cout << "YES" << endl;
    }
}
