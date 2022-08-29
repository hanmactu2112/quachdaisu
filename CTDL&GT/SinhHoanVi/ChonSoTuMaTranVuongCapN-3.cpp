#include <bits/stdc++.h>
#include <vector>
using namespace std;
 
vector<vector<int> > v;
int n, k, ok = 1, a[11][11], b[11];
 
void khoiTao() {
	for(int i = 1; i <= n; i++){
		b[i] = i;
	}
}
 
void sinhHV() {
	int j = n-1;
	while(j > 0 && b[j] > b[j+1])	j--;
 
	if(j > 0) {
		int t = n;
		while(b[j] > b[t])	t--;
 
		int tmp = b[j];		b[j] = b[t];		b[t] = tmp;
 
		int r = j + 1, s = n;
		while(r <= s) {
			tmp = b[r];		b[r] = b[s];		b[s] = tmp;
			r++;	s--;
		}
	}
	else ok = 0;
}
 
void kTraTong() {
	int tong = 0;
	for(int i = 1; i <= n; i++){ 
		tong += a[i][b[i]];
	}
 
	if(tong == k) {
		vector<int> d(b + 1, b + 1 + n);
		v.push_back(d);
	}
}
 
main(){
	cin >> n >> k;
 
	for(int i = 1; i <= n; i++) {
		for(int j = 1; j <= n; j++) {
			cin >> a[i][j];
		}
	}
 
	khoiTao();
	while(ok){
		kTraTong();
		sinhHV();
	}
 
	cout << v.size() << endl;
	for(int i = 0; i < v.size(); i++) {
		for(int j = 0; j < n; j++) {
			cout << v[i][j] << " ";
		}
		cout << endl;
	}
}
