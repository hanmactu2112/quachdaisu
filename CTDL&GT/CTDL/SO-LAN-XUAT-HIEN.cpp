#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, x; cin >> n >> x;
        int a, kt=1, dem=0;
        for(int i=0;i<n;i++){
            cin >> a;
            if(a==x){
                kt=0;
                dem++;
            }
        }
        if(kt==1) cout << "-1" << endl;
        else cout << dem << endl;
    }
}
