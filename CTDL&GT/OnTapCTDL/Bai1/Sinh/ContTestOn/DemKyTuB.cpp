#include <bits/stdc++.h>
using namespace std;
long long F[100],s[100],dem;

long long xuly(long long n,long long m){
	if(n==0) return dem;
	if(n==1) {
		return dem+1;
	}
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
    for(int i=3;i<=50;i++){
        F[i]=F[i-1]+F[i-2];
        s[i] = s[i-1]+s[i-2];
    }
    int t; cin >> t;
    while(t--){
        long long n; long long m;
        cin >> n >> m;
        dem=0;
        cout<<xuly(n,m)<<endl;
    }
}
