#include <bits/stdc++.h>
using namespace std;

int a[1000], n, k, ok = 1;

void print() {
	if (ok) {
		for(int i = 1 ; i <= k; i++)
			cout << a[i] << " ";
	} 
	else {
		for(int i = 1 ; i <= k; i++)
			cout << i << " ";
	}
	
	cout << endl;
}

void next() {
	int i = k;
	while (i > 0 && a[i] == n-k+i)	i--;
	if (i > 0) {
		a[i]++;
		for(int j = i+1; j <= k; j++)
			a[j] = a[i]+j-i;
	}
	else ok = 0;
}

int main() {
	int t;
	cin >> t;
	
	while (t--){
		cin >> n >> k;
	
		for (int i = 1; i <= k; i++) {
			cin >> a[i];
		}
		
		while (ok) {
			next();	
			print();
			break;
		}
	}	
}
