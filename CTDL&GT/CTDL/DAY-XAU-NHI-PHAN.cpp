#include<bits/stdc++.h>
using namespace std;
long long F[100];
char xuly(long long n, long long m){
    if(n==1) return '0';
    if(n==2) return '1';
    if(m<=F[n-2]) return xuly(n-2,m);
    else return xuly(n-1,m-F[n-2]);
}
int main(){
    F[1]=1;
    F[2]=1;
    for(int i=3;i<=93;i++){
        F[i]=F[i-1]+F[i-2];
    }
    int t; cin >> t;
    while(t--){
        long long n,m;
        cin>>n>>m;
        cout << xuly(n,m) << endl;
    }
}
