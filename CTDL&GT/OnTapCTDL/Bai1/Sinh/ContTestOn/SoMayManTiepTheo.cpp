#include<bits/stdc++.h>
#include<iostream>
using namespace std;

void xuly(long long a, long long b){
	queue<long long> q;
	q.push(4);
	q.push(7);
	vector<long long> vt;
	vt.push_back(4);
	vt.push_back(7);
	while(q.front()<=1e9){
		long long i = q.front();q.pop();
		long long j = i*10+4;
		q.push(j);
		vt.push_back(j);
		long long k = i*10+7;
		q.push(k);
		vt.push_back(k);
	}
	long long kq=0,m=0;
	long long g = lower_bound(vt.begin(),vt.end(),a)-vt.begin();
	while(a<=b){
		m = min(vt[g],b)-a+1;
		kq = kq+m*vt[g];
		a=vt[g]+1;
		g++;
	}

	cout<<kq<<endl;
}

main(){
	long long a,b;
	cin>>a>>b;
	xuly(a,b);
}
