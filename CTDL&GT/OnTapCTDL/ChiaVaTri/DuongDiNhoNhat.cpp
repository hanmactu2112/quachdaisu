#include <bits/stdc++.h>
using namespace std;
int t,m,n,a[505][505],f[505][505];

void xuly(){
	f[1][1]=a[1][1];
	for(int i=2;i<=m;i++) f[i][1] = f[i-1][1]+a[i][1];
	for(int i=2;i<=n;i++) f[1][i] = f[1][i-1]+a[1][i];
	for(int i=2;i<=n;i++){
		for(int j=2;j<=n;j++){
			f[i][j] = a[i][j] + min(f[i-1][j],min(f[i][j-1],f[i-1][j-1]));
		}
	}
	cout<<f[n][m]<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>m;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				cin>>a[i][j];
			}
		}
		xuly();
	}
}
