#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void xuly(string s){
	stack <pair<char,int>> st;
	int kq=0;
	int dem=0;
	st.push({'$',0});
	for(int i=0;i<s.size();i++){
		if(st.size()&&s[i]==')'&&st.top().first=='('||s[i]==']'&&st.top().first=='['){
			st.pop();
			if(st.size()){
				kq = max(kq,dem-st.top().second);
			}
		}
		else {
			dem +=s[i]=='[';
			st.push({s[i],dem});
		}
	}
	cout<<kq<<endl;
}


main(){
	string s;
	cin>>s;
	xuly(s);
}
