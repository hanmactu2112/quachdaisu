#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        vector<int> a(n),b(n);
        for(int i=0;i<n;i++){
            cin>>a[i];
            b[i]=a[i];
        }
        sort(b.begin(),b.end());
        int m=n/2-1;
        int i=0;
        while(i<=m){
            if(a[i]>a[n-i-1]) swap(a[i],a[n-i-1]);
            i++;
        }
        int kt=0;
        for(int i=0;i<n;i++){
            if(a[i]!=b[i]){
                kt=1;
                break;
            }
            if(kt==1) break;
        }
        if(kt==0) cout << "Yes" << endl;
        else cout << "No" << endl;
    }
}