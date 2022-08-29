#include <bits/stdc++.h>
using namespace std;

void xuly(int a[],int n){
	stack<int> st;
	stack<int> st2;
	int r[n+5]{0};
	for(int i=0;i<n;i++){
		int dem=0;
		while(!st.empty()&&a[i]>=a[st.top()]){
			r[i] = r[i]+r[st.top()];
			dem++;
			st.pop();
		}
		if(st.empty()) r[i] = i+1;
//        else if(dem==1) r[i]=r[i-1]+1;
        else if(dem>0) {
        	r[i] = r[i]+1;
		}
        else if(dem==0) r[i]=1;
        st.push(i);
		}
	for(int i=0;i<n;i++){
		cout<<r[i]<<" ";
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
		for(int i=0;i<n;i++){
			cin>>a[i];
		}
		xuly(a,n);
	}
}
