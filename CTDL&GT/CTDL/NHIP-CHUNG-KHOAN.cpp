#include<bits/stdc++.h>
using namespace std;
void xuly(int a[], int n){
    stack<pair<int,int>> st;
    int R[n],d=0;
    for(int i=0;i<n;i++){
        if(!st.empty()&&a[i]>=st.top().first){
            while(!st.empty()&&a[i]>=st.top().first){
                st.pop();
            }
            if(st.empty()){
                R[d++]=i+1;
            } else {
                R[d++]=i-st.top().second;
            }
        }
        else{
            R[d++]=1;
        }
        st.push(make_pair(a[i],i));
    }
    for(int i=0;i<d;i++){
        cout << R[i] << " ";
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
