#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int t,n,m,u;
vector<int> ds[1005];
bool chuaxet[1005];

void dfs(int u){
	cout<<u<<" ";
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<1005;i++) ds[i].clear();
		memset(chuaxet,true,sizeof(chuaxet));
		cin>>n>>m>>u;
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
		}
		dfs(u);
		cout<<endl;
	}
}

