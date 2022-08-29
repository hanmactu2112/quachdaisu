#include<bits/stdc++.h>
using namespace std;
long long a[100], n, s;
long long c[100], ok;
void Try(long long i, long long ans, long long sum){
    if(i==ans+1&&sum==s){
        ok=1;
        return;
    }
    if(i==ans+1&&sum!=s) return;
    for(int j=c[i-1]+1;j<=n;j++){
        c[i]=j;
        sum=sum+a[j];
        if(sum<=s) Try(i+1,ans,sum);
        sum=sum-a[j];
    }
}
int main(){
    cin>>n>>s;
    for(long long i=1;i<=n;i++){
        cin>>a[i];
    }
    long long ans=-1;
    ok=0;
    for(long long i=1;i<=n;i++){
        Try(1,i,0);
        if(ok==1){
            ans=i;
            break;
        }
    }
    cout << ans ;
}
