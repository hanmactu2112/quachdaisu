#include<bits/stdc++.h>
using namespace std;

int t,n,k,ok,a[25],c[25];
void ktao(){
	for(int i=1;i<=k;i++){
		a[i]=i;
	}
}
void sinhTH(){
	int i=k;
	while(i>0&&a[i]==n-k+i)i--;
	if(i>0){
		a[i]++;
		for(int j=i+1;j<=k;j++){
			a[j]=a[i]+j-i;
		}
	}
	else ok=0;
}
bool ktra(){
	for(int i=1;i<=k;i++){
		if(a[i]!=c[i]) return false;
	}
	return true;
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		for(int i=1;i<=k;i++){
			cin>>c[i];
		}
		ok=1;
		int dem=1;
		ktao();
		while(ok){
			if(ktra()){
				cout<<dem<<endl;
				ok=0;
			} 
			sinhTH();
			dem++;
		}
	}
}
