#include<bits/stdc++.h>
using namespace std;
int n, x, a[25], b[25];
int ok;
vector<vector<int>> op;
void in(int m){
    vector<int> op1;
    for(int i=1;i<=m;i++){
        op1.push_back(b[i]);
    }
    op.push_back(op1);
}
void Try(int i, int j, int sum){
    for(int k=j;k<=n;k++){
        if(sum+a[k]<=x && a[k]>=a[b[i-1]]){
            b[i]=k;
            sum=sum+a[k];
            if(sum==x) in(i);
            else Try(i+1,j,sum);
            sum=sum-a[k];
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        op.clear();
        cin>>n>>x;
        for(int i=1;i<=n;i++) cin>>a[i];
        sort(a,a+n+1);
        Try(1,1,0);
        if(op.size()==0) cout << "-1";
        else {
            cout << op.size() << " ";
            for(int i=0;i<op.size();i++){
                cout << "{";
                for(int j=0;j<op[i].size()-1;j++){
                    cout << a[op[i][j]] << " ";
                }
                int k=op[i].size()-1;
                cout << a[op[i][k]] << "} ";
            }
        }
        cout << endl;
    }
}