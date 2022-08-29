#include <bits/stdc++.h>
using namespace std;
int t,n,chuaxet[1005];

struct cv{
	int bd,kt,ln;
}a[1005];

bool tmp(cv a, cv b){
	if(a.ln==b.ln) return a.kt>b.kt;
	return a.ln>b.ln;
}

void xuly(){
	memset(chuaxet,0,sizeof(chuaxet));
	int dem=0;
	int kq =0;
	for(int i=0;i<n;i++){
		if(chuaxet[a[i].kt]==1&&a[i].kt>0) a[i].kt=a[i].kt-1;
		if(chuaxet[a[i].kt]==0&&a[i].kt>0){
			dem++;
			chuaxet[a[i].kt]=1;
			kq = kq+a[i].ln;
		}
	}
	cout<<dem<<" "<<kq<<endl;
}

main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=0;i<n;i++){
			cin>>a[i].bd>>a[i].kt>>a[i].ln;
		}
		sort(a,a+n,tmp);
		xuly();
	}
}
