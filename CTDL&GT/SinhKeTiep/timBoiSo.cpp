#include <bits/stdc++.h>
using namespace std;
 int t,n, a[100],ok,kq,dem;
void ktao(){
	for(int i=1;i<=dem;i++){
		a[i]=0;
	}
}
bool ktra(){
	int kq=0;
	for(int i=1;i<=dem;i++){
		kq = kq *10 + a[i];
	}
	if(kq!=0&&kq%n==0) 	{
		return true;
	}
	else return false;		
}
void sinh(){
	int i=n;
	while(i>=1&&a[i]==1){
		a[i]=0;
		i--;
	}
	if(i==0){
		ok = 0;
	}
	else{
		a[i]=1;
	}
}
void in(){
	for(int i=0;i<=dem;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		
		dem=1;
		int st=0;
		int dung=0;
		ktao();
	while(dem>0){
		
		ok = 1;
		while(ok){
			
//			if(ktra()) dung=1;			
			sinh();
			in();
		}
//		if(dung==1) {
//			cout<<kq<<endl;
//			dem=0;
//		}
		dem++;
		}
	}
}
