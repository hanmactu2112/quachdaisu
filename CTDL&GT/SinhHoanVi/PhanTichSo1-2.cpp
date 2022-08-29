#include <bits/stdc++.h>
using namespace std;
int t,n,ok,a[100],k;
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=1;
	}
}
 
void sinhHV(){
	int j=n;
	int bd=1;
	while(j>0&&a[j]>k-n){
		a[j]=1;
		j--;	
	}
	if(j>0&&a[1]<=k-n+1){
		a[j]++;
	}
//	if(j>n-k+n){
//		a[j]++;
//	}
	else {
		ok=0;
		n--;
//		ktao();
	}
}
bool ktra(){
	int tong =0;
	for(int i=1;i<=n;i++){
		if(a[i]<a[i+1])	return false;
		else	tong=tong+a[i];
	}
	if(tong==k) return true;
	return false;
}
 
main(){
	cin>>t;
	while(t--){
		cin>>n;
		vector<vector<int> > v;
		k=n;
		ktao();
		while(n>0){
			if(ktra()){
				vector<int> res(a + 1, a + 1 + n);
				v.push_back(res);
			}
			sinhHV();
		}
		
		
		for(int i = v.size()-1; i>=0; i--){
			cout<<"(";
			for(int j = 0; j<v[i].size(); j++){
				if(j<v[i].size()-1)
					cout << v[i][j] << " ";
				else cout << v[i][j];
			}
			if(i>0)
				cout<<")"<<" ";
			else cout<<")";
		}
		
		cout<<endl;
	}
}
