#include<bits/stdc++.h>
using namespace std;
int uutien(char c){
    if(c=='-'||c=='+') return 1;
    else if(c=='*' || c=='/') return 2;
    else if(c=='^') return 3;
    return -1;
}
string doi(string s){
    stack<char> st;
    string ans="";
    string ans1="";
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            st.push(s[i]);
        }
        else if(s[i]>='0'&&s[i]<='9'){
            while(i<s.size()&&(s[i]>='0'&&s[i]<='9')){
                ans1=ans1+s[i];
                i++;
            }
            if(i<s.size()) i--;
            ans = ans+"("+ans1+")";
            ans1="";
        }
        else if(s[i]==')'){
            while(!st.empty() && st.top()!='('){
                ans=ans+st.top();
                st.pop();
            }
            if(st.top()=='(') st.pop();
        } else {
            while(!st.empty() && (uutien(s[i]) <= uutien(st.top()))){
                char c = st.top();
                st.pop();
                ans=ans+c;
            }
            st.push(s[i]);
        }
    }
    while(!st.empty()){
        ans=ans+st.top();
        st.pop();
    }
    return ans;
} // D/E-F=>DE/F-
// (53)+
long long tinh(string a){
    stack<long long> st;
    for(int i=0;i<a.size();i++){
        if(a[i]=='('){
            long long n=0;
            i++;
            while(a[i]!=')'){
                n=n*10+(a[i]-'0');
                i++;
            }
            st.push(n);
        }
        else if(a[i]=='+'){
            long long so1=st.top(); st.pop();
            long long so2=st.top(); st.pop();
            long long m=so1+so2;
            st.push(m);
        }
        else if(a[i]=='-'){
            long long so1=st.top(); st.pop();
            long long so2=st.top(); st.pop();
            long long m=so2-so1;
            st.push(m);
        }
        else if(a[i]=='*'){
            long long so1=st.top(); st.pop();
            long long so2=st.top(); st.pop();
            long long m=so1*so2;
            st.push(m);
        }
        else if(a[i]=='/'){
            long long so1=st.top(); st.pop();
            long long so2=st.top(); st.pop();
            long long m=so2/so1;
            st.push(m);
        }
    }
    return st.top();
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        cout << tinh(doi(s)) << endl;
    }
}
