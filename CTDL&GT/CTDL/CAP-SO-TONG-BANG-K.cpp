#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        long n, x; cin >> n >> x;
        long dem=0; long a[n];
        map<long, long> m;
        for(int i=0;i<n;i++){
            cin >> a[i];
        }
        for(int i=0;i<n;i++){
            if(m.find(x-a[i])!=m.end()){
                dem = dem + m[x-a[i]];
            }
            m[a[i]]++;
        }
        cout << dem << endl;
    }
}
