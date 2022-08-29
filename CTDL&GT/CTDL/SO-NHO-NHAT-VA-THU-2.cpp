#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n ;
        set<int> a;
        int x;
        for(int i=0;i<n;i++){
            cin >> x;
            a.insert(x);
        }
        if(a.size()==1) cout << "-1";
        else {
            int dem=0;
            for(auto i:a){
                dem++;
                cout << i << " ";
                if(dem==2) break;
            }
        }
        cout << endl;
    }
}

