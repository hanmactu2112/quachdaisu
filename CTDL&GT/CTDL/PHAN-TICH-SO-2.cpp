#include<bits/stdc++.h>
using namespace std;
int a[20], n;
vector<vector<int>> op;
void in(int m){
    vector<int> op1;
    for(int i=1;i<=m;i++){
        op1.push_back(a[i]);
    }
    op.push_back(op1);
}
void Try(int i, int j, int sum){
    int k;
    for(k=j;k>=1;k--){
        if(sum+k<=n&&k<=a[i-1]){
            sum=sum+k;
            a[i]=k;
            if(sum==n) in(i);
            else Try(i+1,j,sum);
            sum=sum-k;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        op.clear();
        a[0]=1e6;
        cin>>n;
        Try(1,n,0);
        cout << op.size() << endl;
        for(int i=0;i<op.size();i++){
            cout << "(";
            int m=op[i].size();
            for(int j=0;j<m-1;j++){
                cout << op[i][j] << " ";
            }
            cout << op[i][m-1] << ")";
            cout << " ";
        }
        cout << endl;
    }
}

