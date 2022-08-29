#include<bits/stdc++.h>
using namespace std;
int xopt[100],fopt=-1e9,a[100],b[100];
int op[100],n,m;
void in(){
    int sum1=0,sum2=0;
    for(int i=1;i<=n;i++){
        sum1=sum1+a[i]*op[i];
        sum2=sum2+b[i]*op[i];
    }
    if(sum2<=m && sum1>fopt){
        fopt=sum1;
        for(int i=1;i<=n;i++){
            xopt[i]=op[i];
        }
    }
}
void Try(int i){
    for(int j=0;j<=1;j++){
        op[i]=j;
        if(i==n) in();
        else Try(i+1);
    }
}
main(){
    cin>>n>>m;
    for(int i=1;i<=n;i++) cin>>a[i];
    for(int i=1;i<=n;i++) cin>>b[i];
    Try(1);
    cout << fopt << endl;
    for(int i=1;i<=n;i++){
        cout << xopt[i] << " ";
    }
}