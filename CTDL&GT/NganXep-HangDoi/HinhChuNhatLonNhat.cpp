#include <bits/stdc++.h>
using namespace std;

void xuly(long long a[],long long n){
	stack<long long >st;
	stack<long long >st1;
	long long r[n+5];
	long long l[n+5];
	for(int i=n;i>=1;i--){
		while(!st.empty()&&a[i]<=a[st.top()]){
			st.pop();
		}
		if(!st.empty()) {
			r[i]=st.top();
		}
		else {
			r[i]=n+1;
		}
		st.push(i);
	}
	for(int i=1;i<=n;i++){
		while(!st1.empty()&&a[i]<a[st1.top()]){
			st1.pop();
		}
		if(!st1.empty()) {
			l[i]=st1.top();
		}
		else {
			l[i]=0;
		}
		st1.push(i);
	}
	long long dt=0;
	for(int i=1;i<=n;i++){
		dt = max(dt,(r[i]-l[i]-1)*a[i]);
	}
	cout<<dt<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long n;
		cin>>n;
		long long a[n+5];
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		xuly(a,n);
	}
}
