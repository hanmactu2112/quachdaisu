#include <bits/stdc++.h>
using namespace std;

int tinhgiatri(int a,int b,char c){
	if(c=='+') return a+b;
	if(c=='-') return a-b;
	if(c=='*') return a*b;
	if(c=='/') return a/b;
}

int tinhtiento(string s){
	stack <int> st;
	for(int i=s.size()-1;i>=0;i--){
		if(isdigit(s[i])){
			int n = s[i]-'0';
			st.push(n);
		}
		else {
			int a = st.top();st.pop();
			int b = st.top();st.pop();
			int x = tinhgiatri(a,b,s[i]);
			st.push(x);
		}
	}
	return st.top();
}

main(){
	int t;
	string s;
	cin>>t;
	while(t--){
		cin>>s;
		cout<<tinhtiento(s)<<endl;
	}
}
