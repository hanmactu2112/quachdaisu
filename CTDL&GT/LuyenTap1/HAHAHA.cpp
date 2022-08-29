#include <bits/stdc++.h>
using namespace std;

int t,n,ok,a[20];
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=0;
	}
}
void sinh(){
	int i=n;
	while(i>=0&&a[i]==1){
		a[i]=0;
		--i;
	}
	if(i>0){
		a[i]=1;
	}
	else ok=0;
}
bool ktra(){
	for(int i=1;i<=n;i++){
		if((a[i]==1&&a[i+1]==1)||a[1]!=1||a[n]!=0) {
			return false;
		}
	}
	return true;
}
void in(){
	for(int i=1;i<=n;i++){
		if(a[i]==1){
			cout<<"H";
		}
		else cout<<"A";
	}
	cout<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		ok=1;
		ktao();
		while(ok){
			if(ktra()){
				in();
			}
			sinh();
		}
		
	}
}
