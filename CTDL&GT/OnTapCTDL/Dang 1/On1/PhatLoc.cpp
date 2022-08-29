#include <bits/stdc++.h>
using namespace std;

int n,ok,a[25],b[25];
bool ktra(){
	if(a[b[1]]!=8) return false;
	if(a[b[n]]!=6) return false;
	int dem6=0,dem8=0;
	for(int i=1;i<=n;i++){
		if(a[b[i]]==6) dem6++;
		else dem6=0;
		if(dem6>3) return false;
		if(a[b[i]]==8) dem8++;
		else dem8=0;
		if(dem8>1) return false;
	}
	return true;
}
void in(){
	if(ktra()){
		for(int i=1;i<=n;i++){
			cout<<a[b[i]];
		}
		cout<<endl;
	}
}
void xuly(int i){
	for(int j=0;j<=1;j++){
		b[i]=j;
		if(i==n)in();
		else xuly(i+1);
	}	
}


main(){
	cin>>n;
	a[0]=6;
	a[1]=8;
	xuly(1);
}
