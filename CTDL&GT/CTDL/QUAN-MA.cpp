#include<bits/stdc++.h>
using namespace std;
int d1[8]={2,1,-1,-2,2,1,-1,-2};
int d2[8]={-1,-2,-2,-1,1,2,2,1};
main(){
    int t; cin>>t;
    while(t--){
        string s,s1; cin>>s>>s1;
        queue<string> Q;
        map<string,int> M;
        Q.push(s);
        M[s]=0;
        while(!Q.empty()){
            string u=Q.front(); Q.pop();
            if(u==s1){
                int d=M[u];
                cout << d << endl;
                break;
            }
            for(int i=0;i<8;i++){
                string tmp="";
                tmp=tmp+(char)(u[0]-'a'+d1[i]+'a');
                tmp=tmp+(char)(u[1]-'0'+d2[i]+'0');
                if(tmp[0]>='a'&&tmp[0]<='h'&&tmp[1]<='8'&&tmp[1]>='1'){
                    if(M.find(tmp)==M.end()){
                        M[tmp]=M[u]+1;
                        Q.push(tmp);
                    }
                }
            }
        }
    }
}
