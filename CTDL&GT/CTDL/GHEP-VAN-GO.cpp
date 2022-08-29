#include<bits/stdc++.h>
using namespace std;
void Ph(long long a[], long long n, long long P[]){
    stack<long long> st;
    for(long long i=n;i>=1;i--){
        while(!st.empty()&&a[i]<=a[st.top()]){
            st.pop();
        }
        if(st.empty()){
            P[i]=n+1;
        } else {
            P[i]= st.top();
        }
        st.push(i);
    }
}
void Tr(long long a[], long long n, long long T[]){
    stack<long long> st;
    for(long long i=1;i<=n;i++){
        while(!st.empty()&&a[i]<=a[st.top()]){
            st.pop();
        }
        if(st.empty()){
            T[i]=0;
        }
        else T[i]=st.top();
        st.push(i);
    }
}
void xuly(long long a[], long long n){
    long long P[n+5],T[n+5];
    Ph(a,n,P);
    Tr(a,n,T);
    long long kq=0;
    for(long long i=1;i<=n;i++){
        if(P[i]-T[i]-1>=a[i]){
            kq=max(kq,a[i]);
        }
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
