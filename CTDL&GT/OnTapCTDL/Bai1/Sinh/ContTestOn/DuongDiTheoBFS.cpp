#include <bits/stdc++.h>
#include <iostream>
using namespace std;

vector<int> ds[1005];
int t,n,m,s,truoc[1005];
bool chuaxet[1005];
void in(int u){
	if(chuaxet[u]) cout<<"No path"<<endl;
	else{
		stack<int>st;
		st.push(u);
		while(st.top()!=s){
			st.push(truoc[st.top()]);
		}
		while(!st.empty()){
			cout<<st.top()<<" ";
			st.pop();
		}
		cout<<endl;
	}
}

void bfs(int u){
	queue<int> q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();q.pop();
		chuaxet[x]=false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				truoc[v]=x;
				chuaxet[v]=false;
			}
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>m>>s;
		for(int i=0;i<=n;i++){
			ds[i].clear();
			chuaxet[i]=true;
			truoc[i]=0;
		}
		for(int i =0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		bfs(s);
		for(int i=1;i<=n;i++){
			if(i!=s) in(i);
		}
	}
}
