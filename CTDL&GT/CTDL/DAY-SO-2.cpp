#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        int a[n]; int k=n-1;
        for(int i=0;i<n;i++) cin >> a[i];
        vector<vector<int>> c;
        vector<int> b;
        for(int i=0;i<n;i++){
            b.push_back(a[i]);
        }
        c.push_back(b);
        while(k>0){
            vector<int> d;
            for(int i=0;i<k;i++){
                a[i]=a[i]+a[i+1];
                d.push_back(a[i]);
            }
            k--;
            c.push_back(d);
        }
        for(int i=c.size()-1;i>=0;i--){
            cout  << "[";
            for(int j=0;j<c[i].size()-1;j++){
                cout << c[i][j] << " ";
            }
            cout << c[i][c[i].size()-1] << "]";
            cout << " ";
        }
        cout << endl;
    }
}
