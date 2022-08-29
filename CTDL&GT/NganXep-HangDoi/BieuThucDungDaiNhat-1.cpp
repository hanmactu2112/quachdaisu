#include <bits/stdc++.h>
using namespace std;
int xuly(string s){
	stack<char> st;
	int dem = 0;
	st.push(-1);
	for(int i=0;i<s.size();i++){
		if(s[i]=='(') st.push(s[i]);
		else if(!st.empty()&&s[i]==')'&&st.top()=='(') {
			st.pop();
			dem++;
		}
	}
	return 2*dem;
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
