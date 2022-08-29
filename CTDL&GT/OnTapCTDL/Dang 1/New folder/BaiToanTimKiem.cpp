#include<bits/stdc++.h>
using namespace std;

int t,n,s,k,f[505],a[505];


void xuly(){
	int kq=a[s];
	int vtri=s;
	for(int i=s-1;i>=1;i--){
		if(kq+a[i]<=k){
			kq=kq+a[i];
			vtri=i;
		}
		else break;
	}
	cout<<vtri<<endl;
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
