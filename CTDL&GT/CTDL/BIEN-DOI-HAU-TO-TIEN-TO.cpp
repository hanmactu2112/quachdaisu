#include<bits/stdc++.h>
using namespace std;
bool check(char c){
    if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^') return true;
    return false;
}
void xuly(string s){
    stack<string> st;
    for(int i=0;i<s.size();i++){
        if(check(s[i])){
            string c=st.top(); st.pop();
            string d=st.top(); st.pop();
            string tmp=s[i]+d+c;
            st.push(tmp);
        } else {
            st.push(string(1,s[i]));
        }
    }
    cout << st.top() << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}