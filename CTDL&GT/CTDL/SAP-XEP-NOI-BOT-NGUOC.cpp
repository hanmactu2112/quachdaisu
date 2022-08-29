#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        vector<vector<int>> c;
        int n; cin >> n;
        int a[n]; int b=1;
        for(int i=0;i<n;i++) cin >> a[i];
        for(int i=0;i<n;i++){
            int kt=1;
            for(int j=0;j<n;j++){
                if(a[j]>a[j+1]){
                    kt=0;
                    swap(a[j],a[j+1]);
                }
            }
            if(kt==1) break;
            else if(kt==0){
                vector<int> d;
                for(int i1=0;i1<n;i1++){
                    d.push_back(a[i1]);
                }
                c.push_back(d);
            }
        }
        for(int i=c.size()-1;i>=0;i--){
            cout << "Buoc " << i+1 << ": ";
            for(int j=0;j<c[i].size();j++){
                cout << c[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
}
