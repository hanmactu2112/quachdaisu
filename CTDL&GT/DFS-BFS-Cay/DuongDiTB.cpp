#include<bits/stdc++.h>
#include<iostream>
using namespace std;

priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
vector<pair<int,int>> ds[1005];
int d[1005];
int c[1005];
bool chuaxet[1005];
int t,n,m;

void tim(){
	int u;
	for(int i=1;i<=m;i++){
		d[i]=0;
	}
	d[1]=0;
	while(!q.empty())q.pop();
	q.push({0,1});
	while(!q.empty()){
		u = q.top().second;
		q.pop();
		for(auto i:ds[u]){
			int v = i.second;
			int d_v = i.first;
			c[v]=c[v]+c[u]+1;
			d[v] = d[v]+d[u]+d_v;
			q.push({d[v],v});
			if(d[u]+d_v<d[v]) {
				d[v] = d[u]+d_v;
				q.push({d[v],v});
			}
		}
	}
	int canh=0;
	for(int i=1;i<=n;i++) canh=canh+d[i];
	cout<<d[n]<<" "<<canh<<endl;
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<1005;i++){
			ds[i].clear();
			chuaxet[i]= true;
			c[i]=0;
		}
		cin>>n>>m;
		for(int i=0;i<m;i++){
			int x,y,z=1;
			cin>>x>>y;
			ds[x].push_back({1,y});
//			ds[y].push_back({z,x});
		}
		tim();
	}
}
