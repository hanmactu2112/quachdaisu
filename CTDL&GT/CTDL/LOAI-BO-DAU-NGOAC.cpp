#include<bits/stdc++.h>
using namespace std;
string xoa_cach(string s){
    string s1="";
    for(int i=0;i<s.size();i++){
        if(s[i]!=' '){
            s1=s1+s[i];
        }
    }
    return s1;
}
string xoa_ngoac(string s){
    string s1="";
    stack<char> st;
    stack<int> st1;
    int check[300]={0};
    for(int i=0;i<s.size();i++){
        if(s[i]==')'){
            int kt=1;
            while(st.top() != '('){
                char top=st.top();
                st.pop();
                st1.pop();
                if(top=='+'|| top=='-'){
                    kt=0;
                }
            }
            if(kt==1){
                check[i]=1;
                check[st1.top()]=1;
            }
            st.pop();
            st1.pop();
        }
        else {
            st.push(s[i]);
            st1.push(i);
        }
    }
    for(int i=0;i<s.size();i++){
        if(check[i]==0){
            s1=s1+s[i];
        }
    }
    return s1;
}
string xoa_dau(string s){
    string s1="";
    stack<char> st;
    stack<int> st1;
    int check[300]={0};
    for(int i=s.size()-1;i>=0;i--){
        if(s[i]=='('){
            int kt=0;
            if(i==0 || s[i-1]!='-'){
                kt=1;
            }
            while(st.top()!= ')'){
                st.pop();
                st1.pop();
            }
            if(kt==1){
                check[i]=1;
                check[st1.top()]=1;
            }
            st.pop();
            st1.pop();
        }
        else {
            st.push(s[i]);
            st1.push(i);
        }
    }
    for(int i=0;i<s.size();i++){
        if(check[i]==0){
            s1=s1+s[i];
        }
    }
    return s1;
}
main(){
    int t; cin >> t;
    cin.ignore(1);
    while(t--) {  
        string s; getline(cin,s);
        s=xoa_cach(s);
        s=xoa_ngoac(s);
        s=xoa_dau(s);
        cout << s << endl;
    }
}