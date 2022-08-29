#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n];
        for(int i=0;i<n;i++) cin>>a[i];
        priority_queue<int, vector<int>, greater<int>> pq(a,a+n);
        long long kq=0;
        while(pq.size()>1){
            int min1=pq.top(); pq.pop();
            int min2=pq.top(); pq.pop();
            int sum=min1+min2;
            kq=kq+sum;
            pq.push(sum);
        }
        cout << kq << endl;
    }
}
