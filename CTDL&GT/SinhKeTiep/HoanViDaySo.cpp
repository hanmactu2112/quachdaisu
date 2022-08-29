#include <bits/stdc++.h>
using namespace std;
int n,a[100],ok;
void ktao(){
	for(int i=1;i<=n;i++){
		for(int j=i+1;j<=n;j++){
			if(a[i]>a[j]){
				int k=a[i];
				a[i]=a[j];
				a[j]=k;
			}
			
		}
	}
}
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
void hoanvi(){
	int j=n-1;
	while(j>0&&a[j]>a[j+1])j--;
	if(j>0){
		int k=n;
		while(k>0&&a[j]>a[k])k--;
		int t =a[j];
		a[j]=a[k];
		a[k]=t;
		int r=j+1,s=n;
		while(r<=s){
			t=a[r];a[r]=a[s];a[s]=t;
			r++;s--;
		}
	}
	else ok=0;
}
main(){
	cin>>n;
	for(int i=1;i<=n;i++) cin>>a[i];
	ktao();
	ok=1;
	while(ok){
		in();
		hoanvi();
	}
		
}
