#include<bits/stdc++.h>
using namespace std;
long long MOD = 1e9+7;
int main(){
    int t; cin>>t;
    while(t--){
        long long n; cin >> n;
        long long a[n];
        for(long long i=0;i<n;i++){
            cin>>a[i];
        }
        priority_queue<int, vector<int>, greater<int>> pq(a,a+n);
        long long sum=0;
        while(pq.size()>1){
            long long vl1=pq.top(); pq.pop();
            long long vl2=pq.top(); pq.pop();
            sum=sum+vl1+vl2;
            sum=sum%MOD;
            long long k=(vl1+vl2)%MOD;
            pq.push(k);
        }
        cout << sum << endl;
    }
}