#include <bits/stdc++.h>
#include <iostream>
using namespace std;

vector<int> ds[1005];
int t,n,m,s,chuaxet[1005];

void dfs(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
}

main(){
	cin>>n>>m>>s;
	for(int i=0;i<=n;i++){
		ds[i].clear();
		chuaxet[i]=true;
	}
	for(int i =0;i<m;i++){
		int x,y;
		cin>>x>>y;
		ds[x].push_back(y);
		ds[y].push_back(x);
	}
	int dem=0;
	dfs(s);
	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			cout<<i<<endl;
			dem++;
		}
	}
	if(dem==0) cout<<dem<<endl;
}
