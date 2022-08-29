#include <bits/stdc++.h>
using namespace std;
int t,n,ok,a[100],k;
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=1;
	}
}

//void in(){
//	cout<<"(";
//	for(int i=1;i<=n;i++){
//		cout<<a[i];
//	}
//	cout<<")"<<" ";
//}
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
void sinhHV(){
	int j=n;
	int bd=1;
	while(j>0&&a[j]>k-n){
		if(n!=a[n+1])a[j]=1;
		j--;	
	}
	if(j>0&&a[1]<=k-n+1){
		a[j]++;
	}
//	if(j>n-k+n){
//		a[j]++;
//	}
	else {
		ok=0;
		n--;
		ktao();
	}
}
bool ktra(){
	int tong =0;
	for(int i=1;i<=n;i++){
		tong=tong+a[i];
	}
	if(tong==k) return true;
	return false;
}

main(){
	cin>>t;
	while(t--){
		cin>>n;
		
		k=n;
		ktao();
		while(n>0){
		in();
		sinhHV();
		}
		cout<<endl;
	}
}
