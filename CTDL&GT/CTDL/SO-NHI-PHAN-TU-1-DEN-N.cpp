#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n,dem=0; cin>>n;
        queue<string> Q;
        Q.push("1");
        while(1){
            if(dem==n){
                break;
            }
            string m=Q.front();
            Q.pop();
            cout << m << " ";
            dem++;
            if(dem==n) break;
            Q.push(m+"0");
            Q.push(m+"1");
        }
        cout << endl;
    }
}