#include<bits/stdc++.h>
using namespace std;
main(){
    vector<pair<int,int>> V;
    int t; cin>>t;
    cin.ignore();
    for(int i=1;i<=t;i++){
        string s;
        getline(cin,s);
        for(int j=0;j<s.size();j++){
            if(s[j]>='0'&&s[j]<='9'){
                int n=0;
                while(j<s.size()&&(s[j]>='0'&&s[j]<='9')){
                    n=n*10+(s[j]-'0');
                    j++;
                }
                if(n>i){
                    pair<int,int> p;
                    p.first=i;
                    p.second=n;
                    V.push_back(p);
                }
            }
        }
    }
    for(int i=0;i<V.size();i++){
        cout << V[i].first << " " << V[i].second << endl;
    }
}