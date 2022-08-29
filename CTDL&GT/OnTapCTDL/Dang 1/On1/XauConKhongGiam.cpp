#include<bits/stdc++.h>
using namespace std;
int f[205];
string s;


void xuly(){
	int kq=0;
	for(int i=0;i<s.size();i++){
		f[i]=1;
		if(s[i]>=s[i-1]&&f[i]<=f[i-1]){
			f[i] = f[i-1]+1;
		}
		kq =max(kq,f[i]);
	}
	cout<<kq<<endl;
}

main(){
	cin>>s;
	xuly();
}
