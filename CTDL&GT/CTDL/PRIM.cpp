#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> List[10005];
int n,m;
long long sum;
bool check[10005];
void cay_khung(int u){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> Q;
    Q.push({0,u});
    while(!Q.empty()){
        pair<int,int> p=Q.top(); Q.pop();
        int h=p.second,v=p.first;
        if(check[h]==false) continue;
        check[h]=false;
        sum=sum+v;
        for(int i=0;i<List[h].size();i++){
            int j=List[h][i].first,k=List[h][i].second;
            if(check[j]==true){
                Q.push({k,j});
            }
        }
    }
    cout << sum << endl;
}
main(){
    memset(check,true,sizeof(check));
    sum=0;
    cin>>n>>m;
    for(int i=0;i<m;i++){
        int x,y,z; cin>>x>>y>>z;
        List[x].push_back({y,z});
        List[y].push_back({x,z});
    }
    cay_khung(1);
}