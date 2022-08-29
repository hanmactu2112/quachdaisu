#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int trace[1005];
vector<vector<int>> V;
void DFS(int u){
	check[u]=false;
	for(int i=0;i<List[u].size();i++){
		int j=List[u][i];
		if(check[j]==true){
			trace[j]=u;
			DFS(j);
		}
	}	
}
void xuly(int u, int v){
	memset(check,true,sizeof(check));
	DFS(u);
	vector<int> dem;
	dem.push_back(v);
	while(v!=u){
		v=trace[v];
		dem.push_back(v);
	}
	cout << dem.size()-1 << endl;
}
main(){
	int t; cin>>t;
	while(t--){
		for(int i=0;i<1005;i++) List[i].clear();
		int n; cin>>n;
		for(int i=1;i<n;i++){
			int x,y; cin>>x>>y;
			List[x].push_back(y);
			List[y].push_back(x);
		}
		int m; cin>>m;
		while(m--){
			int x,y; cin>>x>>y;
			xuly(x,y);
		}
	}
}
