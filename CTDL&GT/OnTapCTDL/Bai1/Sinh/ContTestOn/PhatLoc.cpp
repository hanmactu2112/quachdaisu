#include<bits/stdc++.h>
using namespace std;
int n,a[20],ok;
bool ktra(){
	int dem6=0;
	int dem8=0;
	for(int i=1;i<=n;i++){
		if(a[1]!=8||a[n]!=6) return false;
		if(a[i]==8) dem8++;
		else dem8=0;
		if(dem8>=2) return false;
		if(a[i]==6) dem6++;
		else dem6=0;
		if(dem6>=4) return false;
	}
	return true;
}
void in(){
	if(ktra()){
		for(int i=1;i<=n;i++){
			cout<<a[i];
			
		}
		cout<<endl;
	}
	
}
void xuly(){
	int i=n;
	while(i>0&&a[i]==8){
		a[i]=6;
		i--;
	}
	if(i>0){
		a[i]=8;
	}
	else ok=0;
}
main(){
	cin>>n;
	for(int i=1;i<=n;i++){
		a[i]=6;
	}
	ok=1;
	while(ok){
		in();
		xuly();
	}
}
