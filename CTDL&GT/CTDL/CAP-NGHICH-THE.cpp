#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
long long merge(ll a[], ll l, ll r, ll m){
    long long n1=m-l+1;
    long long n2=r-m;
    ll x[n1], y[n2];
    for(ll i=0;i<n1;i++){
        x[i]=a[i+l];
    }
    for(ll i=0;i<n2;i++){
        y[i]=a[i+m+1];
    }
    long long ans=0;
    long long i=0,j=0,k=l;
    while(i<n1 && j<n2){
        if(x[i]<=y[j]){
            a[k++]=x[i++];
        }
        else {
            a[k++]=y[j++];
            ans=ans+(n1-i);
        }
    }
    while(i<n1){
        a[k++]=x[i++];
    }
    while(j<n2){
        a[k++]=y[j++];
    }
    return ans;
}
long long mergeSort(ll a[], ll l, ll r){
    long long ans=0;
    if(l<r){
        ll m=(l+r)/2;
        ans=ans+mergeSort(a,l,m);
        ans=ans+mergeSort(a,m+1,r);
        ans=ans+merge(a,l,r,m);
    }
    return ans;
}
int main(){
    int t; cin>>t;
    while(t--){
        long long n; cin>>n;
        long long a[n];
        for(ll i=0;i<n;i++) cin>>a[i];
        cout << mergeSort(a,0,n-1) << endl;
    }
}