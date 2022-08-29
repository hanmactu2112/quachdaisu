#include<bits/stdc++.h>
using namespace std;
void Ph(long long a[], long long n, long long P[]){
    stack<long long> st;
    for(int i=n;i>=1;i--){
        if(!st.empty()){
            while(!st.empty() && a[i] <= a[st.top()]){
                st.pop();
            }
        }
        if(st.empty()){
            P[i]=n+1;
        } else P[i]=st.top();
        st.push(i);
    }
}
void Tr(long long a[], long long n, long long T[]){
    stack<long long> st;
    for(long long i=1;i<=n;i++){
        if(!st.empty()){
            while(!st.empty() && a[i] <= a[st.top()]){
                st.pop();
            }
        }
        if(st.empty()){
            T[i]=0;
        } else T[i]=st.top();
        st.push(i);
    }
}
void xuly(long long a[],long long b[], long long n, long long m){
    long long P[m+5],T[m+5],P1[m+5],T1[m+5];
    Ph(a,m,P);
    Tr(a,m,T);
    Ph(b,m,P1);
    Tr(b,m,T1);
    long long kq=0,kq1=0,kq2=0;
    for(long long i=1;i<=m;i++){
        kq1 = max(kq1,(P[i]-T[i]-1)*a[i]);
        kq2 = max(kq2,(P1[i]-T1[i]-1)*b[i]);
    }
    kq=max(kq1,kq2);
    cout << kq << endl;
}
main(){
    long long n,m; cin>>n>>m;
    long long a[m+5],b[m+5];
    for(int i=1;i<=m;i++){
        cin>>a[i];
        b[i]=n-a[i];
    }
    xuly(a,b,n,m);
}
