#include <bits/stdc++.h>
using namespace std;
int n,k,a[100], c[100],ok;
void sinhth(){
	int i=k;
	while(i>0&&a[i]==n-k+i)i--;
	if(i>0){
		a[i]++;
		for(int j=i+1;j<=n;j++){
			a[j] = a[i]+j-i;
		}
	}
	else ok=0;	
	
}
void ktao(){
	for(int i=1;i<=k;i++){
		a[i]=i;
	}
}
bool ktra(){
	int tong=1;
	for(int i=1;i<=k-1;i++){
		if(c[a[i]]<c[a[i+1]]) tong++;
	}
	if(tong==k) return true;
	return false;
}

main(){
	cin>>n>>k;
	for(int i=1;i<=n;i++){
		cin>>c[i];
	}
	ok=1;
	ktao();
	int dem=0;
	while(ok){
		if(ktra()) dem++;
		sinhth();
	}
	cout<<dem<<endl;
}
