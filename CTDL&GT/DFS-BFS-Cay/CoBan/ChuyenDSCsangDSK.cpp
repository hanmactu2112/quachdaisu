#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<int> ds[1005];

main(){
	int t;
	cin>>t;
	while(t--){
		int n,m;
		cin>>n>>m;
		for(int i=0;i<1005;i++) ds[i].clear();
		for(int i=0;i<m;i++){
			int x,y;
			cin>>x>>y;
			ds[x].push_back(y);
			ds[y].push_back(x);
		}
		for(int i=1;i<=n;i++){
			cout<<i<<": ";
			for(auto x:ds[i]){
				cout<<x<<" ";
			}
			cout<<endl;
		}
		cout<<endl;
	}
}
