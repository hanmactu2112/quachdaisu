#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        vector<string> S;
        queue<string> Q;
        Q.push("6"); Q.push("8");
        while(1){
            string m=Q.front();
            Q.pop();
            if(m.size()>n){
                break;
            }
            S.push_back(m);
            Q.push(m+"6");
            Q.push(m+"8");
        }
        cout << S.size() << endl;
        for(int i=S.size()-1;i>=0;i--){
            cout << S[i] << " ";
        }
        cout << endl;
    }
}