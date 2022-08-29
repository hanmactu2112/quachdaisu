#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        stack<int> a;
        int dem=1;
        for(int i=0;i<s.size();i++){
            if(s[i]=='I'){
                a.push(dem);
                while(!a.empty()){
                    int x=a.top();
                    a.pop();
                    cout << x;
                }
                dem++;
            } else {
                a.push(dem);
                dem++;
            }
        }
        a.push(dem);
        while(!a.empty()){
            int x=a.top(); a.pop();
            cout << x;
        }
        cout << endl;
    }
}