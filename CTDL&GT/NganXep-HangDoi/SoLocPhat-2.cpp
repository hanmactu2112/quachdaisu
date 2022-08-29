#include <bits/stdc++.h>
using namespace std;

main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		queue<string> q;
		queue<string> q2;
		q.push("6");
		q.push("8");
		int ok=1;
		string s;
		while(ok){
			s = q.front();
			if(s.size()>n) {
				break;
			}
			q2.push(s);
			q.push(s+"6");
			q.push(s+"8");
		
			q.pop();
		}
		cout<<q2.size()<<endl;
		while(!q2.empty()){
			if(q2.size()>1) cout<<q2.front()<<" ";
			else cout<<q2.front();
			q2.pop();
		
		}
		cout<<endl;
	}
}
