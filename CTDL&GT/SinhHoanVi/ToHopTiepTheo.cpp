#include <bits/stdc++.h>
using namespace std;

int t,n,k,ok,a[100],c[100];

void sinhTH(){
	int i=k;
	while(i>0&&a[i]==n-k+i){ 
		i--;
	}
	if(i>0){
		a[i]++;
		for(int j=i+1;j<=k;j++){
			a[j]=a[i]+j-i;
		}
	}

}
void in(){

	int dem=0;
		for(int i=1;i<=k;i++){
			for(int j=1;j<=k;j++){
				if(a[i]==c[j]) dem++;
			}
		}
		if(dem==k)	cout<<k<<endl;
		else cout<<k-dem<<endl;

}
main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		for(int i=1;i<=k;i++){
			cin>>a[i];
			c[i]=a[i];
		}

			sinhTH();
			in();

	}
}
