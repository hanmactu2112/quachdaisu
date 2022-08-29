#include<bits/stdc++.h>
using namespace std;
int n,m,s;
long long dem;
int a[200];
void xuly(){
    int sum=0;
    for(int i=1;i<=m;i++){
        sum=sum+a[i];
    }
    if(sum==s) dem++;
}
void Try(int i){
    for(int j=a[i-1]+1;j<=n;j++){
        a[i]=j;
        if(i==m) xuly();
        else Try(i+1);
    }
}
main(){
    while(1){
        cin >> n >> m >> s;
        if(n==0 && m==0 && s==0){
            break;
        }
        else {
            dem=0;
            Try(1);
            cout << dem << endl;
        }
    }
}
