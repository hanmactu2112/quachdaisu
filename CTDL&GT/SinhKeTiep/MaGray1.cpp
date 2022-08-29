#include <bits/stdc++.h>
using namespace std;
 int n, a[100],ok,sua;
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=0;
	}
}
bool ktra(){
	int kt=0;
	for(int i=1;i<=n;i++){
		if(a[i]!=a[n-i+1]) return false;;
	}
	return true;			
}
void sinh(){
	int i=n;int th=0;
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
	cin>>n;
	ok = 1;
	while(ok){
		if(ok){
			for(int i=1;i<=n;i++){
				cout<<a[i]<<" ";
			}
				cout <<endl;
		}
		sinh();
	}
}
