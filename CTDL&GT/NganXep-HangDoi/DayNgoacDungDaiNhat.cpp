#include <bits/stdc++.h>
using namespace std;

int xuly(string s){
	stack<int> st;
	int kq = 0;
	st.push(-1);
	for(int i=0;i<s.size();i++){
		if(s[i]=='(') st.push(i);
		else if(s[i]==')') {
				st.pop();
			if(!st.empty()){
				kq = max(kq,i-st.top());
			}
			else st.push(i);
		}
	}
	return kq;
}
main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		cout<<xuly(s)<<endl;
	}
}
