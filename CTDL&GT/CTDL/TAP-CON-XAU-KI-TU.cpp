#include<bits/stdc++.h>
using namespace std;
#define ms(s,n) memset(s,n,sizeof(s))
string s; int n,k;
int a[100], c[100];
vector<vector<int>> op;
void in(int m){
    vector<int> op1;
    for(int i=1;i<=m;i++){
        op1.push_back(a[i]);
    }
    op.push_back(op1);
} 
void Try(int i){
    for(int j=a[i-1]+1;j<=n;j++){
        a[i]=j;
        if(i>=1) in(i);
        Try(i+1);
    }
}
main(){
    int t; cin>>t;
    while (t--){
        cin>>n;
        cin>>s;
        s="0"+s;
        op.clear();
        Try(1);
        for(int i=0;i<op.size();i++){
            for(int j=0;j<op[i].size();j++){
                cout << s[op[i][j]];
            }
            cout << " ";
        }
        cout << endl;
        op.clear();
    }
}