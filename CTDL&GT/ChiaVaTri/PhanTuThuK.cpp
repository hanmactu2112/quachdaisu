#include <bits/stdc++.h>
using namespace std;

void merge(int a[],int l,int m,int r){
	vector<int> x(a+l,a+m+1);
	vector<int> y(a+m+1,a+r+1);
	int i=0,j=0;
	while(i<x.size()&&j<y.size()){
		if(x[i]<y[j]){
			a[l]=x[i];
			++i;
			++l;
		}
		else {
			a[l]=y[j];
			++j;
			++l;
		}
	}
	while(i<x.size()){
		a[l]=x[i];++l;++i;
	}
	while(j<y.size()){
		a[l]=y[j];++l;++j;
	}
	
}
void mergeSort(int a[],int l,int r){
	if(l>=r) return;
	int m = (l+r)/2;
	mergeSort(a, l, m);
	mergeSort( a, m+1, r);
	merge(a,l,m,r);
}
//int timkiem(int a[],int k, int l,int r){
//	if(l>r) return -1;
//	int m =(r+l)/2;
//	if(a[m]==k) return m;
//	else if(a[m]>k) return timkiem(a, k, m+1, r);
//	else return timkiem(a, k, l,m+1);
//
//}

main(){
	int t,m,n,k;
	cin>>t;
	while(t--){
		cin>>m>>n>>k;
		int a[m+n+5];
		for(int i=0;i<m+n;i++){
			cin>>a[i];
		}
		
		mergeSort(a,0,m+n-1);
		cout<<a[k-1]<<endl;
//		cout<<timkiem(a,k,0,m+n-1)<<endl;
	}
	
}
