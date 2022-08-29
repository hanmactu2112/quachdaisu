#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int n,m,u,t;
vector<int> ds[1005];
bool chuaxet[1005];

void bfs(int u){
	queue<int> q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();
		q.pop();
		cout<<x<<" ";
		chuaxet[x]=false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				chuaxet[v]=false;
			} 
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
		bfs(u);
		cout<<endl;
	}
}
