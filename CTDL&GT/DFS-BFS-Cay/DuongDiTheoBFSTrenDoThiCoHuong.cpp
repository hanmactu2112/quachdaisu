#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int t,n,m,u,v;
vector<int> ds[1005];
int chuaxet[1005];
int truoc[1005];

void bfs(int u){
	queue<int>q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();q.pop();
		chuaxet[x] = false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				truoc[v]=x;
				chuaxet[v] = false;
			}
		}
	}
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<1005;i++){
			chuaxet[i] = true;
			ds[i].clear();
			truoc[i]=0;
		}
		cin>>n>>m>>u>>v;
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
		}
		bfs(u);
		if(chuaxet[v]) cout<<"-1";
		else {
			stack<int> st;
			st.push(v);
			while(st.top()!=u){
				st.push(truoc[st.top()]);
			}
			while(!st.empty()){
				cout<<st.top()<<" ";
				st.pop();
			}
		}
		cout<<endl;
	}
}

