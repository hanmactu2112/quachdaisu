#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int t,n,m,f[5005][5005],a[5005],w[5005];



void xuly(){
	memset(f,0,sizeof(f));
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			f[i][j]=f[i-1][j];
			if(j>=a[i]){
				f[i][j] = max(f[i][j],f[i-1][j-a[i]]+w[i]);
			}
		}
	}
	cout<<f[n][m]<<endl;
}

main(){
	cin>>n>>m;
	for(int i=1;i<=n;i++){
		cin>>a[i]>>w[i];
	}
	xuly();
}
