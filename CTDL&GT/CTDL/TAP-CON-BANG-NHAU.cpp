#include<bits/stdc++.h>
using namespace std;
int a[100], c[100], n;
long long sum, m, ok;
void Try(int i, int s){
    if(ok==1) return;
    for(int j=c[i-1]+1;j<=n;j++){
        if(s+a[j]<=m){
            c[i]=j;
            s=s+a[j];
            if(s==m){
                ok=1;
                return;
            }
            else Try(i+1,s);
            s=s-a[j];
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        ok=0,sum=0;m=0;
        cin>>n;
        for(int i=1;i<=n;i++){
            cin>>a[i];
            sum=sum+a[i];
        }
        if(sum%2==1) cout << "NO" << endl;
        else {
            m=sum/2;
            Try(1,0);
            if(ok==1) cout << "YES" << endl;
            else cout << "NO" << endl;
        }
    }
}
