#include<bits/stdc++.h>
using namespace std;

int t,n,a[25],b[25],dem;
bool chuaxet[25];
bool ktra(){
	for(int i=1;i<=n;i++){
		if(a[i]!=b[i]) return false;
	}
	return true;
}
void in(){
	dem++;
	if(ktra()) cout<<dem<<endl;
}
void Try(int i){
	for(int j=1;j<=n;j++){
		if(chuaxet[j]){
			b[i]=j;
			chuaxet[j]=false;
			if(i==n) {
				in();
			}
			else Try(i+1);
			chuaxet[j]=true;
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		dem=0;
		memset(chuaxet,true,sizeof(chuaxet));
		Try(1);
	}
}
