#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<pair<int,int>> canhcau;
vector<int> ds[100005];
int t,n,m,s;
bool chuaxet[100005];
void dfs1(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]){
			dfs1(v);
		}
	}
}
void dfs(int u,int a,int b){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if((u==a&&v==b)||u==b&&v==a) continue;
		if(chuaxet[v]){
			dfs(v,a,b);
		}
	}
}

main(){
	cin>>n>>m;
	for(int i=0;i<=n+5;i++){
		ds[i].clear();
		chuaxet[i]=true;
	}
	for(int i =0;i<m;i++){
		int x,y;
		cin>>x>>y;
		ds[x].push_back(y);
		ds[y].push_back(x);
		canhcau.push_back({x,y});
	}
	int tplt =0;
	for(int i=1;i<=n;i++){
		if(chuaxet[i]) {
			tplt++;
			dfs1(i);
		}
	}
	int demdt=0; 
	for(int i=1;i<=n;i++){
		for(int j=0;j<=n;j++){
			chuaxet[j]=true;
		}
		int dt=0;
		chuaxet[i]=false;
		for(int j=1;j<=n;j++){
			if(chuaxet[j]) {
				dt++;
				dfs1(j);
			}
		}
		if(dt>tplt) demdt++;
	}
	int demcc=0; 
	for(auto it:canhcau){
		int a = it.first;
		int b = it.second;
		memset(chuaxet,true,sizeof(chuaxet));
		int tpcc=0;
		for(int i=1;i<=n;i++){
			if(chuaxet[i]){
				tpcc++;
				dfs(i,a,b);
			}
		}
		if(tpcc>tplt) demcc++;
	}
	cout<<demdt<<" "<<demcc<<endl;
}
