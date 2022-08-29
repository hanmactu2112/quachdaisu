#include <bits/stdc++.h>
using namespace std;

struct so{
	int gtri,dem;
};

int t,a;

void xuly(){
	queue<so> q;
	set<int>s;
	q.push({a,0});
	s.insert(a);
	while(!q.empty()){
		so tmp = q.front();q.pop();
		if(tmp.gtri==1){
			cout<<tmp.dem<<endl;
			break;
		}
		if(tmp.gtri-1>0&&s.find(tmp.gtri-1)==s.end()){
			q.push({tmp.gtri-1,tmp.dem+1});
			s.insert(tmp.gtri-1);
		}
		for(int i = sqrt(tmp.gtri);i>=2;i--){
			if(tmp.gtri%i==0 && s.find(tmp.gtri/i)==s.end()){
				q.push({tmp.gtri/i,tmp.dem+1});
				s.insert(tmp.gtri/i);
			}
		}
	}
}

main(){
	cin>>t;
	while(t--){
		cin>>a;
		xuly();
	}
}
