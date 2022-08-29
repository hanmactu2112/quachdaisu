#include <bits/stdc++.h>
using namespace std;
 int n, a[100],b[100],ok;
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=0;
	}
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
void gray(){
	for(int i=1;i<=n;i++){
		if(a[i] == a[i-1])	b[i]=0;
		else b[i] = 1;
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n;
		ok = 1;
		int dem=1;
		while(ok){
			if(ok){
				gray();
				for(int i=1;i<=n;i++){
					cout<<b[i];
				}
					cout <<" ";
			}
			sinh();
			
		}
		cout << endl;
	}
}
