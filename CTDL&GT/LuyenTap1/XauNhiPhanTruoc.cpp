#include <bits/stdc++.h>
using namespace std;

void sinh() {
	string str;
	cin >> str;

	int i =str.size() - 1;
	while(i >=0 && str[i] == '0') {
		str[i] = '1';
		i--;
	}
	if(i >=0) {
		str[i] = '0';
		cout << str << endl;
	} else {
		for(int j = 0; j < str.size(); j++) {
			cout << 1;
		}
		cout << endl;
	}
}

main(){
	int t;
	cin >> t;
	
	while(t--) {
		sinh();
	}
}
