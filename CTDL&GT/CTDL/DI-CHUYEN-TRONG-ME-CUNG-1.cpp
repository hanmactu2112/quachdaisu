#include<bits/stdc++.h>
using namespace std;
int n, a[15][15];
vector<string> op;
void Try(int i, int j, string s){
    if(i==n&&j==n){
        op.push_back(s);
    }
    else {
        if(a[i+1][j]==1 && i<n){
            Try(i+1,j,s+"D");
        }
        if(a[i][j+1]==1&&j<n){
            Try(i,j+1,s+"R");
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        op.clear();
        cin >> n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cin >> a[i][j];
            }
        }
        if(a[1][1]==0 || a[n][n]==0) cout << "-1" ;
        else {
            Try(1,1,"");
            if(op.size()==0) cout << "-1";
            else {
                for(int i=0;i<op.size();i++){
                cout << op[i] << " ";
            }
            }

        }

        cout << endl;
    }
}