#include<bits/stdc++.h>
#include <math.h>
using namespace std;
int n;
int a[105][105];
vector<string>vt;

struct duong{
	int x,y;
	string z;
};
bool tmp(string a,string b){
	if(a.length()>b.length()) return a>b;
	if(a.length()==b.length()) {
		if(a<b) return a<b;
	}
}
void xuly(){
	queue<duong>q;
	int x =a[1][1];
	q.push({1,1,to_string(x)});
	while(!q.empty()){
		duong h=q.front();q.pop();
		if(h.x==n&&h.y==n) vt.push_back(h.z);
		if(h.x<n) {
			q.push({h.x+1,h.y,h.z+to_string(a[h.x+1][h.y])});
		}
		if(h.y<n) {
			q.push({h.x,h.y+1,h.z+to_string(a[h.x][h.y+1])});
		}
	}
}
main(){
	cin>>n;
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			cin>>a[i][j];
		}
	}
	xuly();
	sort(vt.begin(),vt.end(),tmp);
	string s = vt[vt.size()-1];
	cout<<std::hex<<stoi(s,0,2)<<endl;
}
