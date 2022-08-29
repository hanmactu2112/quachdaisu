#include<bits/stdc++.h>
using namespace std;
int a[100+5], n, k, s, ok;
int check[100+5];
void Try(int sum, int dem){
    if(ok==1) return;
    if(dem==k){
        ok=1;
        return;
    }
    for(int i=1;i<=n;i++){
        if(check[i]==0){
            check[i]=1;
            sum=sum+a[i];
            if(sum==s){
                Try(0,dem+1);
                return;
            }
            if(sum>s) return;
            else Try(sum,dem);
            sum=sum-a[i];
        }
        check[i]=0;
    }
}
int main(){
    int t; cin >> t;
    while(t--){
        memset(check,0,sizeof(check));
        s=0;
        cin>>n>>k;
        for(int i=1;i<=n;i++){
            cin>>a[i];
            s=s+a[i];
        }
        if(s%k!=0) cout << "0" << endl;
        else {
            ok=0;
            s=s/k;
            Try(0,0);
            if(ok==1) cout << "1" << endl;
            else cout << "0" << endl;
        }
    }
}
