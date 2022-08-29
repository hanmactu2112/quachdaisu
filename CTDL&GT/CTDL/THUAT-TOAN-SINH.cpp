#include<bits/stdc++.h>
using namespace std;
int n ; int a[100];
void in() {
    int m = n / 2 , dem = 0;
    for (int i = 0 ; i < m ; i++) {
        if (a[i] == a[n-i-1]) dem++;
    }
    if (dem == m ) {
    for (int i = 0 ; i < n ; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}
}
void flashback(int i ) {
    for (int j = 0 ; j <= 1 ; j++) {
        a[i] = j;
        if (i == n - 1 ) in();
        else flashback(i+1);
    }
}
int main () {
    cin >> n;
    flashback(0);
}
