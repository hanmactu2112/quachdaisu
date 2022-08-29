#include <bits/stdc++.h>
using namespace std;


int kiemtra(string s){
		stack<char> q;
		for(int i=0;i<s.size();i++){
		if(s[i]=='('||s[i]=='['||s[i]=='{'){
			char x = s[i];
			q.push(x);
		}
		else {
			char c=q.top();
            if(!q.empty() && s[i]==')' && c=='(') q.pop();
            else if(!q.empty() && s[i]== ']' && c=='[') q.pop();
            else if(!q.empty() && s[i]=='}' && c=='{') q.pop();
            else return 0;
	}

	}
	return 1;
}

main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		if(kiemtra(s)) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
}
