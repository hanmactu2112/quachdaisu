#include <bits/stdc++.h>
using namespace std;

int t,n,a[100];
bool chuaxet[100];
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i];
	}
	cout<<" ";
}
void Try(int i){
	for(int j=1;j<=n;j++){
		if(chuaxet[j]){
			a[i]=j;
			chuaxet[j]=false;
			if(i==n) in();
			else Try(i+1);
			chuaxet[j]=true;
		}
	}	
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		memset(chuaxet,true,sizeof(chuaxet));
		Try(1);
		cout<<endl;
	}
}
