#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        int n,m; cin>>n>>m;
        for(int i=0;i<m;i++){
            int u,v; cin>>u>>v;
            List[u].push_back(v);
            List[v].push_back(u);
        }
        for(int i=1;i<=n;i++){
            cout << i << ": ";
            for(int j=0;j<List[i].size();j++){
                cout << List[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
}