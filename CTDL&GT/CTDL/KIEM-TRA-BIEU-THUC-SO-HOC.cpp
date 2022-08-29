#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<int> st;
    int kt=1;
    for(int i=0;i<s.size();i++){
        if(s[i]=='(') st.push(i);
        else if(s[i]==')'){
            int j=st.top(); st.pop();
            if(i-j==2){
                kt=0;
                break;
            } 
            if(s[i-1]==')' && s[j+1]=='('){
                kt=0;
                break;
            }
        }
    }
    if(kt==0) cout << "Yes" << endl;
    else cout << "No" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}