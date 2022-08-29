#include <bits/stdc++.h>
using namespace std;
 int n,t, a[100],ok;
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
main(){
	cin>>t;
	while(t--){
		cin>>n;
			ok = 1;

	while(ok){
		if(ok){
			for(int i=1;i<=n;i++){
				if(a[i]==0) cout<<"A";
				else if(a[i]==1) cout<<"B";
			}
				cout <<" ";
		}
		sinh();

	}
	cout << endl;
	}

}
