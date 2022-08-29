#include<bits/stdc++.h>
using namespace std;
void NextGreater(int a[], int n, int R[]){
    stack<int> st;
    for(int i=n-1;i>=0;i--){
        while(!st.empty()&&a[i]>=a[st.top()]){
            st.pop();
        }
        if(st.empty()) R[i]=-1;
        else R[i]=st.top();
        st.push(i);
    }
}
void RightSmaller(int a[], int n, int S[]){
    stack<int> st;
    for(int i=n-1;i>=0;i--){
        while(!st.empty()&&a[i]<=a[st.top()]){
            st.pop();
        }
        if(st.empty()) S[i]=-1;
        else S[i]=st.top();
        st.push(i);
    }
}
void xuly(int a[], int n){
    int R[100000+5],S[100000+5];
    NextGreater(a,n,R);
    RightSmaller(a,n,S);
    for(int i=0;i<n;i++){
        if(R[i]!=-1&&S[R[i]]!=-1){
            cout << a[S[R[i]]] << " ";
        }
        else cout << "-1" << " ";
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n];
        for(int i=0;i<n;i++) cin>>a[i];
        xuly(a,n);
        cout << endl;
    }
}
