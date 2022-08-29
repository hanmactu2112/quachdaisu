#include <bits/stdc++.h>
#include <stack>
using namespace std;

void xuly(int a[],int n){
	stack<int> st;
	int c[n+5];
	stack<int> st2;
	for(int i=n;i>0;i--){
		while(!st.empty()&&a[i]>=st.top())st.pop();
		if(!st.empty()) {
			int x = st.top();
			int k = 0;
			int vt;
			for(int j=i+1;j<=n;j++){
				if(a[j]==st.top()) {
					vt = j;
					break;
				}
			}
			for(int j=vt+1;j<=n;j++){
				if(a[j]<st.top()) {
					st2.push(a[j]);
					k=1;
					break;
				}
			}
			if(k==0)st2.push(-1);
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
