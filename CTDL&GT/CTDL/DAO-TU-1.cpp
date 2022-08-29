#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    cin.ignore();
    while(t--){
        string s; getline(cin,s);
        stack<char> st;
        for(int i=0;i<s.size();i++){
            if(s[i]== ' '){
                while(!st.empty()){
                    cout << st.top();
                    st.pop();
                }
                cout << " ";
            } else st.push(s[i]);
        }
        while(!st.empty()){
            cout << st.top();
            st.pop();
        }
        cout << endl;
    }
}
