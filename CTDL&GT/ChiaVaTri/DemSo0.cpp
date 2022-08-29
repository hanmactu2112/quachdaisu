#include<bits/stdc++.h>
using namespace std;
int tim(int a[], int n){
    int l=0,r=n-1;
    int mid = (l+r)/2;
    while(l<=r){
        if(a[mid]==1&&a[mid-1]==0) return mid;
        else if(a[mid]==0){
            l=mid+1;
        }
        else r=mid-1;
        mid=(l+r)/2;
    }
    if(a[n]==0) return n;
    else return -1;
}
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        int a[n];
        for(int i=0;i<n;i++) cin >> a[i];
        if(tim(a,n)!=-1) cout << tim(a, n) << endl;
        else cout<<"0"<<endl;
    }
}
