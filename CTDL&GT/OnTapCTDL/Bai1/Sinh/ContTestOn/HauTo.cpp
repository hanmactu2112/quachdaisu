#include<bits/stdc++.h>
using namespace std;
int n;
string a[1005];
bool ktra(string s){
	if(s=="+"||s=="-"||s=="*"||s=="/") return true;
	else return false;
}
long long hauto(long long a, long long b,string s){
	if(s=="+") return a+b;
	if(s=="*") return a*b;
	if(s=="-") return a-b;
	if(s=="/") return a/b;
}
void xuly(){
	stack<long long> st;
	for(int i=1;i<=n;i++){
		if(!ktra(a[i])){
			st.push(stoi(a[i]));
		}
		else {
			string dau = a[i];
			long long a = st.top();st.pop();
			long long b = st.top();st.pop();
			long long x = hauto(b,a,dau);
			st.push(x);
		}
	}
	cout<<st.top()<<endl;
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
