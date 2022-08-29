#include<bits/stdc++.h>
using namespace std;
bool kt(char c){
    if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^') return true;
    return false;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        stack<string> st;
        for(int i=0;i<s.size();i++){
            if(kt(s[i])==false){
                st.push(string(1,s[i]));
            }
            else {
                string a=st.top();
                st.pop();
                string b=st.top(); st.pop();
                string ix=b+s[i]+a;
                st.push(ix);
            }
        }
        cout << st.top() << endl;
    }
}