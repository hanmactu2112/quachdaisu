#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        long long n,i; cin>>n;
        long long a[n+5],R[n+5];
        for(i=0;i<n;i++) cin>>a[i];
        stack<long long> st;
        for(i=n-1;i>=0;i--){
            while(!st.empty() && st.top()<=a[i]) st.pop();
            if(st.empty()) R[i]=-1;
            else R[i]=st.top();
            st.push(a[i]);
        }
        for(int i=0;i<n;i++){
            cout << R[i] << " ";
        } 
        cout << endl;
    }
}