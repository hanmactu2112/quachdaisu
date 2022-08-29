#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int t,n,f[505];
struct so{
	double bd,kt;
}a[505];


void xuly(){
	int kq=0;
	for(int i =1;i<=n;i++){
		f[i]=1;
		for(int j=1;j<i;j++){
			if(a[i].bd>a[j].bd&&a[i].kt<a[j].kt&&f[i]<=f[j]){
				f[i]=f[j]+1; 
			}
		}
		kq = max(kq,f[i]);
	}
	cout<<kq<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i].bd>>a[i].kt;
		}
		xuly();
	}
}
