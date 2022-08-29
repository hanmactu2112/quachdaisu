#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<int> ds[1005];
set<pair<int, int>> s;
main(){
	int n;
	cin>>n;
	cin.ignore();
	for(int i=0;i<1005;i++) ds[i].clear();
	for(int i=0;i<n;i++){
		string s;
		getline(cin,s);
		for(int j=1;j<s.size();j++){
			int x = s[0] - '0';
			if(s[j]!=' '){
				int y = s[j]- '0';
				if(x>y){
					s.insert(make_pair(y,x));
				}
				else s.insert(make_pair(x,y));
			}
		}
	}
	for(auto i:m){
		cout<<i.first<<" "<<i.second<<endl;
	}
	cout<<endl;
}
