#include <bits/stdc++.h>
using namespace std;

int t,n,k,a[1005],ok;

void xuly(){
	int i=k;
	while(i>0&&a[i]==n-k+i){
		a[i]--;
		i--;
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		for(int i=1;i<=k;i++) {
			cin>>a[i];
		}
		ok=1;
		while(ok){
			xuly();
			break;
		}
		if(ok)for(int i=1;i<=k;i++){
				cout<<a[i]<<" ";
			}
		if(ok==0)for(int i=1;i<=k;i++) cout<<n-k+i<<" ";
		cout<<endl;
	}
}
