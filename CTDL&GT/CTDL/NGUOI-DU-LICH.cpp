#include<bits/stdc++.h>
using namespace std;
int n;
long long c[20][20], s;
long long ans=1e9, cmin=1e9;
long long x[200];
bool cx[200];
void Try(int i){
    if(s+(n-i+1)*cmin>=ans) return;
    for(int j=2;j<=n;j++){
        if(cx[j]==false){
            cx[j]=true;
            x[i]=j;
            s = s + c[x[i-1]][x[i]];
            if(i==n){
                if(s+c[x[n]][1]<ans){
                    ans=s+c[x[n]][1];
                }
            }
            else Try(i+1);
            cx[j]=false;
            s=s-c[x[i-1]][x[i]];
        }
    }
}
int main(){
    memset(cx,false,sizeof(cx));
    s=0;
    cin>>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>c[i][j];
           if(c[i][j]!=0){
               cmin = min(cmin,c[i][j]);
           }
        }
    }
    x[1]=1;
    Try(2);
    cout << ans << endl;
} 