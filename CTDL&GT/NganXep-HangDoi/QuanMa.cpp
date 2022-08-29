#include <bits/stdc++.h>
using namespace std;
int d1[8]={2,1,-1,-2,2,1,-1,-2};
int d2[8]={-1,-2,-2,-1,1,2,2,1};

void xuly(string s1, string s2){
	queue<string> q;
	q.push(s1);
	map<string,int> m;
	m[s1]=0;
	while(!q.empty()){
		string s = q.front();q.pop();
		if(s==s2){
			int d = m[s];
			cout<<d<<endl;
			break;
		}
		for(int i =0;i<8;i++){
			string tmp="";
			tmp = tmp + (char)(s[0]-'a'+d1[i]+'a');
			tmp = tmp + (char)(s[1]-'0'+d2[i]+'0');
			if(tmp[0]>='a'&&tmp[0]<='h'&&tmp[1]>='1'&&tmp[1]<='8'){
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
		string s1,s2;
		cin>>s1>>s2;
		xuly(s1,s2);
	}
}
