#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, m; cin >> n >> m;
        int a[100][100], b[100][100];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin >> a[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0) b[i][j]=1;
                else b[i][j]=b[i-1][j]+b[i][j-1];
            }
        }
        cout << b[n-1][m-1] << endl;
    }
}