#include <bits/stdc++.h>
using namespace std;

int t,n,k,a[25],ok=1;
void in(){
	for(int i=1;i<=k;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
void xuly(int i){
	for(int j=n-k+i;j>=a[i-1]+1;j--){
		a[i]=j;
		if(i==k) in();
		else xuly(i+1);
	}
}


main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		for(int i=1;i<=k;i++) a[i]=i;
		xuly(1);

	}
}
