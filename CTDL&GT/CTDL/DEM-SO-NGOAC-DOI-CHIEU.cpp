#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<char> st;
    int dem=0;
    for(int i=0;i<s.size();i++){
        if(st.empty() || s[i]=='('){
            st.push(s[i]);
        }
        else if(s[i]==')'){
            if(st.top()==')'){
                dem++;
                st.pop();
            } else if(st.top()=='('){
                st.pop();
            }
        }
    }
    if(!st.empty()){
        while(!st.empty()){
            char c = st.top(); st.pop();
            char d = st.top(); st.pop();
            if(c=='(' && d == ')' ) dem=dem+2;
            else dem=dem+1;
        }
    }
    cout << dem << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}