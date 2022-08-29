#include <bits/stdc++.h>
using namespace std;
int t;
void xuly(){
	string str;
	cin>>str;
	cout<<str[0];
	for(int i=1;i<=str.length()-1;i++){
		if(str[i]==str[i-1]) cout<<"0";
		else cout<<"1";
	}
	cout<<endl;
}
main(){
	cin>>t;
	while(t--){
		xuly();
	}
}

