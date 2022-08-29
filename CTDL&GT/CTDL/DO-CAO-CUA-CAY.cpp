#include<bits/stdc++.h>
using namespace std;
vector<int> List[100005];
bool check[100005];
vector<int> a;
void DFS(int u, int docao){
    check[u]=false;
    a.push_back(docao);
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            DFS(j,docao+1);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        for(int i=0;i<100005;i++) List[i].clear();
        memset(check,true,sizeof(check));
        int n; cin>>n;
        for(int i=1;i<n;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
        }
        DFS(1,0);
        sort(a.begin(),a.end());
        cout << a[a.size()-1] << endl;
    }
}