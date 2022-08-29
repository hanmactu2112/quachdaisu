#include<bits/stdc++.h>
using namespace std;
int chuyen(char c){
    return c-'0';
}
int check(char c){
    if(c=='+') return 1;
    if(c=='-') return 2;
    if(c=='*') return 3;
    if(c=='/') return 4;
    return -1;
}
void xuly(string s){
    stack<int> st;
    for(int i=s.size()-1;i>=0;i--){
        if(check(s[i])==1){
            int c= st.top(); st.pop();
            int d= st.top(); st.pop();
            int ans=c+d;
            st.push(ans);
        } else if(check(s[i])==2){
            int c= st.top(); st.pop();
            int d= st.top(); st.pop();
            int ans=c-d;
            st.push(ans);
        } else if(check(s[i])==3){
            int c= st.top(); st.pop();
            int d= st.top(); st.pop();
            int ans=(c*d);
            st.push(ans);
        }  else if(check(s[i])==4){
            int c= st.top(); st.pop();
            int d= st.top(); st.pop();
            int ans=(c/d);
            st.push(ans);
        } else st.push(chuyen(s[i]));
    }
    cout << st.top() << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}