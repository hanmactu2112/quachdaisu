#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int a[1005][1005],c[1005][1005];
int t,m,n;

void xuly(){
	queue<pair<int,int>>q;
	q.push({1,1});
	while(!q.empty()){
		int i =q.front().first;
		int j =q.front().second;
		q.pop();
		if(c[i][j+a[i][j]]==0){
			q.push({i,j+a[i][j]});
			c[i][j+a[i][j]]=c[i][j]+1;
		}
		if(c[i+a[i][j]][j]==0){
			q.push({i+a[i][j],j});
			c[i+a[i][j]][j]=c[i][j]+1;
		}
		if(c[m][n]!=0)break;
	}
	if(c[m][n]!=0) cout<<c[m][n]<<endl;
	else cout<<"-1"<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>m>>n;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				cin>>a[i][j];
				c[i][j]=0;
			}
		}
		xuly();
	}
}
