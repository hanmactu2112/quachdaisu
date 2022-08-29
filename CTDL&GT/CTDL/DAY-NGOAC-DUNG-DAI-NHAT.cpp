#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<int> st;
    st.push(-1);
    int kq=0;
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            st.push(i);
        }
        else if(s[i]==')'){
            st.pop();
            if(!st.empty()){
                kq=max(kq,i-st.top());
            }
            else st.push(i);
        }
    }
    cout << kq << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}