#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> op;
int n, s, a[20], b[20];
void cp(int m){
    vector<int> c;
    for(int i=1;i<=m;i++) c.push_back(a[b[i]]);
    op.push_back(c);
}
void Try(int i, int sum){
    for(int j=b[i-1]+1;j<=n;j++){
        if(sum+a[j]<=s){
            sum = sum + a[j];
            b[i]=j;
            if(sum==s) cp(i);
            else Try(i+1,sum);
            sum=sum-a[j];
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        cin>>n>>s;
        for(int i=1;i<=n;i++) cin >> a[i];
        sort(a,a+n+1);
        Try(1,0);
        if(op.size()==0){
            cout << "-1";
        }
        else {
            sort(op.begin(),op.end());
            for(int i=0;i<op.size();i++){
                cout << "[";
                for(int j=0;j<op[i].size()-1;j++){
                    cout << op[i][j] << " ";
                }
                cout << op[i][op[i].size()-1] << "] ";
            }
        }
        cout << endl;
        op.clear();
    }
}
