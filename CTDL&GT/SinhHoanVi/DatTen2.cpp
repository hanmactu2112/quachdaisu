#include<bits/stdc++.h>
using namespace std;

int t,n,k,ok,a[25];
char c[25];
void ktao(){
	for(int i=1;i<=n;i++){
		a[i]=i;
	}
//	char c[16]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'};
	c[1]={'A'};c[2]={'B'};c[3]={'C'};c[4]={'D'};
	c[5]={'E'};c[6]={'F'};c[7]={'G'};c[8]={'H'};
	c[9]={'I'};c[10]={'J'};c[11]={'K'};c[12]={'L'};
	c[13]={'M'};c[14]={'N'};c[15]={'O'};c[16]={'P'};
	
}
void sinhTH(){
	int i=k;
	while(i>0&&a[i]==n-k+i)i--;
	if(i>0){
		a[i]++;
		for(int j=i+1;j<=k;j++){
			a[j]=a[i]+j-i;
		}
	}
	else ok=0;
}
void in(){
	for(int i=1;i<=k;i++){
		cout<<c[a[i]];
	}
	cout<<endl;
}
main(){
	cin>>t;
	while(t--){
		cin>>n>>k;
		ok=1;
		ktao();
		while(ok){
		in();		
			sinhTH();
			
		}
	}
}
