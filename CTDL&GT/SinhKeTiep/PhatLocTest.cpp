#include <bits/stdc++.h>
using namespace std;

int n,ok,a[100];
void sinh(){
	int i=n;
	while(i>0&&a[i]==1){
		a[i]=0;
		i--;
	}
	if(i>0){
		a[i]=1;
	}
	else ok=0;
}
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=0;
	}
}
void in(){
	for(int i=1;i<=n;i++){
		if(a[i]==1) cout<<"8";
		else cout<<"6";
	}
	cout<<endl;
}
bool ktra(){
	for(int i=1;i<=n;i++){	
		if(a[1]!=1||a[n]!=0) return false;	
	//	else if((a[i]==1&&a[i]==a[i+1])||(a[i]==0 && a[i]==a[i+1]&&a[i+1]==a[i+2]&&a[i+2]==a[i+3])) return false;
	}
	return true;
}
main(){
	cin>>n;
	ok=1;
	ktao();
	while(ok){
		
		if(ktra()) in();	sinh();	
	}
}
