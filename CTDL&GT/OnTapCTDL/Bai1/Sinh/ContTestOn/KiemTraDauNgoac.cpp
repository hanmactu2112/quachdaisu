#include<bits/stdc++.h>
using namespace std;
string s;
void xuly(){
	stack<char> st;
	for(int i=0;i<s.size();i++){
		if(s[i]=='('||s[i]=='['||s[i]=='{'){
			st.push(s[i]);
		}
		else if(st.size()&&s[i]==')'&&st.top()=='(') st.pop();
		else if(st.size()&&s[i]==']'&&st.top()=='[') st.pop();
		else if(st.size()&&s[i]=='}'&&st.top()=='{') st.pop();
		else st.push(s[i]);
	}
	if(!st.empty()) cout<<"false"<<endl;
	else cout<<"true"<<endl;
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>s;
		xuly();
	}
}
