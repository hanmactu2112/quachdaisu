#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    int dem=0;
    stack<int> st;
    vector<int> a;
    for(int i=0;i<s.size();i++){
        if(s[i]=='('){
            dem++;
            st.push(dem);
            a.push_back(dem);
        } else if(s[i]==')'){
            a.push_back(st.top());
            st.pop();
        } else continue;
    }
    for(int i=0;i<a.size();i++) cout << a[i] << " ";
}
main(){
    int t; cin>>t;
    cin.ignore();
    while(t--){
        string s;
        getline(cin,s);
        xuly(s);
        cout << endl;
    }
}
