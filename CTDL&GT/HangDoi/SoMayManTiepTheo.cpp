#include <bits/stdc++.h>
using namespace std;


void xuly(long long a,long long b){
	queue<long long> q;
	q.push(4);
	q.push(7);
	vector<long long> vt;
	vt.push_back(4);
	vt.push_back(7);
	while(1){
		long long i = q.front();q.pop();
		if(i>=b) break;
		int j = i*10+4; 
		if(j>=b) break;
		q.push(j);
		vt.push_back(j);
		int k = i*10+7;
		if(k>=b) break;
		q.push(k);
		vt.push_back(k);
	}
	long long kq=0;
	for(int i=a;i<=b;i++){
		long long m = lower_bound(vt.begin(),vt.end(),i) - vt.begin();
		kq = kq+vt[m];
	}
	cout<<kq<<endl;
}

main(){
	long long a,b;
	cin>>a>>b;
	xuly(a,b);
}
