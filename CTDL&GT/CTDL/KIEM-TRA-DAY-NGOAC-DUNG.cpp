#include<bits/stdc++.h>
using namespace std;
int xuly(string s){
    stack<char> st;
    for(int i=0;i<s.size();i++){
        if(s[i]=='(' || s[i]=='{' || s[i]=='['){
            st.push(s[i]);
        }
        else {
            char c=st.top();
            if(!st.empty() && s[i]==')' && c=='(') st.pop();
            else if(!st.empty() && s[i]== ']' && c=='[') st.pop();
            else if(!st.empty() && s[i]=='}' && c=='{') st.pop();
            else return 0;
        }
    }
    return 1;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        if(s.empty()) cout << "YES" << endl;
        if(xuly(s)) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
}
