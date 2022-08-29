#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> List[1000005];
int n,m;
int D[1000005];
long long F[1000005];
void DJ(){
    priority_queue<pair<int,int> , vector<pair<int,int>>,greater<pair<int,int>>> Q;
    Q.push({0,1});
    for(int i=0;i<1000005;i++){
        D[i]=1e9;
        F[i]=0;
    }
    D[1]=0;
    F[1]=0;
    while(!Q.empty()){
        int x = Q.top().second;
        int y = Q.top().first;
        Q.pop();
        for(int i=0;i<List[x].size();i++){
            int j = List[x][i].first;
            int d_x_j = List[x][i].second;
            if(D[j]>D[x]+d_x_j){
                D[j] = D[x]+d_x_j;
                Q.push({D[j],j});
                F[j] = F[x] + 1;
            } 
        }
    }
   
    cout << D[n] << " " << F[n];
}
main(){
    cin>>n>>m;
    for(int i=1;i<=m;i++){
        int x,y,z; cin>>x>>y>>z;
        List[x].push_back({y,z});
        List[y].push_back({x,z});
    }
    DJ();
}
