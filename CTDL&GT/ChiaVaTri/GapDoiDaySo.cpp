#include <bits/stdc++.h>
using namespace std;
int timK(int n, long long k) {
	if(k == 1)	
		return 1;
		
	if(k == pow(2, n-1))	
		return n;
		
	if(k < pow(2, n-1))	
		return timK(n-1, k);
		
	return timK(n-1, k-pow(2, n-1));
}
main() {
	int t;
	cin >> t;
	
	while(t--) {
		int n;
		long long k;
		cin >> n >> k;
		cout << timK(n, k) << endl; 
	}
}
