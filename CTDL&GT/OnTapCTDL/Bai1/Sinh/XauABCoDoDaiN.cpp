#include <bits/stdc++.h>
#include <iostream>
using namespace std;
char s[1005];
int ok;
void ktao(int n){
	for(int i=1;i<=n;i++){
		s[i]='A';
	}
}
void xuly(int n){
	int i = n;
	while(i>0&&s[i]=='B'){
		s[i]='A';
		i--;
	}
	if(i>0) 
	{
		s[i] = 'B';
	}
	else {
		ok=0;
	}
}

main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		ok=1;
		ktao(n);
		while(ok){
			for(int i=1;i<=n;i++) cout<<s[i];
			cout<<" ";
			xuly(n);
		}
		cout<<endl;
	}
}

