#include<bits/stdc++.h>
using namespace std;
struct data{
    int x, z, y;
};
bool cmp(data a, data b){
    if(a.y==b.y) return a.z < b.z ;
    else return a.y < b.y;
}
main(){
    int t; cin >> t;
    while(t--){
        int n, m;
        cin >> n >> m;
        vector<data> a(n);
        for(int i=0;i<n;i++){
            cin >> a[i].x;
            a[i].z = i ;
            a[i].y = abs(a[i].x-m);
        }
        sort(a.begin(),a.end(),cmp);
        for(int i=0;i<n;i++){
            cout << a[i].x << " ";
        }
        cout << endl;
    }
}
