#include<bits/stdc++.h>
using namespace std;
string s;
void xuLy(){
    int i=s.size()-1;
    while(i>=0 && s[i]!='1'){
        s[i]='1';
        i--;
    }
    if(i!=-1){
        s[i]='0';
    }
    cout << s;
}
main(){
    int t; cin >> t;
    while(t--){
        cin >> s;
        xuLy();
        cout << endl;
    }
}
