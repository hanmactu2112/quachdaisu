#include <bits/stdc++.h>
using namespace std;

struct so{
	long long gt, dem;
};
void xuly(long long a){
	set<long long >s;
	s.insert(a);
	queue<so> q;
	q.push({a,0});
	while(!q.empty()){
		so tmp = q.front();
		q.pop();
		if(tmp.gt==1) {
			cout<<tmp.dem<<endl;
			break;
		}
		for(int i = sqrt(tmp.gt);i>=2;i--){
			if(tmp.gt%i==0&&s.find(tmp.gt/i)==s.end()){
				q.push({tmp.gt/i,tmp.dem+1});
				s.insert(tmp.gt/i);
			}
		}
		if(tmp.gt-1>0&&s.find(tmp.gt-1)==s.end()){
			q.push({tmp.gt-1,tmp.dem+1});
			s.insert(tmp.gt-1);
		}
	}
}


main(){
	int t;
	cin>>t;
	while(t--){
		long long a;
		cin>>a;
		xuly(a);
	}
}
