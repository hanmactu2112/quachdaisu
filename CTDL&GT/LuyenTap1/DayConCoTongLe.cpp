#include<bits/stdc++.h>
using namespace std;
int n,a[1000],c[1000],ok;

bool ktra(){
	int sum=0;
	for(int i=1;i<=n;i++){
		if(c[i]==1){
			sum=sum+a[i];
		}
	}
	if(sum%2==0) return false;
	return true;
}
void sinh(){
	int i=n;
	while(i>0&&c[i]==1){
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
	int t;
	cin>> t;
	while(t--){
			cin>>n;
	for(int i=1;i<=n;i++){
		cin>>a[i];
	}
	ok = 1;
	while(ok){
		if(ktra()){
			for(int i=1;i<=n;i++){
				if(c[i]==1){
					cout<<a[i]<<" ";
				}
			}
			cout <<endl;
		}
		sinh();

	}
	}
}
