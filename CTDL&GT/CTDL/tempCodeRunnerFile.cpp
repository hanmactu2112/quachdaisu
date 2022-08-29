#include<bits/stdc++.h>
using namespace std;
main(){
    int n; cin>>n;
    string s; cin>>s;
    int k=n-11,dem=0;
    vector<int> V;
    for(int i=0;i<s.size();i++){
        if(s[i]=='8'){
            dem++;
            V.push_back(i);
        }
    }
    if(dem<=(k/2)){
        cout << "NO" << endl;
    }
    else {
        for(int i=0;i<k;i++){
            s[V[i]]='.';
        }
        int d=0,id=-1,d2;
        for(int i=0;i<s.size();i++){
            if(d==k){
                id=i;
                break;
            }
            else {
                if(s[i]!='8'&&s[i]!='.'){
                    d++;
                    s[i]='.';
                }
            }
        }
        for(int i=id;i<s.size();i++){
            if(s[i]!='.'){
                d2=i;
                break;
            }
        }
        if(s[d2]=='8') cout << "YES" << endl;
        else cout << "NO" << endl; 
    }
}