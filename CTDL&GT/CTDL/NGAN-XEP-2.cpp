#include<bits/stdc++.h>
using namespace std;
main(){
    stack<int> st;
    int t; cin>>t;
    string s; int n;
    while(t--){
        cin>>s;
        if(s=="PUSH"){
            cin>>n;
            st.push(n);
        }
        else if(s=="POP"){
            st.pop();
        }
        else if(s=="PRINT"){
            if(!st.empty()){
                cout << st.top() << endl;
            } else {
                cout << "NONE" << endl;
            }
        }
    }
}