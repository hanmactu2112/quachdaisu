#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int n,a[1005],b[1005],k,dem;

void in(int m){
	cout<<"[";
	for(int i=1;i<m;i++){
		cout<<a[b[i]]<<" ";
	}
	cout<<a[b[m]];
	cout<<"] ";
	dem++;
}
void Try(int i,int sum){
	for(int j = b[i-1]+1;j<=n;j++){
		if(sum+a[j]<=k){
			b[i]=j;
			sum=sum+a[j];
			if(sum==k) in(i);
			else Try(i+1,sum);
			sum=sum-a[j];
		}
	}
}

main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n>>k;
//		memset(a,0,sizeof(a));
//		memset(b,0,sizeof(b));
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		dem=0;
		sort(a,a+n+1);
 		Try(1,0);
 		if(dem>0)cout<<endl;
 		else cout<<"-1"<<endl;
	}
}
