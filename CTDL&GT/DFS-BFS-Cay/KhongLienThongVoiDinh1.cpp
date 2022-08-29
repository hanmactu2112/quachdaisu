#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int n,m,t;
vector<int> ds[1005];
bool chuaxet[1005];

void bfs(int u){
	queue<int> q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();
		q.pop();
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
		cin>>n>>m;
		for(int i=0;i<1005;i++) ds[i].clear();
		memset(chuaxet,true,sizeof(chuaxet));
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		bfs(1);
		queue<int> q;
		for(int i =2;i<=n;i++){
			if(chuaxet[i]) q.push(i);
		}
		if(q.empty()) cout<<"0"<<endl;
		else {
			while(!q.empty()){
				cout<<q.front()<<endl;
				q.pop();
			}
		}
}
