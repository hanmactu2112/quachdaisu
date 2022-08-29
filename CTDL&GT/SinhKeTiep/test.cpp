#include <bits/stdc++.h>
using namespace std;
main(){
	int n=6;
	int a[6];
	a[1]=1;
	a[2]=0;
	a[3]=0;
	a[4]=0;
	a[5]=1;
	a[6]=0;int k=5;
	for(int i=1;i<=n;i++){
		if((a[i]==1&&a[i]==a[i+1])||(a[i]==0&&a[i]==a[i+1]&&a[i+1]==a[i+2]&&a[i+2]==a[i+3])) k=0;
		else if(a[1]!=1||a[n]!=0) k=0;
	};
cout<<k;

}

