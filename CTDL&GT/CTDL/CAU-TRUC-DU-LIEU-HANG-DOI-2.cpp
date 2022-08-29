#include<bits/stdc++.h>
using namespace std;
main(){
    int n; cin>>n;
    queue<int> Q;
    while(n--){
        string s; cin>>s;
        if(s=="PUSH"){
            int x; cin>>x;
            Q.push(x);
        }
        else if(s=="POP"){
            if(!Q.empty()){
                Q.pop();
            }
        }
        else if(s=="PRINTFRONT"){
            if(!Q.empty()){
                cout << Q.front() << endl;
            }
            else cout << "NONE" << endl;
        }
    }
}