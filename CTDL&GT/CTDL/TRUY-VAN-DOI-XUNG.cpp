#include<bits/stdc++.h>
using namespace std;
int kiem_tra(string s){
    int l=0,r=s.size()-1;
    while(l<r){
        if(s[l]!=s[r]) return 0;
        l++;
        r--;
    }
    return 1;
}
main(){
    string s; cin>>s;
    int n; cin>>n;
    while(n--){
        char c; cin>>c;
        if(c=='c'){
            int x,y; cin>>x>>y;
            s[x-1]=(char)(y+'0');
        }
        else {
            int x,y; cin>>x>>y;
            string s2=s.substr(x-1,y-x+1);
            if(kiem_tra(s2)) cout << "YES" << endl;
            else cout << "NO" << endl;
        }
    }
}