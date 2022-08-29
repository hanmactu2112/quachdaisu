#include <bits/stdc++.h>
using namespace std;

void xuly(long long a[], long long n){
	stack<long long> st;
	stack<long long> st1;
	long long r[n+5];
	long long l[n+5];
	
	for(int i=n;i>0;i--){
		while(!st.empty()&&a[i]<=a[st.top()]) st.pop();
		if(st.empty()){
			r[i] = n+1;
		}
		else r[i] = st.top();
		st.push(i);
	}
	for(int i=1;i<=n;i++){
		while(!st1.empty()&&a[i]<=a[st1.top()]) st1.pop();
		if(st1.empty()){
			l[i] = 0;
		}
		else l[i] = st1.top();
		st1.push(i);
	}
	long long kq=0;
	for(int i=1;i<=n;i++){
		long long day = r[i]-l[i]-1;
		if(a[i]<=day) kq = max(kq,a[i]);
	}
	cout<< kq<<endl;
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
