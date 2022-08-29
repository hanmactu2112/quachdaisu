#include<bits/stdc++.h>
using namespace std;
string xuly(string a){
    stack<char> st;
    for(int i=0;i<a.size();i++){
        if(a[i]=='('){
            if(a[i-1]=='+'||a[i-1]=='-'){
                st.push(a[i-1]);
            }
            if(a[i-1]=='(' && !st.empty()){
                st.push(st.top());
            }
        }
        else if(!st.empty() && st.top()=='-'){
            if(a[i]=='-') a[i]='+';
            else if(a[i]=='+') a[i]='-';
        }
        if(a[i]==')'&& !st.empty()){
            st.pop();
        }
    }
    string ans1="";
    for(int i=0;i<a.size();i++){
        if(a[i]=='('||a[i]==')') continue;
        else ans1=ans1+a[i];
    }
    return ans1;
}
void tinh(string a, string b){
    string ans=xuly(a);
    string ans1=xuly(b);
    if(ans==ans1) cout << "YES" << endl;
    else cout << "NO" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string a, b;
        cin>>a>>b;
        tinh(a,b);
    }
}