#include<bits/stdc++.h>
using namespace std;
int a[20], n, k, c[20];
int ok, dem;
long long sum;
void check(){
    long long s = 0 ;
    for(int i=1;i<=k;i++){
        s = s*10 + c[i];
    }
    if(s==sum){
        dem++;
        ok=1;
        cout << dem << endl;
        return;
    }
    else dem++;
}
void Try(int i){
    if(ok==1) return;
    for(int j=c[i-1]+1;j<=n-k+i;j++){
        c[i]=j;
        if(i==k){
            check();
        }
        else Try(i+1);
    }
}
main(){
    int t; cin >> t;
    while(t--){
        sum=0; ok=0; dem=0;
        cin >> n >> k;
        for(int i=1;i<=k;i++){
            cin >> a[i];
            sum=sum*10+a[i];
        }
        Try(1);
    }
}
