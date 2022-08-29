#include<bits/stdc++.h>
using namespace std;
void kiem_tra(string s){
    int ans=0,res=0;
    stack<pair<char,int>> st;
    st.push({'.',0});
    for(int i=0;i<s.size();i++){
        if(!st.empty()&& (s[i]==')'&&st.top().first=='(') || (s[i]==']'&&st.top().first=='[')){
           st.pop();
            if(!st.empty()){
                ans=max(ans,res-st.top().second);
            }
        }
        else {
            if(s[i]=='[') res++;
            st.push({s[i],res});
        }
    }
    cout << ans << endl;
}
main(){
    string s;
    cin>>s;
    kiem_tra(s);
}