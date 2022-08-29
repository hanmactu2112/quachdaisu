#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        long long n,s; cin>>n>>s;
        long long a[n+5],sum=0;
        if(s==0){
            long long i,ans=0;
            int kt=1;
            for(i=0;i<n;i++){
                cin>>a[i];
                if(a[i]==0){
                    kt=0;
                }
            }
            if(kt==1) cout << "NO" << endl;
            else cout << "YES" << endl;
        }
        else {
            long long i,ans=0;
            for(i=0;i<n;i++){
                cin>>a[i];
            }
            int kt=1;
            for(i=0;i<n;i++){
                sum=sum+a[i];
                while(sum>s){
                    sum=sum-a[ans];
                    ans++;
                }
                if(sum==s){
                    kt=0;
                    break;
                }
            }
            if(kt==1) cout << "NO" << endl;
            else cout << "YES" << endl;
        }
    }
}