#include <bits/stdc++.h>
using namespace std;

int n,a[25],b[25];
vector<vector<string>> vt;
void in(int m){
	vector<string> vt1;
	for(int i=1;i<=m;i++){
		vt1.push_back(to_string(a[b[i]]));
	}
	vt.push_back(vt1);
}
void xuly(int i){
	for(int j=b[i-1]+1;j<=n;j++){
		if(a[j]>a[b[i-1]]){
			b[i]=j;
			if(i>=2) in(i);
			xuly(i+1);
		}
	}
}

main(){
	cin>>n;
	for(int i=1;i<=n;i++) cin>>a[i];
	xuly(1);
	sort(vt.begin(),vt.end());
	for(int i=0;i<vt.size();i++){
		for(int j=0;j<vt[i].size();j++){
			cout<<vt[i][j]<<" ";
		}
		cout<<endl;
	}
}
