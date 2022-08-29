#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    int b[n];
    for(int i=0;i<n;i++) cin >> b[i];
    vector<vector<int>> a;
    for(int i=0;i<n;i++){
        int k = b[i];
        int j=i-1;
        while(j>=0 && k < b[j]){
            b[j+1]=b[j];
            j--;
        }
        b[j+1]=k;
        vector<int> c;
        for(int i1=0;i1<=i;i1++){
            c.push_back(b[i1]);
        }
        a.push_back(c);
        }
    for(int i=a.size()-1;i>=0;i--){
        cout << "Buoc " << i << ": ";
        for(int j=0;j<a[i].size();j++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}
