#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int t,n,m;
vector<int> ds[1005];
vector<int> ds2[1005];
bool chuaxet[1005];
stack<int> st;

void dfs(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
	st.push(u);
}
void dfs2(int u){
	chuaxet[u]=false;
	for(int v:ds[u]){
		if(chuaxet[v]){
			dfs(v);
		}
	}
}
void kiemtra(){
	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			dfs(i);
		}
	}
	memset(chuaxet,true,sizeof(chuaxet));
	int dem=0;
	while(!st.empty()){
	
		int t = st.top();
		st.pop();
		if(chuaxet[t]){
			dfs(t);
			dem++;
		}
	}
	if(dem==1) {
		cout<<"YES"<<endl;
	}
	else cout<<"NO"<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		for(int i=0;i<1005;i++){
			chuaxet[i] = true;
			ds[i].clear();
		}
		for(int i=1;i<=m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds2[y].push_back(x);
		}
		kiemtra();
	}
}
