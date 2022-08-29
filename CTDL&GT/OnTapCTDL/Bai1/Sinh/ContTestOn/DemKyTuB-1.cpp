#include <bits/stdc++.h>
using namespace std;
long long F[100],s[100],dem;

void xuly(long long n,long long m){
	if(m==0) {
		dem=0;
		return;
	}
	if(n==0) {
		return;
	}
	if(n==1) {
		dem=dem+1;
		return;
	}
	if(n==2) {
		dem=dem+1;
		return;
	}
//	if(m=F[n-1]) {
//		dem=dem+s[n-1];
//		return;
//	}
	if(m<=F[n-1]) return xuly(n-1,m);
	else {
		dem=dem+s[n-1];
		return xuly(n-1,m-F[n-1]);
	}
}
main(){
	F[0]=1;
   	F[1]=1;
    F[2]=2;
    s[0]=0;
   	s[1]=1;
    s[2]=1;
    for(int i=3;i<=46;i++){
        F[i]=F[i-1]+F[i-2];
        s[i] = s[i-1]+s[i-2];
    }
    int t; cin >> t;
    while(t--){
        long long n; long long m;
        cin >> n >> m;
        dem=0;
        xuly(n,m);
        cout<<dem<<endl;
    }
}

