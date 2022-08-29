#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<char> st;
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            if(s[i-1]=='+'||s[i-1]=='-') st.push(s[i-1]);
            if(!st.empty()&&s[i-1]=='(') st.push(st.top());
        }
        else if(!st.empty()&&st.top()=='-'){
            if(s[i]=='-') s[i]='+';
            else if(s[i]=='+') s[i]='-';
        }
        if(!st.empty()&&s[i]==')'){
            st.pop();
        }
    }
    for(int i=0;i<s.size();i++){
        if(s[i]=='(' || s[i] == ')') continue;
        else cout << s[i];
    }
    cout << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}
