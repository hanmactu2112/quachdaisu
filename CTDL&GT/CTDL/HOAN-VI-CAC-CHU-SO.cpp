#include<bits/stdc++.h>
using namespace std;
int a[20],b[20]={0};
int n,m; long long cnt=1e9;
vector<string> ip;
long long to_int(string a){
    long long ans=0;
    for(int i=0;i<a.size();i++){
        ans=ans*10+(a[i]-'0');
    }
    return ans;
}
void in(){
    vector<long long> op;
    for(int i=0;i<n;i++){
        string x="";
        for(int j=0;j<m;j++){
            x = x + ip[i][a[j]];
        }
        op.push_back(to_int(x));
    }
    sort(op.begin(),op.end());
    cnt=min(cnt,op[op.size()-1]-op[0]);
}
void Try(int i){
    for(int j=0;j<m;j++){
        if(b[j]==0){
            a[i]=j;
            b[j]=1;
            if(i==m-1) in();
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    cin>>n>>m;
    string s;
    for(int i=1;i<=n;i++){
        cin>>s;
        ip.push_back(s);
    }
    Try(0);
    cout << cnt << endl;
}