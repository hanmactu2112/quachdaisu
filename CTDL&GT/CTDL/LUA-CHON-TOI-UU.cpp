#include<bits/stdc++.h>
#define pp pair<int,int>
using namespace std;
bool cmp(pair<int,int> a, pair<int, int> b){
    return a.second<b.second;
}
void xuly(pair<int,int> a[], int n){
    sort(a,a+n,cmp);
    int kq=1;int j=0;
    for(int i=1;i<n;i++){
        if(a[i].first>=a[j].second){
            kq++;
            j=i;
        }
    }
    cout << kq << endl;
}
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        pair<int,int> a[n];
        for(int i=0;i<n;i++){
            cin>>a[i].first>>a[i].second;
        }
        xuly(a,n);
    }
}