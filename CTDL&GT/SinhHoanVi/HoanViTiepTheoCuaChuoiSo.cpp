#include <bits/stdc++.h>
using namespace std;
int n,ok;
string a;
void sinhHV(){
	int j=a.length()-1-1;
	while(j>0&&a[j]>=a[j+1])j--;
	if(j>0){
		int k = a.length()-1;
		while(a[j]>=a[k])k--;
		int t = a[j]; a[j]=a[k];a[k]=t;
		int r=j+1,s=a.length()-1;
		while(r<=s){
			t=a[r];a[r]=a[s];a[s]=t;
			r++;s--;
		}
	}
	else ok = 0;
}

main(){
	int t;
	cin>>t;
	while(t--){
		ok=1;
		cin>>n;
		cin>>a;
		sinhHV();
		if(ok){
			cout<<n<<" "<<a<<endl;
		}
		else  cout<<n<<" "<<"BIGGEST"<<endl;
	}
}
