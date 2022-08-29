#include <bits/stdc++.h>
using namespace std;

int xuly(string s){
	stack<int> st;
	for(int i=0;i<s.size();i++){
		if(s[i]=='('){
			st.push(i);	
		}
		else if(s[i]==')'){
		  	int j=st.top(); st.pop();
            if(i-j==2){
                return 0;
            } 
            if(s[i-1]==')' && s[j+1]=='('){
                return 0;
            }
		}
	}
	if(!st.empty()) return 0;
	return 1;
}
main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		if(xuly(s)) cout<<"No"<<endl;
		else cout<<"Yes"<<endl;
	}
}
