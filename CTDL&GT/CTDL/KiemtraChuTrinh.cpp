#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int t,n,m;
vector<int> ds[100005];
int truoc[100005];
bool chuaxet[100005];


bool bfs(int u){
	queue<int>q;
	q.push(u);
	while(!q.empty()){
		int x = q.front();q.pop();
		chuaxet[u]=false;
		for(int v:ds[x]){
			if(chuaxet[v]){
				q.push(v);
				truoc[v]=x;
			}
		else if(v!=truoc[x]) return true;
		}
	}
	return false;
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<100005;i++){
			chuaxet[i]=true;
			ds[i].clear();
		}
		cin>>n>>m;
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		if(bfs(1)) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
}
