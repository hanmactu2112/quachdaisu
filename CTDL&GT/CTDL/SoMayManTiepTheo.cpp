#include <bits/stdc++.h>
using namespace std;

void xuly(int a, int b){
	queue <char> st;
	st.push('4');
	while(true){
		char x = st.front();
		st.pop();
		cout<<x<<endl;
		st.push(x+'4');
		st.push(x+'7');
	}
}

main(){
	int a,b;
	cin>>a>>b;
	xuly(a,b);
}
