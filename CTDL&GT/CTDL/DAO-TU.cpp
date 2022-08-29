#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    cin.ignore();
    while(t--){
        string s;
        getline(cin,s);
        stack<char> st;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]==' '){
                while(!st.empty()){
                    cout << st.top(); st.pop();
                }
                cout << " ";
            } else {
                st.push(s[i]);
            }
        }
        while(!st.empty()){
            cout << st.top(); st.pop();
        }
        cout << endl;
    }
}
