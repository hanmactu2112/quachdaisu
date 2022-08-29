#include<bits/stdc++.h>
using namespace std;

int f[50],s[50],dem;


void xuly(int n,int k){
	if(k==0){
		dem=dem;
		return;
	}
	if(k==1&&n==1) {
		dem=dem+1;
		return;
	}
	else{
		if(k==f[n-1]) dem=dem+s[n-1];
		if(k<f[n-1]) return xuly(n-1,k);
		else if(k>f[n-1]) {
			dem=dem+s[n-1];
			return xuly(n-2,k-f[n-1]);
		}
	}
}
main(){
	int t,n,k;
	f[0]=1;
	f[1]=1;
	s[0]=0;
	s[1]=1;
	for(int i=2;i<=46;i++){
		f[i]=f[i-1]+f[i-2];
		s[i]=s[i-1]+s[i-2];
	}
	cin>>t;
	while(t--){
		cin>>n>>k;
		dem=0;
		xuly(n,k);
		cout<<dem<<endl;
	}
}
