#include<bits/stdc++.h>
using namespace std;
int a[1005];
int b[1005];
int n,k,dem;

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
	b[0]=0;
	for(int j=b[i-1]+1;j<=n;j++){
		if(sum+a[j]<=k){
			b[i]=j;
			sum=sum+a[j];
			if(sum==k) in(i);
			else Try(i+1,sum);
			sum = sum-a[j];
		}
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		dem=0;
		cin>>n>>k;
		for(int i=1;i<=n;i++) cin>>a[i];
		sort(a,a+n+1);
		Try(1,0);
		if(dem==0) cout<<"-1";
		cout<<endl;
	}
}

