#include<bits/stdc++.h>
using namespace std;
bool check[10000];
int chuyen(string s){
    int sum=0;
    for(int i=0;i<s.size();i++){
        sum=sum*10+(s[i]-'0');
    }
    return sum;
}
void xuly(string s, string s1){
    queue<string> Q;
    map<string,int> mp;
    Q.push(s);
    mp[s]=0;
    while(!Q.empty()){
        string u=Q.front();
        Q.pop();
        string u1=u;
        if(u==s1){
            int d=mp[s1];
            cout << d << endl;
            break;
        }
        for(int i=0;i<4;i++){
            int x=0;
            if(i==0) x++;
            for(int j=x;j<=9;j++){
                u1[i]=j+'0';
                if(mp.find(u1)==mp.end() && check[chuyen(u1)]==true){
                    mp[u1]=mp[u]+1;
                    Q.push(u1);
                }
            }
            u1=u;
        }
    }
}
main(){
    memset(check,true,sizeof(check));
    check[0]=false;
    check[1]=false;
    for(int i=2;i<=9999;i++){
        if(check[i]==true){
            for(int j=2*i;j<=9999;j=j+i){
                check[j]=false;
            }
        }
    }
    int t; cin>>t;
    while(t--){
        string s,s1; cin>>s>>s1;
        xuly(s,s1);
    }
}