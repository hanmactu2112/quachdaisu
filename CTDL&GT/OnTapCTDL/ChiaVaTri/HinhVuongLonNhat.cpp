#include <bits/stdc++.h>
using namespace std;
int t,m,n,a[505][505],f[505][505];

void xuly(){
	int kq =0;
	for(int i=1;i<=m;i++) f[i][0] = a[i][0];
	for(int i=1;i<=n;i++) f[0][i] = a[0][i];
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			if(a[i][j]==1){
				f[i][j] = a[i][j]+min(f[i-1][j],min(f[i][j-1],f[i-1][j-1]));
			}
			else f[i][j] =0;
			kq = max(kq,f[i][j]);
		}
	}
	cout<<kq<<endl;
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
