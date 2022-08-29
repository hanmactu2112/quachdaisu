#include<bits/stdc++.h>
using namespace std;
bool check[15];
int n;
vector<string> a(15);
int b[50];
int ans=1e9;
int kt(string a, string b){
    sort(a.begin(),a.end());
    sort(b.begin(),b.end());
    int cnt=0;
    int i=0,j=0;
    int x=a.size(), y=b.size();
    while(i<x && j<y){
        if(a[i]==b[j]){
            cnt++;
            i++;
            j++;
        }
        else {
            while(a[i]<b[j]) i++;
            while(b[j]<a[i]) j++;
        }
    }
    return cnt;
}
void Try(int i, int cnt){
    if(cnt>ans) return;
    if(i==n+1){
        ans=min(ans,cnt);
        return;
    }
    for(int j=1;j<=n;j++){
        if(check[j]==false){
            b[i]=j;
            check[j]=true;
            int id=kt(a[b[i]],a[b[i-1]]);
            Try(i+1,cnt+id);
            check[j]=false;
        }
    }
}
main(){
    cin>>n;
   for(int i=1;i<=n;i++) cin>>a[i];
   Try(1,0);
   cout << ans << endl;
}