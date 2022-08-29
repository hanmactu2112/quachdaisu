#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
vector<vector<int>> mst;
int n;
bool check[1005];
int parent[1005];
void DFS(int u){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            parent[j]=u;
            DFS(j);
        }
    }
}
main(){
    int t; cin>>t;
    while (t--){
        mst.clear();
        for(int i=0;i<1005;i++) List[i].clear();
        cin>>n;
        map<int,int> mp1,mp2;
        for(int i=1;i<n;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            mp1[x]++;
            mp2[y]++;
        }
        vector<int> id;
        for(auto x: mp2){
            if(mp1.find(x.first)==mp1.end()){
                id.push_back(x.first);
            }
        }
        memset(check,true,sizeof(check));
        DFS(1);
        sort(id.begin(),id.end());
        for(int i=0;i<id.size();i++){
            vector<int> id1;
            while(id[i]!=1){
                id1.push_back(id[i]);
                id[i]=parent[id[i]];
            }
            id1.push_back(1);
            mst.push_back(id1);
        }
        sort(mst.begin(),mst.end());
        for(int i=0;i<mst.size();i++){
            for(int j=mst[i].size()-1;j>=0;j--){
                cout << mst[i][j] << " ";
            }
            cout << endl;
        }
    }
}