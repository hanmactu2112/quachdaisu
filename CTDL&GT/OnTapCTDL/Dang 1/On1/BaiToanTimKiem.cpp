#include<bits/stdc++.h>
using namespace std;

int t,n,s,k,a[100005];
void xuly(){
	long long kq=a[s];
	int vt=0;
	for(int i=s-1;i>=1;i--){
		if(kq+a[i]<=k) {
			vt=i;
			kq=kq+a[i];
		}
		else break;
	}
	if(vt>0) cout<<vt<<endl;
	else cout<<"-1"<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>s>>k;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		xuly();
	}
}
