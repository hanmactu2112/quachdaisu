#include<bits/stdc++.h>
using namespace std;
void P(long long a[], long long n, long long R[]){
    stack<long long> st;
    for(long long i=n;i>=1;i--){
        while(!st.empty()&&a[i]<=a[st.top()]) st.pop();
        if(st.empty()) R[i]=n+1;
        else R[i]=st.top();
        st.push(i);
    }
}
void T(long long a[], long long n, long long S[]){
    stack<long long> st;
    for(long long i=1;i<=n;i++){
        while(!st.empty()&&a[i]<=a[st.top()]) st.pop();
        if(st.empty()) S[i]=0;
        else S[i]=st.top();
        st.push(i);
    }
}
void xuly(long long a[], long long n){
   long long R[n+5], S[n+5];
   P(a,n,R);
   T(a,n,S);
   for(int i=1;i<=n;i++) cout<<R[i]<<" ";
   cout<<endl;
   for(int i=1;i<=n;i++) cout<<S[i]<<" ";
   cout<<endl;
   long long kq=0;
   for(long long i=1;i<=n;i++){
        kq=max(kq,a[i]*(R[i]-S[i]-1));
   }
   cout << kq << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        long long n; cin>>n;
        long long a[n+5];
        for(long long i=1;i<=n;i++) cin>>a[i];
        xuly(a,n);
    }
}
