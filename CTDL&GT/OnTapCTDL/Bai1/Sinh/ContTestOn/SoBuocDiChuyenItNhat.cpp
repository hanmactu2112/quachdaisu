#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int t,n,m,a[1005][1005],c[1005][1005];

void xuly(){
	queue<pair<int,int>>q;
	q.push({1,1});
	while(!q.empty()){
		int i= q.front().first;
		int j = q.front().second;
		q.pop();
		int u = abs(a[i][j]-a[i+1][j]);
		int y = abs(a[i][j]-a[i][j+1]);
		int p = abs(a[i][j]-a[i+1][j+1]);
		if(c[i+u][j]==0){
			q.push({i+u,j});
			c[i+u][j] = c[i][j]+1;
		}
		if(c[i][j+y]==0){
			q.push({i,j+y});
			c[i][j+y] = c[i][j]+1;
		}
		if(c[i+p][j+p]==0){
			q.push({i+p,j+p});
			c[i+p][j+p] = c[i][j]+1;
		}
	} 
	if(c[n][m]!=0) cout<<c[n][m]<<endl;
	else cout<<"-1"<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		memset(a,0,sizeof(a));
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				cin>>a[i][j];
				c[i][j]=0;
			}
		}
	 xuly();
	}
}
