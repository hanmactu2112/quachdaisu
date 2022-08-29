#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int t,n,m,u;
vector<int> ds[1005];
int chuaxet[1005];

void bfs(int u){
	queue<int>q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();q.pop();
		cout<<x<<" ";
		chuaxet[x] = false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				chuaxet[v] = false;
			}
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>m>>u;
		for(int i=0;i<1005;i++){
			chuaxet[i] = true;
			ds[i].clear();
			
		}
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
		}
		bfs(u);
		cout<<endl;
	}
}

