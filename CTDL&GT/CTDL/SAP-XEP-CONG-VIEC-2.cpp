#include<bits/stdc++.h>
using namespace std;
bool cmp(pair<int,int> a, pair<int,int> b){
    return a.second>b.second;
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        vector<pair<int,int>> V(n+5);
        int x;
        for(int i=0;i<n;i++){
            cin>>x>>V[i].first>>V[i].second;
        }
        int check[1005]={0};
        sort(V.begin(),V.end(),cmp);
        int dem=0,sum=0;
        for(int i=0;i<n;i++){
            while(check[V[i].first]==1&&V[i].first>0) V[i].first=V[i].first-1;
            if(check[V[i].first]==0&&V[i].first>0){
                sum=sum+V[i].second;
                dem++;
                check[V[i].first]=1;
            }
        }
        cout << dem << " " << sum << endl;
    }
}
