#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int t,n,m;
vector<int> ds[1005];
int truoc[1005];
bool chuaxet[1005];


bool bfs(int u){
	queue<int>q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();q.pop();
		chuaxet[u]=false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				truoc[v]=x;
				chuaxet[v]=false;
			}
			else if(!chuaxet[v]) return true;
		}
	}
	return false;
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<1005;i++){
			chuaxet[i]=true;
			ds[i].clear();
			truoc[i]=0;
		}
		cin>>n>>m;
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
		}
		bool ok=false;
		 for (int i = 1; i <= n; i++) {
                if (chuaxet[i]) {
                    if(bfs(i)) {
                        ok = true;
                        break;
                    }
                }
            }
		if(ok) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
}
