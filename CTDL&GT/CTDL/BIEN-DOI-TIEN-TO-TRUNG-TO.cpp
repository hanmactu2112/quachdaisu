#include<bits/stdc++.h>
using namespace std;
bool check(char c){
    if(c=='+'||c=='-'||c=='*'||c=='/') return true;
    return false;
}
void TTTT(string s){
    stack<string> st;
    for(int i=s.size()-1;i>=0;i--){
        if(check(s[i])==true){
            string c = st.top(); st.pop();
            string d = st.top(); st.pop();
            string tmp = "(" + c + s[i] + d + ")" ;
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
        TTTT(s);
    }
}
