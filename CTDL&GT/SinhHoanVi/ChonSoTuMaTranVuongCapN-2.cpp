#include <bits/stdc++.h>
using namespace std;
int ok,a[100],n,k,c[100][100],dem,tong,cach;
int b[100][100];
string d[100];

void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=1;
	}
}
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i];
	}
	cout<<" ";
}
void sinhHV(){
	int j=n;
	while(j>0&&a[j]==n){
		a[j]=1;
		j--;
	
	}
	if(j>0){
		a[j]++;
		}
	else ok = 0;
}
void ktra(){
	tong=0;
	dem=1;
	for(int i=1;i<=n;i++){
		tong=tong+c[dem][a[i]];
		
		dem++;
	}
	dem=1;
	int ktra=0;
	for(int i=1;i<=n;i++){
		if(tong==k&&b[dem][a[i]]!=1) {
			d[cach]=d[cach]+" "+to_string(a[i]);
			b[dem][a[i]]=1;
			ktra++;
		}
		dem++;	
	}
	if(ktra==n) cach++;
}
main(){
	cin>>n>>k;
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			cin>>c[i][j];
		}	
	}
		ok=1;
		ktao();
		cach=1;
		while(ok){
			ktra();
			sinhHV();
		}
		cout<<cach<<endl;
		for(int i=1;i<=dem;i++){
		cout<<d[i]<<endl;
	}
}

