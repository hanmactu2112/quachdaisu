#include <bits/stdc++.h>
using namespace std;
 int n, a[100],ok;
void in(){
	for(int i=1;i<=n;i++){
		if(a[i]==0) cout <<"6";
		else cout<<"8";
	}
	cout<<" ";
}
//bool ktra(){
//	int kt=0;
//	for(int i=1;i<=n;i++){
//		if(a[i]!=a[n-i+1]) return false;;
//	}
//	return true;			
//}
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
main(){
	int t;
	cin>>t;
	while(t--){
	cin>>n;
	ok = 1;
	int dem=2;
	for(int i=1;i<n;i++){
		dem=dem*2;
	}
	cout<<dem<<endl;
	while(ok){
		in();
		sinh();
		}
		cout<<endl;
	}
}
