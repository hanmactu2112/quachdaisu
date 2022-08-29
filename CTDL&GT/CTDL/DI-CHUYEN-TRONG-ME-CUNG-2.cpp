#include<bits/stdc++.h>
using namespace std;
int a[20][20], n;
bool check[20][20];
vector<string> op;
void Try(int i, int j, string s){
    if(i==n&&j==n){
        op.push_back(s);
        return;
    }
    else {
        check[i][j]=true;
        if(a[i+1][j]==1&& check[i+1][j]==false && i<n){
            Try(i+1,j,s+"D");
        }
        if(a[i][j+1]==1&& check[i][j+1]==false && j<n){
            Try(i,j+1,s+"R");
        }
        if(a[i-1][j]==1&& check[i-1][j]==false && i>1){
            Try(i-1,j,s+"U");
        }
        if(a[i][j-1]==1&& check[i][j-1]==false && j>1){
            Try(i,j-1,s+"L");
        }
        check[i][j]=false;
    }
}
main(){
    int t; cin>>t;
    while(t--){
        op.clear();
        cin>>n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cin>>a[i][j];
            }
        }
        if(a[1][1]!=1 || a[n][n]!= 1){
            cout << "-1";
        }
        else {
            memset(check,false,sizeof(check));
            Try(1,1,"");
            if(op.size()==0) cout << "-1";
            else {
                cout << op.size() << " ";
                sort(op.begin(),op.end());
                for(int i=0;i<op.size();i++) cout << op[i] << " ";
            }
        }
        cout << endl;
    }
}