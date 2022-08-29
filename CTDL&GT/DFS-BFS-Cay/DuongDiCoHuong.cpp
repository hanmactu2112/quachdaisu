#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int n,m,u,t,v;
vector<int> ds[1005];
bool chuaxet[1005];
int truoc[1005];

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
				truoc[v]=x;
			} 
		}
	}
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>m>>u>>v;
		for(int i=0;i<1005;i++) {
			ds[i].clear();
			truoc[i]=0;
		}
		memset(chuaxet,true,sizeof(chuaxet));
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
		}
		bfs(u);
		if(chuaxet[v])cout<<"-1"<<endl;
		else {
			stack<int> st;
			st.push(v);
			while(st.top()!=u){
				st.push(truoc[st.top()]);
			}
			while(!st.empty()){
				if(st.size()>1){
					cout<<st.top()<<" ";
				st.pop();
				}
				else {
					cout<<st.top()<<endl;
				st.pop();
				}
			}
			
		}
	}
}
