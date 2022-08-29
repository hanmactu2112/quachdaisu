#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int t,n,m;
vector<int> ds[1005];
bool chuaxet[1005];

void bfs(int u){
	queue<int> q;
	q.push(u);
	while(!q.empty()){
		chuaxet[u]=false;
		int x = q.front();q.pop();
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
		for(int i=0;i<1005;i++){
			ds[i].clear();
			chuaxet[i]=true;
		}
		cin>>n>>m;
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		int dem=0;
		for(int i=1;i<=n;i++){
			if(chuaxet[i]){
				bfs(i);
				dem++;
			}
		}
		cout<<dem<<endl;
	}
}
