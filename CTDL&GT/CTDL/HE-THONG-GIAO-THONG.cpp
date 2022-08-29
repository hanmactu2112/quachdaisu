#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    stack<char> st;
    int ans=0;
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            st.push(s[i]);
        }
        else if(s[i]==')'){
            if(st.empty()){
                cout << "-1" << endl;
                return;
            }
            else if(!st.empty()){
                if(ans<st.size()){
                    ans=st.size();
                }
                st.pop();
            }
        }
    }
    if(!st.empty()){
        cout << "-1" << endl;
        return;
    }
    cout << ans << endl;
}
int main(){
    int t; cin>>t;
    cin.ignore();
    while(t--){
        string s;
        getline(cin,s);
        xuly(s);
    }
}