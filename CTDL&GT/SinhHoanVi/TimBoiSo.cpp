#include <bits/stdc++.h>
using namespace std;

long long bSo[501];
bool check[501];

void timBoi() {
	queue<long long>  q;
	q.push(9);
	int dem = 0;
	while(dem < 500) {
		long long a = q.front();
		q.pop();
		
		for(int i = 1; i <= 500 ; i++) {
			if(a >= i) {
				if(a%i == 0  && !check[i]) {
					bSo[i] = a;
					check[i] = true;
					dem++;
				}
			} else break;	
		}
		
		q.push(a * 10);
		q.push(a * 10 + 9);
	}
}
main(){
	int t;
	cin >> t;
	timBoi();
	
	while(t--){
		int n;
		cin >> n;
		cout << bSo[n] << endl;
	}
}
