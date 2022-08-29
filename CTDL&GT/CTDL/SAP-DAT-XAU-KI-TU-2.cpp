#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int a[26]={0};
        string s; int x;
        cin>>x>>s;
        for(int i=0;i<s.size();i++){
            a[s[i]-'A']++;
        }
        sort(a,a+26);
        if(a[25]*x>s.size()+1) cout << "-1" << endl;
        else cout << "1" << endl;
    }
}