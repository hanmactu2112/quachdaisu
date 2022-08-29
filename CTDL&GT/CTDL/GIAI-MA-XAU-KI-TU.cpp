#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<char> st;
    for(int i=0;i<s.size();i++){
        if(st.empty() || s[i] == '[' ||  (s[i]>='0'&&s[i]<='9')){
            st.push(s[i]);
        } else if(s[i]==']'){
            string ans="",dem="",ans1="";
            while(!st.empty()&&st.top()!='['){
                char c=st.top();
                st.pop();
                ans=c+ans;
            }
            st.pop();
            if(!st.empty()&&(st.top()>='0' && st.top()<='9')){
                while(!st.empty()&&(st.top()>='0'&&st.top()<='9')){
                    char c=st.top();
                    st.pop();
                    dem=c+dem;
                }
            }
            int n=0;
            for(auto c:dem) n=n*10+(c-'0');
            if(n==0) n++;
            for(int j=0;j<n;j++) ans1=ans1+ans;
            for(auto c:ans1) st.push(c);
        } else {
            st.push(s[i]);
        }
    }
    string ans1="";
    while(!st.empty()){
        ans1=st.top()+ans1;
        st.pop();
    }
    cout << ans1 << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}
