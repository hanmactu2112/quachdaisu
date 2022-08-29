#include <bits/stdc++.h>
using namespace std;

struct so{
	int gtri,dem;
};

int t,a,b;

void xuly(){
	queue<so> q;
	set<int>s;
	q.push({a,0});
	s.insert(a);
	while(!q.empty()){
		so tmp = q.front();q.pop();
		if(tmp.gtri==b){
			cout<<tmp.dem<<endl;
			break;
		}
		if(tmp.gtri-1==b||tmp.gtri*2==b){
			cout<<tmp.dem+1<<endl;
			break;
		}
		if(tmp.gtri-1>0&&s.find(tmp.gtri-1)==s.end()){
			q.push({tmp.gtri-1,tmp.dem+1});
			s.insert(tmp.gtri-1);
		}
		if(tmp.gtri<b&&s.find(tmp.gtri*2)==s.end()){
			q.push({tmp.gtri*2,tmp.dem+1});
			s.insert(tmp.gtri*2);
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>a>>b;
		xuly();
	}
}
