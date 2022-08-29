#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    deque<int> DQ;
    while(t--){
        string s;
        cin>>s;
        if(s=="PUSHFRONT"){
            int x; cin>>x;
            DQ.push_front(x);
        }
        else if(s=="PUSHBACK"){
            int x; cin>>x;
            DQ.push_back(x);
        }
        else if(s=="POPFRONT"){
            if(!DQ.empty()){
                DQ.pop_front();
            }
        }
        else if(s=="POPBACK"){
            if(!DQ.empty()){
                DQ.pop_back();
            }
        }
        else if(s=="PRINTFRONT"){
            if(!DQ.empty()){
                cout << DQ.front() << endl;
            }
            else cout << "NONE" << endl;
        }
        else if(s=="PRINTBACK"){
            if(!DQ.empty()){
                cout << DQ.back() << endl;
            }
            else cout << "NONE" << endl;
        }
    }
}