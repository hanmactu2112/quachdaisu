#include<bits/stdc++.h>
using namespace std;
vector<string> op;
long long n;
void xuly(){
    for(long long i=2;i*i*i<=n;i++){
        long long t=i*i*i;
        op.push_back(to_string(t));
    }
}
void tinh(string s){
    int kt=1;
    for(int i=op.size()-1;i>=0;i--){
        int dem=0;
        for(int j=0;j<s.size();j++){
            if(op[i][dem]==s[j]){
                dem++;
            }
        }
        if(dem == op[i].size()){
            cout << op[i];
            kt=0;
            break;
        }
    }
    if(kt==1) cout << "-1" ;
}
main(){
    int t; cin >> t;
    while(t--){
        op.clear();
        cin>>n;
        xuly();
        string s=to_string(n);
        tinh(s);
        cout << endl;
    }
}