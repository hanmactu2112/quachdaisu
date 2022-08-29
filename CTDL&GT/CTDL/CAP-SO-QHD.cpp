#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        pair<int,int> a[n+5];
        for(int i=0;i<n;i++){
            cin>>a[i].first>>a[i].second;
        }
        sort(a,a+n);
        int maxx=0;
        int F[105]={0};
        for(int i=0;i<n;i++){
            F[i]=1;
            for(int j=0;j<i;j++){
                if(a[i].first>a[j].second){
                    F[i]=max(F[i],F[j]+1);
                }
            }
            maxx=max(maxx,F[i]);
        }
        cout << F[n-1] << endl;
    }
}