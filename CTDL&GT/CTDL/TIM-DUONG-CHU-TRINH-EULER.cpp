#include<bits/stdc++.h>
using namespace std;
#define MAX 1000+5
int a[MAX][MAX];
bool vs[MAX];
int n,m;
vector<int> op;

void chuTrinh(int u){
    stack<int> st;
    st.push(u);
    while(!st.empty()){
        int x=st.top();
        st.pop();
        int ok=1;
        for(int i=1;i<=n;i++){
            if(a[x][i]==1){
                ok=0;
                a[x][i]=0;
                //a[i][x]=0;
                st.push(x);
                st.push(i);
                break;
            }
            if(ok==0) break; 
        }
        if(ok==1){
            //st.pop();
            op.push_back(x);
        }
    }
    for(int i=op.size()-1;i>=0;i--){
        cout << op[i] << " ";
    }
}
main(){
    memset(a,0,sizeof(a));
    cin>>n>>m;
    int u,v; 
    for(int i=1;i<=m;i++){
        cin>>u>>v;
        a[u][v]=1;
        //a[v][u]=1;
    }
    chuTrinh(2);
}