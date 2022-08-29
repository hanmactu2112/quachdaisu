#include <bits/stdc++.h>
using namespace std;

void binary() {
	string str, str1;
	cin >> str;

	for(int i=1; i<=str.size()-1; i++){
		if(str[i]=='1'){
			if(str[i-1]=='0')	str[i]='1';
			if(str[i-1]=='1')	str[i]='0';
		}
		else {
			if(str[i-1]=='0')	str[i]='0';
			if(str[i-1]=='1')	str[i]='1';
		}
	}
	cout << str << endl;
}

main(){
	int t;
	cin >> t;
	
	while(t--) {
		binary();
	}
}
