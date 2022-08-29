#include <bits/stdc++.h>
using namespace std;

int t,n,a[1000],ok;
void sinhHV(){
	int j=n-1;
	while(j>0&&a[j]>a[j+1])j--;
	if(j>0){
		int k=n;
		while(a[j]>a[k])k--;
		int t = a[j];a[j]=a[k];a[k]=t;
		int r=j+1,s=n;
		while(r<=s){
			t=a[r];a[r]=a[s];a[s]=t;
			r++;s--;
		}
	}
	else {
		ok=0;
	}
	}

void in(){
	if(ok){
		for(int i =1;i<=n;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
	}
	else {
		for(int i =1;i<=n;i++){
		cout<<i<<" ";}
	}
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		ok=1;
		while(ok){
			sinhHV();
			in();
			break;
		}
	}
}
