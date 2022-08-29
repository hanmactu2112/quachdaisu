#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int n,k,a[100],b[100];
bool isfinal;

void in(){
	for(int i=1;i<=k;i++){
	   cout<<b[a[i]]<<" ";
	}
	cout<<endl;
}
void xuly(){
	int i=k;
	while(i>0&&a[i]==n-k+i)i--;
	if(i>0){
		a[i]++;
		for(int j=i+1;j<=k;j++){
			a[j]=a[i]+j-i;
		}
	}
	else isfinal=true;
}
int main(){
		cin>>n>>k;
		for(int j=1;j<=n;j++){
			cin>>b[j];
		}
		for(int i=1;i<=k;i++){
			a[i]=i;
		}
		sort(b,b+n+1);
		for(int i=1;i<=n;i++){
	  		 cout<<b[i]<<" ";
		}
		cout<<endl;
//		isfinal=false;
//		while(isfinal==false){
//			in();
//			xuly();
//		}
	}
