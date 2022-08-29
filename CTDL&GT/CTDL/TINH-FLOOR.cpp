#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        vector<int> a;
        int n,m;
        cin>>n>>m;
        int x;
        for(int i=0;i<n;i++){
            cin>>x;
            a.push_back(x);
        }
        sort(a.begin(),a.end());
        int ans=upper_bound(a.begin(),a.end(),m)-a.begin();
        if(ans==0) cout << "-1" << endl;
        else cout << ans << endl;
    }
}
