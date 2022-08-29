#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int n,m;
vector<int> ds[1005];
vector<pair<int, int> > canhcau;
bool chuaxet[1005];
void dfs(int u){
	chuaxet[u]=false;
	for(int v : ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
}
void dfs2(int u,int x,int y){
	chuaxet[u]=false;
	for(int v : ds[u]){
		if((u==x&&v==y)||(u==y&&v==x)) continue;
		if(chuaxet[v]){
			dfs2(v,x,y);
		}
	}
}
int dinhtru(int dinh){
	int ltdt=0;
		memset(chuaxet,true,sizeof(chuaxet));
	chuaxet[dinh]=false;

	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			dfs(i);
			ltdt++;
		}
	}
	return ltdt;
}


main(){
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
		canhcau.push_back({x,y});
	}
	int tplt=0;
	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			dfs(i);
			tplt++;
		}
	}
	int demdt=0;
	for(int i=1;i<=n;i++){
		if(dinhtru(i)>tplt) demdt++;
	}
	cout<<demdt<<" ";
	int demcc=0;
	for(auto it : canhcau){
		int x = it.first;
		int y = it.second;
		memset(chuaxet,true,sizeof(chuaxet));
		int cclt=0;
		for(int i=1;i<=n;i++){
			if(chuaxet[i]){
				dfs2(i,x,y);
				cclt++;
			}
		}
		if(cclt>tplt)demcc++;
	}
	cout<<demcc<<endl;
}
