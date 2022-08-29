#include <bits/stdc++.h>
using namespace std;
int n,a[100005];

void xuly(){
	stack<int>st;
	int r[n+5],l[n+5];
	for(int i=1;i<=n;i++){
		while(!st.empty()&&a[i]<=a[st.top()]){
			st.pop();
		}
		if(!st.empty()) l[i]=st.top();
		else l[i] = 0;
		st.push(i);
	}
	while(!st.empty()) st.pop();
	for(int i=n;i>=1;i--){
		while(!st.empty()&&a[i]<=a[st.top()]){
			st.pop();
		}
		if(!st.empty()) r[i]=st.top();
		else r[i]=n+1;
		st.push(i);
	}
	long long kq=0;
	for(int i=1;i<=n;i++){
		kq = max(kq,(long long)a[i]*(r[i]-l[i]-1));
	}
	cout<<kq<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		xuly();
	}
}
