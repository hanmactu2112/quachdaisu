#include <bits/stdc++.h>
#include <iostream>
using namespace std;


void xuly(string s1,int k){
	priority_queue<long long, vector<long long>, less <long long> > q;
	map<char,long long> m;
	for(int i=0;i<s1.size();i++){
		m[s1[i]]++;
	}
	for(auto i: m){
		q.push(i.second);
	}
	while(k--){
		long long x = q.top();q.pop();
		x--;
		q.push(x);
	}
	long long kq = 0;
	while(!q.empty()){
		kq = kq+(q.top()*q.top());q.pop();
	}
	cout<<kq<<endl;
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long k;
		string a;
		cin>>k>>a;
		xuly(a,k);
	}
}
