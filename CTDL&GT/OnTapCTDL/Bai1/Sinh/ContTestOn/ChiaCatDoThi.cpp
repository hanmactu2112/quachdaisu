#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<pair<int,int>> canhcau;
vector<int> ds[100005];
int t,n,m,s;
bool chuaxet[100005];
void dfs(int u){
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
			dfs(i);
		}
	}
	int dinhmax = 0;
	int maxtp=0; 
	for(int i=1;i<=n;i++){
		for(int j=0;j<=n;j++){
			chuaxet[j]=true;
		}
		int dt=0;
		chuaxet[i]=false;
		for(int j=1;j<=n;j++){
			if(chuaxet[j]) {
				dt++;
				dfs(j);
			}
		}
		if(dt>tplt&&dt>maxtp) {
			maxtp=dt;
			dinhmax=i;
		}
		else if(dt>tplt&&dt==maxtp){
			dinhmax = min(dinhmax,i);
		}
	}
	cout<<dinhmax<<endl;
	}
}
