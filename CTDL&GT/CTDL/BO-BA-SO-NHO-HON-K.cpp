#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        long long n, k;
        cin >> n >> k;
        long long a[n];
        for(long long i=0;i<n;i++) cin >> a[i];
        sort(a,a+n);
        long long dem=0;
        for(long long i=0;i<n;i++){
            long long x = a[i];
            long long l=i+1,r=n-1;
            while(l<r){
                if(x+a[l]+a[r]>=k) r--;
                else {
                    dem=dem+r-l;
                    l++;
                }
            }
        }
        cout << dem << endl;
    }
}
