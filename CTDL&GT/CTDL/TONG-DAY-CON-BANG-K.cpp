#include<bits/stdc++.h>
using namespace std;
int n, s, a[100], b[100], c[100];
vector<vector<int>> ix;
void xuat(int m){
    vector<int> d;
    for(int i=1;i<=m;i++) d.push_back(a[b[i]]);
    ix.push_back(d);
}
void Try(int i, int sum){
    for(int j=b[i-1]+1;j<=n;j++){
        if(sum+a[b[i]]<=s){
            b[i]=j;
            sum = sum + a[b[i]];
            if(sum==s) xuat(i);
            else Try(i+1,sum);
            sum=sum-a[b[i]];
        }
    }
}
main(){
    cin >> n >> s;
    for(int i=1;i<=n;i++) cin >> a[i];
    Try(1,0);
    for(int i=ix.size()-1;i>=0;i--){
        for(int j=0;j<ix[i].size();j++){
            cout << ix[i][j] << " ";
        }
        cout << endl;
    }
    cout << ix.size();
}

