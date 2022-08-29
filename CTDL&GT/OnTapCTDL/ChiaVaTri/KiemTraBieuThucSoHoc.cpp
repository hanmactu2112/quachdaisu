#include <bits/stdc++.h>
using namespace std;
string s;

bool xuly(){
	stack<int>st;
	for(int i=0;i<s.size();i++){
		if(s[i]=='(') st.push(i);
		else if(s[i]==')'){
			if(st.empty()) return false;
			else {
				int j = st.top();st.pop();
				if(i-j<=2) return false;
				if(s[i+1]==')'&&s[j-1]=='(') return false;
			}
		}
	}
	if(!st.empty()) return false;
	else return true;
}

main(){
	int t;
	cin>>t;
	while(t--){
		cin>>s;
		if(xuly()) cout<<"No"<<endl;
		else cout<<"Yes"<<endl;
	}
}
