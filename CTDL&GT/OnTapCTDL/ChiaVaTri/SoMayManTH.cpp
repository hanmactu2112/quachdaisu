#include <bits/stdc++.h>
#include <iostream>
using namespace std;
long long a,b;
vector<long long>vt;
void tinh(){
	queue<long long>q;
	long long tmp=0;
	q.push(tmp);
	 while(q.front()<=1e9){
	 	long long x = q.front();q.pop();
	 	vt.push_back(x);
	 	q.push(x*10+4);
	 	q.push(x*10+7);
	 }
}
void xuly(){
	int vtri = lower_bound(vt.begin()+1,vt.end(),a)-vt.begin();
	long long sum=0;
	for(int i=a;i<=b;i++){
		if(i<=vt[vtri]) sum = sum+vt[vtri];
		else {
			vtri = lower_bound(vt.begin()+1,vt.end(),i)-vt.begin();
			sum = sum+vt[vtri];
		}
	}
	cout<<sum<<endl;
}

main(){
	int t;
	cin>>t;
	tinh();
	while(t--){
		cin>>a>>b;
		xuly();
	}
}
