#include<bits/stdc++.h>
using namespace std;

int t,n,a[100],c[100],ok;
void sinhHV(){
	int j=n-1;
	while(j>0&&a[j]>a[j+1]) j--;
	if(j>0){
		int k=n;
		while(a[j]>a[k]) k--;
		int t = a[j];a[j]=a[k];a[k]=t;
		int r=j+1,s=n;
		while(r<=s){
			t=a[r];a[r]=a[s];a[s]=t;
			r++;s--;
		}
	}
	else ok=0;
}
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=i;
	}
}

bool ktra(){
	for(int i=1;i<=n;i++){
		if(c[i]!=a[i]) return false;
	}
	return true;
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>c[i];
		}
		ok=1;
		ktao();
		int dem=1;
		while(ok){
			if(ktra()) {
				cout<< dem<<endl;
				ok=0;
			}
			sinhHV();
			dem++;
		}
	}
}
