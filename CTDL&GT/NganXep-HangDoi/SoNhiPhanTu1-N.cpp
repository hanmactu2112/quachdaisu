#include <bits/stdc++.h>
using namespace std;

main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		queue<string> q;
		q.push("1");
		string s;
		int dem=0;
		while(dem<n){
			s = q.front();
			cout<<s<<" ";
			q.push(s+"0");
			q.push(s+"1");
			q.pop();
			dem++;
		}
		cout<<endl;
	}
}
