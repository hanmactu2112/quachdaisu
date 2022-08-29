#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, m ,p; cin >> n >> m >> p;
        long long a[n], b[m], c[p];
        for(int i=0;i<n;i++) cin >> a[i];
        for(int i=0;i<m;i++) cin >> b[i];
        for(int i=0;i<p;i++) cin >> c[i];
        int i=0, j=0, q=0;
        int kt=1;
        while(i<n && j<m && q<p){
            if(a[i]==b[j] && a[i]==c[q]){
                kt=0;
                cout << a[i] << " ";
                i++;j++;q++;
            }
            else {
                while(a[i] < b[j] || a[i] < c[q]) i++;
                while(b[j] < a[i] || b[j] < c[q]) j++;
                while(c[q] < a[i] || c[q] < b[j]) q++;
            }
        }
        if(kt==1) cout << "-1" ;
        cout << endl;
    }
}
