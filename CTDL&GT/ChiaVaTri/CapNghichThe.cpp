#include <bits/stdc++.h>
using namespace std;

long long merge(long long a[],long long l,long long m,long long r){
	vector<long long> x(a+l,a+m+1);
	vector<long long> y(a+m+1,a+r+1);
	long long kq = 0;
	long long i=0,j=0;
	while(i<x.size()&&j<y.size()){
		if(x[i]<=y[j]){
			a[l]=x[i];
			++l;
			++i;
		}
		else{
			kq = kq + x.size()-i;
			a[l]=y[j];
			++l;
			++j;
		}
	}
	while(x.size()>i){
		a[l] =x[i];
		++l;
		++i;
	}
	while(y.size()>j){
		a[l]=y[j];
		++l;
		++j;
	}
	return kq;
}

long long mergeSort1(long long a[],long long l,long long r){
	long long dem = 0;
	if(l<r){
		long long m=(l+r)/2;
		dem+=mergeSort1(a,l,m);
		dem+=mergeSort1(a,m+1,r);
		dem+= merge(a,l,m,r);	
	} 
	return dem;
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long n;
		cin>>n;
		long long a[n+5];
		for(int i=0;i<n;i++){
			cin>>a[i];
		}
		cout<<mergeSort1(a,0,n-1)<<endl;
		
	}
}
