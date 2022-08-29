#include<bits/stdc++.h>
using namespace std;
bool cmp(pair<int,int> a, pair<int,int> b){
    if(a.second==b.second) return a.first < b.first;
    else return a.second > b.second;
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n],A[100000+5]={0};
        for(int i=0;i<n;i++){
            cin>>a[i];
            A[a[i]]++;
        }
        pair<int,int> p[n];
        int d=0;
        for(int i=0;i<n;i++){
            if(A[a[i]]!=0){
              p[d].first=a[i];
              p[d].second=A[a[i]];
              d++;
              A[a[i]]=0;
            }
        }
        sort(p,p+d,cmp);
        for(int i=0;i<d;i++){
            for(int j=0;j<p[i].second;j++){
                cout << p[i].first << " ";
            }
        }
        cout << endl;
    }
}
