#include<bits/stdc++.h>
#include<iostream>
using namespace std;
vector<int> ds[1005];
int t,n,m;
bool chuaxet[1005];

void dfs(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]) dfs(v);
	}
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		for(int i=0;i<1005;i++){
			ds[i].clear();
			chuaxet[i]=true;
		}
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		int tplt=0;
		for(int i=1;i<=n;i++){
			if(chuaxet[i]){
				tplt++;
				dfs(i);
			}
		}
		
		cout<<tplt<<endl;
	}
	
}
