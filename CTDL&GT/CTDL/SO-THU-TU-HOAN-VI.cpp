#include<bits/stdc++.h>
using namespace std;
int a[20], b[20]={0},n, c[20];
long long s;
int dem, ok;
void check(){
    long long sum=0;
    for(int i=1;i<=n;i++){
        sum = sum *  10 + c[i];
    }
    if(s==sum){
        dem++;
        cout << dem << endl;
        ok = 0;
    }
    else dem++;
}
void Try(int i){
    if(ok==0) return;
    for(int j=1;j<=n;j++){
        if(b[j]==0){
            c[i]=j;
            b[j]=1;
            if(i==n) check();
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        s=0; ok=1, dem=0;
        cin>>n;
        for(int i=1;i<=n;i++){
            cin >> a[i];
            s=s*10+a[i];
        }
        Try(1);
    }
}
