#include <bits/stdc++.h>
using namespace std;

struct so{
	int gtri, dem;
};
void xuly(int a, int b){
	set<int> s;
	queue<so> q;
	s.insert(a);
	q.push({a,0});
	while(!q.empty()){
		so tmp = q.front();
		q.pop();
//		cout<<tmp.dem<<endl;
		
		if(tmp.gtri==b) {
			cout<<tmp.dem<<endl;
			break;
		}
		if(tmp.gtri*2==b||tmp.gtri-1==b) {
			cout<<tmp.dem+1<<endl;
			break;
		}
		if(s.find(tmp.gtri*2)==s.end()&&tmp.gtri<b){
			q.push({tmp.gtri*2,tmp.dem+1});
			s.insert(tmp.gtri*2);
		}
		if(s.find(tmp.gtri-1)==s.end()&&tmp.gtri-1>0){
			q.push({tmp.gtri-1,tmp.dem+1});
			s.insert(tmp.gtri-1);
		}   
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		int a,b;
		cin>>a>>b;
		xuly(a,b);
	}
}
