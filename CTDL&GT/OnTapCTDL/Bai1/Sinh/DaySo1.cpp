#include<bits/stdc++.h>
using namespace std;
int a[1005];
int b[1005];
vector<vector<string>> vt;
int n;

void in(int m){
	for(int i=1;i<=m;i++){
		cout<<b[i]<<" ";
	}
	cout<<endl;
}

void Try(int i){
	for(int j=1;j<=n;j++){
		b[j]=a[i]+b[i-1];
		if(i==n) in(i);
		Try(i+1);
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++) cin>>a[i];
		Try(1);
		cout<<endl;
	}
}

