#include <bits/stdc++.h>
using namespace std;


int t,n,m,truoc[500005];
vector<pair<int,int>> ds[500005];
long long d[500005];



void tim(int h1, int s1){
	priority_queue<pair<long long,long long>,vector<pair<long long,long long>>,greater<pair<long long,long long>>> q;
	for(int i=1;i<=m;i++){
		d[i]=1e9;
		truoc[i]=0;
	}
	d[h1]=0;
	q.push({0,h1});
	while(!q.empty()){
		long long u = q.top().second;q.pop();
		for(auto i:ds[u]){
			long long v = i.second;
			long long d_v= i.first;
			if(d[v]>d[u]+d_v){
				d[v]=d[u]+d_v;
				q.push({d[v],v});
				truoc[v]=u;
			}
		}
	}
}

main(){
	cin>>t;
	while(t--){
		for(int i=0;i<=500005;i++){
			ds[i].clear();
		}
		cin>>n>>m;
		int h1,s1,h2,s2;
		cin>>h1>>s1>>h2>>s2;
		for(int i=1;i<=m;i++){
			int x,y,z;
			cin>>x>>y>>z;
			ds[x].push_back({z,y});
		}
		int dem[m+5];
		memset(dem,0,sizeof(dem));
		int kq=0;
		tim(h1,s1);
		stack<int>st;
		st.push(s1);
		while(st.top()!=h1){
			st.push(truoc[st.top()]);
		}
		int duong1=st.size()-2;
		while(!st.empty()){
			if(st.top()!=h1&&st.top()!=s1){
				dem[st.top()]++;
			}
			st.pop();
		}
		tim(h2,s2);
		st.push(s2);
		while(st.top()!=h2){
			st.push(truoc[st.top()]);
		}
		int duong2=0;
		while(!st.empty()){
			if(st.top()!=h2&&st.top()!=s2){
				if(dem[st.top()]>0) {
					dem[st.top()]++;
					duong2++;
				}
				else dem[st.top()]++;
			}
			st.pop();
		}
		for(int i=1;i<=n;i++){
			if(dem[i]>1)kq++;
			
		}
		 cout<<kq<<endl;
	}
}
