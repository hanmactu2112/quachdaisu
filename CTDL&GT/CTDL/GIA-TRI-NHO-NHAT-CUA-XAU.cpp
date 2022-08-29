#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        long long n; cin >>n;
        string s; cin>>s;
        long long a[26]={0};
        for(int i=0;i<s.size();i++){
            a[s[i]-'A']++;
        }
        priority_queue<long long, vector<long long>> pq(a,a+26);
        while(n--){
            long long x=pq.top();
            pq.pop();
            x--;
            pq.push(x);
        }
        long long ans=0;
        while(!pq.empty()){
            long long x=pq.top();
            pq.pop();
            ans=ans+x*x;
        }
        cout << ans << endl;
    }
}