#include<bits/stdc++.h>
using namespace std;
int TKNP(int a[], int n, int x){
    int l=0,r=n-1;
    int mid = (l+r)/2;
    while(l<=r){
        if(a[mid]==x) return mid;
        else if(x>a[mid]){
            l=mid+1;
        }
        else r=mid-1;
        mid=(l+r)/2;
    }
    return -1;
}
int main(){
    int t; cin >> t;
    while(t--){
        int n, x; cin >> n >> x;
        int a[n];
        for(int i=0;i<n;i++) cin >> a[i];
        if(TKNP(a,n,x)!=-1) cout << TKNP(a,n,x)+1 << endl;
        else cout << "NO" << endl;
    }
}
