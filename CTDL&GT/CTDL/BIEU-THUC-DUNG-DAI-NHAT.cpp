#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    vector<int> a;
    stack<int> st;
    int dem=0;
    for(int i=0;i<s.size();i++){
        if(s[i]==')'){
            if(!st.empty()){
               a.push_back(st.top());
               st.pop(); 
            } else continue;
        }
        else {
            dem++;
            a.push_back(dem);
            st.push(dem);
        }
    }
    int A[1005]={0},d=0;
    for(int i=0;i<a.size();i++){
        A[a[i]]++;
    }
    for(int i=0;i<a.size();i++){
        if(A[a[i]]>1){
            d++;
        }
    }
    cout << d << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}
