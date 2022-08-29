#include<bits/stdc++.h>
using namespace std;
int a[20],b[20],d[20];
int c[20]; int kt;
void check(){
    int ans;
    if(c[1]==1) ans=a[d[1]]+a[d[2]];
    if(c[1]==2) ans=a[d[1]]-a[d[2]];
    if(c[1]==3) ans=(a[d[1]]*a[d[2]]);
    for(int i=3;i<=5;i++){
        if(c[i-1]==1) ans=ans+a[d[i]];
        if(c[i-1]==2) ans=ans-a[d[i]];
        if(c[i-1]==3) ans=ans*a[d[i]];
    }
    if(ans==23){
        kt=1;
        return;
    }
}
void Try2(int i){
    if(kt==1) return; 
    for(int j=1;j<=3;j++){
        c[i]=j;
        if(i==4) check();
        else Try2(i+1);
    }
}
void Try(int i){
    if(kt==1) return;
    for(int j=1;j<=5;j++){
        if(b[j]==0){
            d[i]=j;
            b[j]=1;
            if(i==5) Try2(1);
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(d,0,sizeof(d));
        memset(b,0,sizeof(b));
        kt=0;
        for(int i=1;i<=5;i++){
            cin>>a[i];
        }
        Try(1);
        if(kt==0) cout << "NO" << endl;
        else cout << "YES" << endl;
        
    }
}