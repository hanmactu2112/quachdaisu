#include <bits/stdc++.h>
using namespace std;

int n,k,a[100],ok;
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=0;
	}
}
void sinh(){
	int i=n;
	while(i>=1&&a[i]==1){
		a[i]=0;
		i--;
	}
	if(i==0){
		ok = 0;
	}
	else{
		a[i]=1;
	}
}
void in(){
	for(int i=1;i<=n;i++){
				cout<<a[i]<<" ";
			}
				cout <<endl;
}
int ktra(){
	int tong = 0, dem = 0;
	for(int i = 1; i <= n; i++) {
		if(a[i] == 0)	tong++;
		else tong = 0;	
		if(tong > k)	return 0;
		else if(tong == k)	dem++;
	}
	return dem;
}

main(){
	cin>>n>>k;
	ok=1;
	ktao();
	queue<string> q;
	
	while(ok){
		sinh();
		if(ktra() == 1){
			string str;
			for(int i=1;i<=n;i++){
				if(a[i]==1) str.push_back('B');
				else str.push_back('A');
			}
			q.push(str);
		}
		
			
	}
	cout<<q.size()<<endl;
		while(!q.empty()){
			string s = q.front();
			cout<<s<<endl;
			q.pop();
		}
}
