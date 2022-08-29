#include <bits/stdc++.h>
using namespace std;
int n,a[105];
void xuly(){
	int kq = 0;
	int sum=0;
	for(int i=1;i<=n;i++){
		sum = sum+a[i];
		if(sum<0) sum=0;
		kq = max(kq,sum);
	}
	cout<<kq<<endl;
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		xuly();
	}
}

