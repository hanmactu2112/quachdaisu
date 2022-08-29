#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; string st,en;
        cin>>n>>st>>en;
        set<string> s;
        string x; 
        for(int i=0;i<n;i++){
            cin>>x;
            s.insert(x);
        }
        s.erase(st);
        queue<string> Q;
        Q.push(st);
        map<string,int> mp;
        mp[st]=0;
        while(!Q.empty()){
            string u=Q.front();
            Q.pop();
            if(u==en){
                cout << mp[u]+1 << endl;
                break;
            }
            string u1=u;
            for(int i=0;i<u1.size();i++){
                for(char j='A';j<='Z';j++){
                    u1[i]=j;
                    if(s.find(u1)!=s.end()&&mp.find(u1)==mp.end()){
                        s.erase(u1);
                        mp[u1]=mp[u]+1;
                        Q.push(u1);
                    }
                }
                u1=u;
            }
        }
    }
}