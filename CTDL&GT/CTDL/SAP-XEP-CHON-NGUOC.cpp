#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    vector<vector<int>> a;
    int b[n];
    for(int i=0;i<n;i++) cin >> b[i];
    for(int i=0;i<n-1;i++){
        int k=i;
        for(int j=i+1;j<n;j++){
            if(b[k]>b[j]) k=j;
        }
        if(k!=i) swap(b[i],b[k]);
        vector<int> c;
        for(int i1=0;i1<n;i1++){
            c.push_back(b[i1]);
        }
        a.push_back(c);
    }
    for(int i=a.size()-1;i>=0;i--){
        cout << "Buoc " << i+1 << ": ";
        for(int j=0;j<a[i].size();j++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}
