#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        vector<vector<int>> a;
        int n; cin >> n;
        int b[n];
        for(int i=0;i<n;i++) cin >> b[i];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(b[i]>b[j]){
                    swap(b[i],b[j]);
                }
            }
            vector<int> c;
            for(int i1=0;i1<n;i1++){
                c.push_back(b[i1]);
            }
            a.push_back(c);
        }
        for(int i=a.size()-1;i>=0;i--){
            cout << "Buoc " << i+1 << ": ";
            for(int i1=0;i1<a[i].size();i1++){
                cout << a[i][i1] << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
}
