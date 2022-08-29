#include <bits/stdc++.h>
using namespace std;


void xuly(int a){
	queue<string> q;
	q.push("4");
	q.push("5");
	int ok=1;
	int dem=0;
	while(ok){
		string x = q.front();q.pop();
		dem++;
		if(dem<=a){
			string ss = x;
			reverse(ss.begin(),ss.end());
			cout<<x<<ss;
//			dao(x);
			cout<<" ";
		}
		else ok=0;
		string tmp = x+"4";
		q.push(tmp);
		tmp = x+"5";
		q.push(tmp);
	}
	cout<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		int a;
		cin>>a;
		xuly(a);
	}
}
