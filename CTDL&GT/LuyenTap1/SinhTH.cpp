#include <bits/stdc++.h>
using namespace std;
int t,n,k,a[100],ok;
void ktao(){
	for(int i=1;i<=k;i++){
		a[i]=i;
	}
}
void print() {
	if (ok) {
		for(int i = 1 ; i <= k; i++)
			cout << a[i] ; 
			cout<<" ";
	} 
	
	
}
void sinhTH(){
	int i = k;
	while (i > 0 && a[i] == n-k+i)	i--;
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
		ktao();
		while(ok){
			print();
			sinhTH();
		}
		cout << endl;
	}
}
