#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int n,m,u,t;
vector<int> ds[1005];
bool chuaxet[1005];

void dfs(int u){
	cout<<u<<" ";
	chuaxet[u]=false;
	for(int v : ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>m>>u;
		for(int i=0;i<1005;i++) ds[i].clear();
		memset(chuaxet,true,sizeof(chuaxet));
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		dfs(u);
		cout<<endl;
	}
}
