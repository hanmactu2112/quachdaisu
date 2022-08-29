#include<bits/stdc++.h>
using namespace std;
int a[20],n,m;
vector<vector<int>> op;
void in(){
    vector<int> op1;
    for(int i=1;i<=m;i++){
        op1.push_back(a[i]);
        //cout << a[i] << " ";
    }
    //cout << endl;
    op.push_back(op1);
}
void Try(int i){
    for(int j=a[i-1]+1;j<=n-m+i;j++){
        a[i]=j;
        if(i==m) in();
        else Try(i+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        op.clear();
        a[0]=0;
        cin>>n>>m;
        Try(1); 
        for(int i=op.size()-1;i>=0;i--){
            for(int j=0;j<op[i].size();j++){
                cout << op[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
}