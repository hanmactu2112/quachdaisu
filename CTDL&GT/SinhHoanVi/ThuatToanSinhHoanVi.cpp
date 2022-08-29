#include <bits/stdc++.h>
using namespace std;
int t,n,ok,a[100];

void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=i;
	}
}
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i];
	}
	cout<<" ";
}
void sinhHV(){
	int j=n-1;
	while(j>0&&a[j]>a[j+1])j--;
	if(j>0){
		int k = n;
		while(a[j]>a[k])k--;
		int t = a[j]; a[j]=a[k];a[k]=t;
		int r=j+1,s=n;
		while(r<=s){
			t=a[r];a[r]=a[s];a[s]=t;
			r++;s--;
		}
	}
	else ok = 0;
}
main(){
	cin>>t;
	while(t--){
		ok=1;
		cin>>n;
		ktao();
		while(ok){
			in();
			sinhHV();
		}
		cout<<endl;
	}
}

