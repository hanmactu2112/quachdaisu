#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int t,n,m,kq;
vector <int> ds[100005];
bool chuaxet[100005];
int dem;
void dfs(int u){
	chuaxet[u] = false;
	for(auto v:ds[u]){
		if(chuaxet[v]){
			dfs(v);
			dem++;
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		for(int i=0;i<100005;i++){
			ds[i].clear();
			chuaxet[i]=true;
		}
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		kq=0;
		for(int i =1;i<=n;i++){
			if(chuaxet[i]){
				dem=1;
				dfs(i);
				kq = max(kq,dem);
			}
		}
		cout<<kq<<endl;
	}
}
