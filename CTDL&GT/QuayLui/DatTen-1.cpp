#include <bits/stdc++.h>
using namespace std;
int c[100];
int ok;
void ktao(int m,int k){
	for(int i=1;i<=k;i++) c[i]=i;
}
void sinhth(int m,int k){
	int i = k;
	while(i>0&&c[i]==m-k+i) i--;
	if(i>0){
		c[i]++;
		for(int j = i+1;j<=k;j++){
			c[j]=c[i]+j-i;
		}
	}
	else ok = 0;
}
void in(int k,string a[]){
	for(int i=1;i<=k;i++) cout <<a[c[i]]<<" ";
	cout<<endl;
}
main(){
	int n,k;
	cin>>n>>k;
	set<string, less<string>> s;
	for(int i=1;i<=n;i++){
		string str;
		cin>>str;
		s.insert(str);
	}
	string a[100];
	int j=1;
	for(auto i : s){
		string s = i;
		a[j]=s;
		j++;
	}
	int m=s.size();
	ok=1;
	ktao(m,k);
	while(ok){
		in(k,a);
		sinhth(m,k);
	}
	
}
