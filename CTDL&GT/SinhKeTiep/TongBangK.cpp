#include<bits/stdc++.h>
using namespace std;
int n,a[100],c[100],ok,s;
void ktao(){
	for(int i=1;i<=n;i++){
		c[i]=0;
	}
}
bool ktra(){
	int sum=0;
	for(int i=1;i<=n;i++){
		if(c[i]==1){
			sum=sum+a[i];
		}
	}
	if(sum!=s) return false;
	return true;
}
void sinh(){
	int i=n;
	while(i>=1&&c[i]==1){
		c[i]=0;
		i--;
	}
	if(i==0){
		ok = 0;
	}
	else{
		c[i]=1;
	}
}
main(){
	cin>>n>>s;
	for(int i=1;i<=n;i++){
		cin>>a[i];
	}
	ok = 1;
	int dem=0;
	ktao();
	while(ok){
		
		if(ktra()){
			for(int i=1;i<=n;i++){
				if(c[i]==1){
					cout<<a[i]<<" ";
				}
			}
				cout <<endl;
								dem++;
		}
		sinh();

	}
	cout<<dem<<endl;
}
