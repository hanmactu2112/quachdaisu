#include<bits/stdc++.h>
using namespace std;
int n,t,s;
int a[25];
int xuly(int x, int y){
    if(y>t){
        return 0;
    }
    if(x==n+1){
        if(y==t){
            return 1;
        }
        return 0;
    }
    int sum=0, ans=0;
    for(int i=x;i<=n;i++){
        sum=sum+a[i];
        if(sum==s){
            ans = ans + xuly(i+1,y+1);
        }
    }
    return ans;
}
main(){
    cin>>n>>t;
    s=0;
    for(int i=1;i<=n;i++){
        cin>>a[i];
    }
    for(int i=1;i<=n;i++) s=s+a[i];
    if(s%t!=0){
        cout << "0" << endl;
    }
    else {
        s=s/t;
        cout << xuly(1,0) << endl;
    }
}