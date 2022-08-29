#include <bits/stdc++.h>
using namespace std;

main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		stack<char> st;
		for(int i=0;i<s.size();i++){
			if(s[i]=='('||s[i]=='['||s[i]=='{') st.push(s[i]);
			else {
				if(!st.empty()&&s[i]==')'&&st.top()=='(') st.pop();
				else if(!st.empty()&&s[i]=='}'&&st.top()=='{') st.pop();
				else if(!st.empty()&&s[i]==']'&&st.top()=='[') st.pop();
			}
		}
		
		if(st.empty()) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
	
}
