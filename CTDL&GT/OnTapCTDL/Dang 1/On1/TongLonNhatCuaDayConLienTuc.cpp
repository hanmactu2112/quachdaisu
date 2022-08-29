#include<bits/stdc++.h>
using namespace std;
int t,n,f[105];
int a[105];
void xuly(){
	int kq =0;
	for(int i=1;i<=n;i++){
		int max = a[i];
		for(int j=i;j<=n;j++){
			if(a[j]>max){
				max = a[j];
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
