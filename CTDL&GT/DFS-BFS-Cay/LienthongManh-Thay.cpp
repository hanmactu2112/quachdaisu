#include<bits/stdc++.h>
using namespace std;
int n, m;
vector<int> List1[100001], List2[100001];
bool mark[100001];
stack<int> s;

void readInput(){
	cin >> n >> m;
	for(int i=0;i<m;i++){
		int x, y; cin >> x >> y;
		List1[x].push_back(y);
		List2[y].push_back(x);
	}
}

void dfs1(int u){
	mark[u] = true;
	for(int v : List1[u]){
		if(!mark[v]){
			dfs1(v);
		}
	}
	s.push(u);
}

void dfs2(int u){
	mark[u] = true;
	for(int v : List2[u]){
		if(!mark[v]){
			dfs2(v);
		}
	}
}

void solve(){
	memset(mark,false,sizeof(mark));
	for(int i=1;i<=n;i++){
		if(!mark[i]){
			dfs1(i);
		}
	}
	memset(mark,false,sizeof(mark));
	int dem =0;
	while(!s.empty()){
		int u = s.top();
		s.pop();
		if(!mark[u]){
			dfs2(u);
			dem++;
		}
	}
	cout << dem;
}

main(){
	readInput();
	solve();
}


