#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int n,m,q; cin>>n>>m>>q;
        long long a[n],b[m],c[q];
        for(int i=0;i<n;i++) cin>>a[i];
        for(int i=0;i<m;i++) cin>>b[i];
        for(int i=0;i<q;i++) cin>>c[i];
        int i=0,j=0,k=0,kt=0;
        while(i<n && j<m && k<q){
            if(a[i]==b[j] && a[i]==c[k]){
                cout << a[i] << " ";
                kt=1;
                i++;j++;k++;
            }
            else {
                while(a[i] < b[j] || a[i] < c[k]) i++;
                while(b[j] < a[i] || b[j] < c[k]) j++;
                while(c[k] < a[i] || c[k] < b[j]) k++;
            }
        }
        if(kt==0) cout << "NO" ;
        cout << endl;
    }
}