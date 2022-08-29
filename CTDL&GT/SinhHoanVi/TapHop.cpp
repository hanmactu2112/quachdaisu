#include <bits/stdc++.h>
using namespace std;

int n,k,s,ok,a[25];
void ktao(){
	for(int i=1;i<=k;i++){
		a[i]=i;
	}
}
void sinhth(){
	int i=k;
	while(i>0&&a[i]==n-k+i){
		i--;
	}
		if(i>0){
		a[i]++;
		for(int j=i+1;j<=k;j++){
			a[j]=a[i]+j-i;
		}
	}
	else ok=0;
}
//bool ktra(){
//	for(int i=1;i<k;i++){
//		if(a[i]>=a[i+1])  return false;
//	}
//	return true;
//}
bool ktra1(){
	int tong=0;
	for(int i=1;i<=k;i++){
		tong = tong+a[i];
	}
	if(tong==s) return true;
	return false;
}
//void in(){
//	for(int i=1;i<=k;i++){
//		cout<<a[i]<<" ";
//	}
//	cout<<endl;
//}
main(){
	int chay=1;
	while(chay<101){
		cin>>n>>k>>s;
		if(n==0&&k==0&&s==0){
			chay=1000;
			break;
		}
		int dem=0;
		if(k>n) dem=0;
		else{
			ok=1;
		
		ktao();
		while(ok){
		if(ktra1()) dem++;
//		in();
		sinhth();
		}
		}
		cout<<dem<<endl;
		chay++;
	}
	
}
