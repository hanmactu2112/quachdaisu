#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int n,c[20];

void xuly(){
	queue<string> q;
	q.push("2");
	q.push("3");
	q.push("5");
	q.push("7");
	while(true){
		string s = q.front();
		q.pop();
		if(s.size()>n) break;
		if(s.size()<=n&&stoi(s)%2!=0&&s.size()>3){
			for(int i=0;i<10;i++) c[i]=0;
			for(int i=0;i<s.size();i++){
				int x = s[i]-'0';
				c[x]++;
			}
			if(c[2]>0&&c[3]>0&&c[5]>0&&c[7]>0){
				cout<<s<<endl;
			}
		}
		string tmp = s+'2';
		q.push(tmp);
		tmp.clear();
		tmp = s+'3';
		q.push(tmp);
		tmp.clear();
		tmp = s+'5';
		q.push(tmp);
		tmp.clear();
		tmp = s+'7';
		q.push(tmp);
		tmp.clear();
	}
}

main(){
	cin>>n;
	xuly();
}
