#include<bits/stdc++.h>
using namespace std;
bool cmp(pair<int,int> a, pair<int,int> b){
    return a.second<b.second;
}
void xuly(pair<int,int> a[], int n){
    sort(a,a+n,cmp);
    int dem=1;
    int j=0;
    for(int i=1;i<n;i++){
        if(a[j].second<=a[i].first){
            dem++;
            j=i;
        }
    }
    cout << dem << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        pair<int,int> a[n];
        for(int i=0;i<n;i++) cin>>a[i].first;
        for(int i=0;i<n;i++) cin>>a[i].second;
        xuly(a,n);
    }
}