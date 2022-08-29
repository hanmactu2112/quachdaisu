#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n,x; cin>>n>>x;
        int a[n];
        for(int i=0;i<n;i++) cin>>a[i];
        sort(a,a+n);
        x=min(x,n-x);
        long long s1=0,s2=0;
        for(int i=0;i<x;i++){
            s1=s1+a[i];
        }
        for(int i=x;i<n;i++){
            s2=s2+a[i];
        }
        cout << s2-s1 << endl;
    }
}