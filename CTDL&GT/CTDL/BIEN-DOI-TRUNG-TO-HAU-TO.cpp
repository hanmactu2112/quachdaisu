#include<bits/stdc++.h>
using namespace std;
int uutien(char c){
    if(c == '+' || c == '-') return 1;
    if(c=='*' || c=='/') return 2;
    if(c=='^') return 3;
    return -1;
}
void TTHT(string s){
    stack<char> st;
    string ans="";
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            st.push(s[i]);
        }
        else if((s[i]>='A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')){
           ans = ans + s[i];
        }
        else if(s[i]==')'){
            while(!st.empty() && st.top()!='('){
                char c=st.top();
                st.pop();
                ans = ans + c; 
            }
            if(st.top()=='('){
                st.pop();
            }
        } else {
            while(!st.empty() && uutien(s[i]) <= uutien(st.top())){
                char c = st.top();
                st.pop();
                ans=ans+c;
            }
            st.push(s[i]);
        }
    }
    if(!st.empty()){
        while(!st.empty()&&st.top()!='('){
            char c = st.top(); st.pop();
            ans=ans+c;
        }
    }
    for(int i=0;i<ans.size();i++) cout << ans[i];
    cout << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        TTHT(s);
    }
}