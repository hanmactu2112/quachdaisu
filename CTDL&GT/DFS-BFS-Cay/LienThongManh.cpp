#include<bits/stdc++.h>
using namespace std;
int n, m;
vector<int> ds1[100001], ds2[100001];
bool chuaxet[100001];
stack<int> st;


void dfs1(int u){
	chuaxet[u] = false;
	for(int v : ds1[u]){
		if(chuaxet[v]){
			dfs1(v);
		}
	}
	st.push(u);
}

void dfs2(int u){
	chuaxet[u] = false;
	for(int v : ds2[u]){
		if(chuaxet[v]){
			dfs2(v);
		}
	}
}

main(){
	cin >> n >> m;
	for(int i=0;i<m;i++){
		int x, y; cin >> x >> y;
		ds1[x].push_back(y);
		ds2[y].push_back(x);
	}
	memset(chuaxet,true,sizeof(chuaxet));
	for(int i=1;i<=n;i++){
		if(chuaxet[i]){
			dfs1(i);
		}
	}
	memset(chuaxet,true,sizeof(chuaxet));
	int dem =0;
	while(!st.empty()){
		int u = st.top();
		st.pop();
		if(chuaxet[u]){
			dfs2(u);
			dem++;
		}
	}
	cout << dem<<endl;
}


