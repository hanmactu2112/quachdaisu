#include <bits/stdc++.h>
using namespace std;

main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		queue<string> q;
		stack<string> st;
		q.push("6");
		q.push("8");
		int ok=1;
		string s;
		while(ok){
			s = q.front();
			if(s.size()>n) {
				break;
			}
			st.push(s);
			q.push(s+"6");
			q.push(s+"8");
		
			q.pop();
		}
		while(!st.empty()){
			if(st.size()>1) cout<<st.top()<<" ";
			else cout<<st.top();
			st.pop();
			
		}
		cout<<endl;
	}
}
