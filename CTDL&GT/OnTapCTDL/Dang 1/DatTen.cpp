#include<bits/stdc++.h>
using namespace std;

int n,b[25],k,dem=1;
string a[25];

void in1(){
	for(int i=1;i<=k;i++){
		cout<<a[b[i]]<<" ";
	}
	cout<<endl;
}
void xl(int i){
	for(int j = b[i-1]+1;j<dem;j++){
		b[i]=j;
		if(i==k) in1();
		else xl(i+1);
	}
}

main(){
	set<string> s;
	cin>>n>>k;
	for(int i=1;i<=n;i++){
		string str;
		cin>>str;
		s.insert(str);
	}
	for(auto v:s){
		a[dem++]= v;
	}
	xl(1);
}
