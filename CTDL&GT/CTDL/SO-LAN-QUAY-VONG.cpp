#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        long long n; cin >> n;
        long long a[n],b[n];
        for(long long i=0;i<n;i++){
            cin>>a[i];
            b[i]=a[i];
        }
        sort(b,b+n);
        if(b[0]==a[0]){
            cout << "0" << endl;
        }
        else {
            long long ans;
            for(long long i=0;i<n-1;i++){
                if(a[i]>a[i+1]){
                    ans=i+1;
                    break;
                }
            }
            cout << ans << endl;
        }

    }
}
