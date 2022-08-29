#include<bits/stdc++.h>
#include<iostream>
using namespace std;
priority_queue<pair<long long,long long>,vector<pair<long long,long long>>,greater<pair<long long,long long>>> q;
long long n,m;

void tim(vector<pair<long long ,long long>> ds[],long long d[],long long f[]){
	long long u;
	for(int i=1;i<=m;i++){
		d[i]=1e18;
	}
	d[1]=0;
	while(!q.empty())q.pop();
	q.push({0,1});
	while(!q.empty()){
		u = q.top().second;
		q.pop();
		for(auto i:ds[u]){
			long long v = i.second;
			long long d_v = i.first;
			if(d[u]+d_v==d[v]) f[v]=f[v]+f[u];
			if(d[u]+d_v < d[v]) {
				f[v]=1;
				d[v] = d[u]+d_v;
				q.push({d[v],v});
			}
		}
	}
	cout<<d[n]<<" "<<f[n]<<endl;
}

main(){
	cin>>n>>m;
	vector<pair<long long ,long long>> ds[m+5];
	long long d[m+5];
	long long f[n+5];
	for(int i=0;i<m+5;i++){
		ds[i].clear();
	}
	for(int i=0;i<n+5;i++){
		f[i]=0;
	}
	for(int i=0;i<m;i++){
		long long x,y,z;
		cin>>x>>y>>z;
		ds[x].push_back({z,y});
		ds[y].push_back({z,x});
	}
	tim(ds,d,f);
}
