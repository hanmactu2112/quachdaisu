#include<bits/stdc++.h>
#include<iostream>
using namespace std;

priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
vector<pair<int,int>> ds[1005];
int d[1005];

int t,n,m,s;

void tim(){
	int u;
	for(int i=1;i<=m;i++){
		d[i]=1e9;
	}
		while(!q.empty())q.pop();
	d[s]=0;
	q.push({0,s});
	while(!q.empty()){
		u = q.top().second;
		q.pop();
		for(auto i:ds[u]){
			int v = i.second;
			int d_v = i.first;
			if(d[u]+d_v<d[v]) {
				d[v] = d[u]+d_v;
				q.push({d[v],v});
			}
		}
	}
	for(int i=1;i<=n;i++) cout<<d[i]<<" ";
	cout<<endl;
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<1005;i++){
			ds[i].clear();
		}
		cin>>n>>m>>s;
		for(int i=0;i<m;i++){
			int x,y,z;
			cin>>x>>y>>z;
			ds[x].push_back({z,y});
			ds[y].push_back({z,x});
		}
		tim();
	}
}
