#include<bits/stdc++.h>
using namespace std;
string s;
int dem;


void xuly(){
	stack<int> st;
	stack<int> st1;
	
	for(int i=0;i<s.size();i++){
		if(s[i]=='('){
			dem++;
			st.push(dem);
			st1.push(dem);
		}
		else if(st.size()&&s[i]==')'){
			st1.push(st.top());
			st.pop();
		}
	}
	while(!st1.empty()){
		st.push(st1.top());
		st1.pop();
	}
	while(!st.empty()){
		cout<<st.top()<<" ";
		st.pop();
	}
	cout<<endl;
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>s;
		dem=0;
		xuly();
	}
}
