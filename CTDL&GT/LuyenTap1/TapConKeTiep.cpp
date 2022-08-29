#include <bits/stdc++.h>
using namespace std;
int t,n,k,a[1000],ok;

void in(){
	if(ok){
	for(int i=1;i<=k;i++){
		 cout<<a[i]<<" ";
		}
	}
	else{
		for(int i=1;i<=k;i++){
		cout<<i<<" ";
		}
	} 
	cout << endl;
}
void sinhTH(){
	int i=k;
	while(i>=1&&a[i]==n-k+i){
		--i;
	}
	if (i > 0) {
	a[i]++;
	for(int j = i+1; j <= k; j++)
		a[j] = a[i]+j-i;
	}
	else ok = 0;
	
}
main(){
	cin>>t;
	while(t--){
		ok=1;
		cin>>n>>k;
		for(int i=1;i<=k;i++){
			cin>>a[i];
		}
		sinhTH();
		in();

	}
}
