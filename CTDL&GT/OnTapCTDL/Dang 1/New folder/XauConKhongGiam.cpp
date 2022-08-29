#include<bits/stdc++.h>
using namespace std;

int t,n,f[505];
string s;


void xuly(){
	int kq=0;
	for(int i=0;i<s.size();i++){
		f[i]=1;
		for(int j=i-1;j<i;j++){
			if(s[i]>=s[j]&&f[i]<=f[j]){
				f[i]=f[j]+1;
			}
		}
		kq=max(kq,f[i]);	
	}
	cout<<kq<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>s;
		xuly();
	}
}
