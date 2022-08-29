#include <bits/stdc++.h>
using namespace std;

int t,n,k,a[100];
void ktao(){
	for(int i=1;i<=k;k++){
		a[i]=i;
	}
}
void in(){
	for(int i=1;i<=k;i++){
		cout<<a[i];
	}
	cout<<" ";
}
void Try(int i){
	for(int j=a[i-1]+1;j<=n-k+i;j++){
		a[i]=j;
		if(i==k) in();
		else Try(i+1);
	}	
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
//		ktao();
		Try(1);
		cout<<endl;
	}
}
