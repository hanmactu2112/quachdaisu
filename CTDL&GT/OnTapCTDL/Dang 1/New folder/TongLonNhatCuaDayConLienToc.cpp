#include<bits/stdc++.h>
using namespace std;

int t,n,f[505],kq,a[505];


void xuly(){
	kq=0;
	for(int i=1;i<=n;i++){
		int max=a[i];
		for(int j=i;j<=n;j++){
			if(max<a[j]){
				max=a[j];
			}
			kq = kq+max;
		}	
	}
	cout<<kq<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		xuly();
	}
}
