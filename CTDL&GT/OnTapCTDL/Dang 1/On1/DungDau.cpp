#include <bits/stdc++.h>
using namespace std;

int n,b[25];
bool chuaxet[25];
string a[25],s;
void in(){
	if(a[b[1]]==s){
		for(int i=1;i<=n;i++){
			cout<<a[b[i]]<<" ";
		}
		cout<<endl;
	}
}
void xuly(int i){
	for(int j=1;j<=n;j++){
		if(!chuaxet[j]){
			chuaxet[j]=true;
			b[i]=j;
			if(i==n) in();
			else xuly(i+1);
			chuaxet[j]=false;
		}
	}
}

main(){
	cin>>n;
	for(int i=1;i<=n;i++) cin>>a[i];
	cin>>s;
	sort(a,a+n+1);
	xuly(1);
}

