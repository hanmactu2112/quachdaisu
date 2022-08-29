#include<bits/stdc++.h>
using namespace std;
void kiem_tra(string s){
    int kt=1;
    stack<char> st;
    for(int i=0;i<s.size();i++){
        if(s[i]=='['||s[i]=='('){
            st.push(s[i]);
        }
        else if(s[i]==')'||s[i]==']'){
            if(!st.empty()){
                char c=st.top();
                if(c=='['&&s[i]==']') st.pop();
                else if(c=='(' && s[i]==')') st.pop();
                else{
                    kt=0;
                    break;
                }
            }
            else {
                kt=0;
                break;
            }
        }
    }
    if(kt==0) cout << "NO" << endl;
    else if(!st.empty()) cout << "NO" << endl;
    else cout << "YES" << endl;
}
main(){
    int t; cin>>t; string s;
    cin.ignore();
    while(t--){
        getline(cin,s);
        kiem_tra(s);
    }
}