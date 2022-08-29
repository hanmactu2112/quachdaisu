#include<bits/stdc++.h>
using namespace std;
int a[20],b[20];
int d1[7]={0,1,5,2,4,6,3};
int d2[7]={0,4,1,3,5,2,6};
string xuly1(string u){
    u='0'+u;
    string s="";
    for(int i=1;i<=6;i++){
        s=s+u[d1[i]];
    }
    return s;
}
string xuly2(string u){
    u='0'+u;
    string s="";
    for(int i=1;i<=6;i++){
        s=s+u[d2[i]];
    }
    return s;
}
void xuly(){
    queue<string> Q;
    map<string,int> M;
    int d=0;
    string ST="",EN="";
    for(int i=1;i<=6;i++) ST=ST+to_string(a[i]);
    for(int i=1;i<=6;i++) EN=EN+to_string(b[i]);
    M[ST]=1;
    Q.push(ST);
    while(!Q.empty()){
        string X=Q.front(); Q.pop();
        if(X==EN){
            d=M[EN];
            cout << d-1 << endl;
            break;
        }
        string tmp="";
        tmp=xuly1(X);
        if(M.find(tmp)==M.end()){
            M[tmp]=M[X]+1;
            Q.push(tmp);
        }
        tmp=xuly2(X);
        if(M.find(tmp)==M.end()){
            M[tmp]=M[X]+1;
            Q.push(tmp);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=1;i<=6;i++) cin >> a[i];
        for(int i=1;i<=6;i++) cin >> b[i];
        xuly();
    }
}

