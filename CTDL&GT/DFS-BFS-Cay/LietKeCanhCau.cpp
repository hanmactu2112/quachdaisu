#include<bits/stdc++.h>
#include<iostream>
using namespace std;
vector<int> ds[1005];
vector<pair<int,int>> canh;
int t,n,m;
bool chuaxet[1005];

void dfs(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]) dfs(v);
	}
}
void dfs2(int u,int x,int y){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if((u==x&&v==y)||(u==y&&v==x)) continue;
		if(chuaxet[v]) dfs2(v,x,y);
	}
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		canh.clear();
		for(int i=0;i<1005;i++){
			ds[i].clear();
			chuaxet[i]=true;
		}
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
			canh.push_back({x,y});
		}
		int tplt=0;
		for(int i=1;i<=n;i++){
			if(chuaxet[i]){
				tplt++;
				dfs(i);
			}
		}
		for(auto p:canh){
			memset(chuaxet,true,sizeof(chuaxet));
			int x = p.first;
			int y = p.second;
			int cclt=0;
			for(int i=1;i<=n;i++){
				if(chuaxet[i]){
					dfs2(i,x,y);
					cclt++;
				}
			}
			if(cclt>tplt){
				if(x>y) cout<<y<<" "<<x<<" ";
				else cout<<x<<" "<<y<<" ";
			}
		}
		cout<<endl;
	}
	
}
