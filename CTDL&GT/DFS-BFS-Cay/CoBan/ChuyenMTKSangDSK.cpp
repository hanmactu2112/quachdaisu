#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<int> ds[1005];
int a[1005][1005];

main(){
	int n;
	cin>>n;
	for(int i=0;i<1005;i++) ds[i].clear();
	memset(a,0,sizeof(a));
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			cin>>a[i][j];
			if(a[i][j]==1){
				ds[i].push_back(j);
			}
		}
	}
	for(int i=1;i<=n;i++){
		for(auto x:ds[i]){
			cout<<x<<" ";
		}
		cout<<endl;
	}
}
