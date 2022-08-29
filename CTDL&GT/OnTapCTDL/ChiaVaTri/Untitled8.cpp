#include <bits/stdc++.h>
using namespace std;
string s;

void xuly(){
	stack<int>st;
	int kq = 0;
	st.push(-1);
	for(int i=0;i<s.size();i++){
		if(s[i]=='(') st.push(i);
		else {
			if(!st.empty()&&s[i]==')') st.pop();
			if(!st.empty()) kq = max(kq,i-st.top());
			else st.push(i);
		}
	}
	cout<<kq<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		cin>>s;
		xuly();
	}
}
