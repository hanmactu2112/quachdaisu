#include <bits/stdc++.h>
using namespace std;
int a[1005][1005],c[1005][1005];
void xuly(int m,int n){
	queue<pair<int,int> > q;
	memset(c,0,sizeof(c));
	c[1][1]=0;
	q.push({1,1});
	while(!q.empty()){
		pair<int,int> p  = q.front();
		int i = p.first;
		int j = p.second;
		q.pop();
		if(c[i][j+a[i][j]]==0){
			c[i][j+a[i][j]]=c[i][j]+1;
			q.push({i,j+a[i][j]});
		}
		if(c[i+a[i][j]][j]==0){
			c[i+a[i][j]][j]=c[i][j]+1;
			q.push({i+a[i][j],j});
		}
	   	if(c[m][n]!=0){
        break;
        }
	}
	if(c[m][n]==0) cout<<"-1"<<endl;
	else cout<< c[m][n]<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		int m,n;
		cin>>m>>n;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++) cin>>a[i][j];
		}
		xuly(m,n);
	}
}
