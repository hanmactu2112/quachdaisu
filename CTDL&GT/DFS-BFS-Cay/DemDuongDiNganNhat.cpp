#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int t,n,m,kq;
vector<int> ds[1005];
int a[1005][1005];
int truoc[1005];
bool chuaxet[1005];


void dfs(int u){
	chuaxet[u]=false;
	for(int v : ds[u]){
		if(chuaxet[v]){
			dfs(v);
			truoc[v]=u;
		}
	}
}

main(){
	cin>>n>>m;
	for(int i=0;i<1005;i++){
		ds[i].clear();
		chuaxet[i] = true;
	}
	memset(a,0,sizeof(a));
	for(int i=1;i<=m;i++){
		int x,y,z;
		cin>>x>>y>>z;
		a[x][y]=z;
		a[y][x]=z;
		ds[x].push_back(y);
		ds[y].push_back(x);
	}
	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			dfs(n);
		stack<int> st;
		st.push(1);
		while(st.top()!=n){
		st.push(truoc[st.top()]);
		}
		while(!st.empty()){
		cout<<st.top()<<" ";
		st.pop();
		}
		}
	}
}
