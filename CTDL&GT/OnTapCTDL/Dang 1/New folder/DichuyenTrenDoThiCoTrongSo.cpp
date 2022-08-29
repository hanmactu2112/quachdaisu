#include <bits/stdc++.h>
#include <iostream>
using namespace std;


int s,t,n,m,u,truoc[25005];
vector<pair<int,int>> ds[25005];
long long d[25005];
int a[305][305];

void tim(int s,int u){
	priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
	for(int i=1;i<=m;i++){
		d[i]=1e9;
		truoc[i]=0;
	}
	d[s]=0;
	q.push({0,s});
	int cmin =1e9;
	while(!q.empty()){
		long long u = q.top().second;q.pop();
		for(auto i:ds[u]){
			int v = i.second;
			int d_v= i.first;
			if(cmin > a[u][v]){
				d[v]=d[u]+d_v;
				q.push({d[v],v});
				truoc[v]=u;
				cmin = a[u][v];
				cout<<v<<" "<<u<<endl;
			}
		}
	}
}

main(){
	cin>>n>>m>>t;
	for(int i=1;i<=m;i++){
		int x,y,z;
		cin>>x>>y>>z;
		ds[x].push_back({z,y});
		a[x][y]=z;
	}
	while(t--){
		cin>>s>>u;
		tim(s,u);
		if(d[u]!=1e9){
			stack<int> st;
			st.push(u);
			int canh=0;
			while(st.top()!=s){
				int x=st.top();
				int y=truoc[x];
				st.push(y);
				int z=a[y][x];
				canh = max(canh,z); 
			}
			cout<<canh<<endl;
		}
		else cout<<"-1"<<endl;
	}
}

