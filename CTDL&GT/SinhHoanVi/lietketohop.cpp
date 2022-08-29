#include <bits/stdc++.h>
using namespace std;
int n,k,a[20],dem,b[20],ok;
void ktao(){
	for(int i=1;i<=k;i++){
		a[i]=i;
	}
}
void sinhTH(){
	int i=k;
	while(i>0&&a[i]==dem-k+i)i--;
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
		cout<<b[a[i]]<<" ";
	}
	cout<< endl;
}
main(){
		cin>>n>>k;
		set<int> s;
		for(int i=1;i<=n;i++){
			cin>>a[i];
			s.insert(a[i]);
		}
		 dem=0;
   		 for(auto x:s){
        	b[++dem]=x;
    	}
    	ktao();

    	if(dem < k)
    		k=dem;
    	
    		ok=1;
			while(ok){
				in();
				sinhTH();
			}
		
		
}
