#include<bits/stdc++.h>
using namespace std;
int n,a[20],ok,k,b[20],chuaxet[20],dem;
bool ktra(){
	for(int i=1;i<=n;i++){
		if(a[i]!=b[i]) return false;
	}
	return true;
}
void Try(int i){
	for(int j=1;j<=n;j++){
		if(!chuaxet[j]){
			chuaxet[j]=1;
			a[i] = j;
			if(i==n) {
				dem++;
				if(ktra()) cout<<dem<<endl;
			}
			else Try(i+1);
			chuaxet[j]=0;
		}
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++) cin>>b[i];
		dem=0;
		Try(1);
	}
}
