#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int d1[8]={2,1,-1,-2,2,1,-1,-2};
int d2[8]={-1,-2,-2,-1,1,2,2,1};


void xuly(string s1,string s2){
	queue<string> q;
	map<string,int> m;
	q.push(s1);
	m[s1]=0;
	while(!q.empty()){
		string s = q.front();q.pop();
		if(s==s2){
			cout<<m[s]<<endl;
			break;
		}
		for(int i=0;i<8;i++){
			string tmp = "";
			tmp=tmp+(char)(s[0]-'a'+d1[i]+'a');
			tmp = tmp+(char)(s[1]-'0'+d2[i]+'0');
			if(tmp[0]>='a'&&tmp[0]<='h'&&tmp[1]>'0'&&tmp[1]<='8'){
				if(m[tmp]==0){
					q.push(tmp);
					m[tmp] = m[s]+1;
				}
			}
		}
	}
}

main(){
	int t;
	cin>>t;
	while(t--){
		string a,b;
		cin>>a>>b;
		xuly(a,b);
	}
}
