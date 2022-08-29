#include<bits/stdc++.h>
using namespace std;
main(){
    int n,m; cin>>n>>m;
    int a[n];
    for(int i=0;i<n;i++) cin>>a[i];
    sort(a,a+n);
    long long cnt=0;
    for(int i=1;i<n;i++){
        if(a[i]-a[i-1]<=m) continue;
        else cnt++;
    }
    cout << cnt << endl;
}