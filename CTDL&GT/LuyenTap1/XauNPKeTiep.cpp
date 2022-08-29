#include <bits/stdc++.h>
using namespace std;
int t;
void sinh(){
	string str;
	cin>> str;
	int i = str.size()-1;
	while (i>=0&&str[i]=='1'){
		str[i]='0';
		--i;
	}
	if(i>=0){
		str[i]='1';
		cout<<str<<endl;
	}else {
	for(int j = 0; j < str.size(); j++) {
			cout << 0;
		}
		cout << endl;}
}
main(){
	cin>>t;
	while(t--){
		sinh();
	}
}
