#include <bits/stdc++.h>
using namespace std;

void xuly(int a[],int n){
	stack<int> st;
	stack<int> st2;
	for(int i=n;i>0;i--){
		while(!st.empty()&&a[i]>=st.top()) st.pop();
		if(!st.empty()) {
			st2.push(st.top());
		}
		else {
			st2.push(-1);
		}
		st.push(a[i]);
	}
	while(!st2.empty()) {
		cout<<st2.top()<<" ";
		st2.pop();
	}
	cout<<endl;
}
main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		int a[n+5];
		for(int i=1;i<=n;i++) {
			cin>>a[i];
		}
		xuly(a,n);
	}
}
