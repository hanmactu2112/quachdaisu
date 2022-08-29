#include<bits/stdc++.h>
using namespace std;
int n, k;
vector<vector<int>> op;
int check[100],a[20][20],b[50],sum;
void in(){
    sum=0;
    for(int i=1;i<=n;i++){
        sum = sum + a[i][b[i]];
    }
    if(sum==k){
        vector<int> op1;
        for(int i=1;i<=n;i++){
            op1.push_back(b[i]);
        }
        op.push_back(op1);
    }
}
void Try(int i){
    for(int j=1;j<=n;j++){
        if(check[j]==0){
            check[j]=1;
            b[i]=j;
            if(i==n) in();
            else Try(i+1);
            check[j]=0;
        }
    }
}
main(){
    cin >> n >> k;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>a[i][j];
        }
    }
    memset(check,0,sizeof(check));
    sum=0;
    Try(1);
    cout << op.size() << endl;
    for(int i=0;i<op.size();i++){
        for(int j=0;j<op[i].size();j++){
            cout << op[i][j] << " ";
        }
        cout << endl;
    }
}
