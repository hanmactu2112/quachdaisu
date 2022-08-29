#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int ok;
void xuly(string s){
	int i = s.size()-1;
	while(i>0&&s[i]=='1'){
		s[i]='0';
		i--;
	}
	if(i>0) 
	{
		s[i] = '1';
	}
	else {
		for(int i=0;i<s.size();i++){
			s[i]='0';
		}
	}
			cout<<s<<endl;

}

main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		xuly(s);
	}
}

