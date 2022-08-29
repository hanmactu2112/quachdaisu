#include<bits/stdc++.h>
using namespace std;
void xuly(int a[], int n){
    int A[1000000+5]={0},B[n];
    for(int i=0;i<n;i++) A[a[i]]++;
    for(int i=0;i<n;i++) B[i]=A[a[i]];
    stack<int> st;
    int R[n];
    for(int i=n-1;i>=0;i--){
        while(!st.empty()&&B[i]>=B[st.top()]){
            st.pop();
        }
        if(st.empty()){
            R[i]=-1;
        }
        else R[i]=st.top();
        st.push(i);
    }
    for(int i=0;i<n;i++){
        if(R[i]!=-1){
            cout << a[R[i]] << " ";
        } else {
            cout << "-1"  << " ";
        }
    }
    cout << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n];
        for(int i=0;i<n;i++) cin>>a[i];
        xuly(a,n);
    }
}
