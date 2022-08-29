#include<bits/stdc++.h>
using namespace std;
main(){
    int n, s = 0;
    cin >> n;
    int a[n+5], f[10000+5]={0};
    for (int i = 1; i <= n; i++)
        cin >> a[i];
    for (int i = 1; i <= n; i++)
    {
        f[a[i]] = f[a[i] - 1] + 1;
        s = max(s, f[a[i]]);
    }
    cout << n - s << endl;
}