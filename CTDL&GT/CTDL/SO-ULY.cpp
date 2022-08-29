#include<bits/stdc++.h>
using namespace std;
main(){
    vector<long long> F;
    set<long long> S;
    S.insert(1);
    while(1){
        for(auto i:S){
            if(i>1e18){
                break;
            }
            F.push_back(i*2);
            F.push_back(i*3);
            F.push_back(i*5);
        }
        for(auto i:F){
            S.insert(i);
        }
        F.clear();
        if(S.size()>1e4) break;
    }
    for(auto i:S){
        F.push_back(i);
    }
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        cout << F[n-1] << endl;
    }
}