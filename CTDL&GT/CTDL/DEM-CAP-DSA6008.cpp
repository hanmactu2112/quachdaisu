#include<bits/stdc++.h>
using namespace std;
int KT(int x, int y[], int m, int tick[6]){
    if(x==0) return 0;
    if(x==1) return tick[0];
    int ans=upper_bound(y,y+m,x)-y;
    int cnt=m-ans;
    cnt = cnt + tick[0] + tick[1];
    if(x==2) cnt = cnt-(tick[3]+tick[4]);
    if(x==3) cnt = cnt + tick[2];
    return cnt;
}
main(){
    int t; cin>>t;
    while(t--){
        int n, m; cin>>n>>m;
        int a[n],b[m];
        int tick[6]={0};
        for(int i=0;i<n;i++) cin>>a[i];
        for(auto &x:b){
            cin >> x;
            if(x<5) tick[x]++;
        }
        sort(b,b+m);
        int ans=0;
        for(auto i:a){
            ans=ans+KT(i,b,m,tick);
        }
        cout << ans << endl;
    }
}