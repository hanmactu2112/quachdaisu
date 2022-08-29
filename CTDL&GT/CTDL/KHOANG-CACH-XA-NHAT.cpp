#include<bits/stdc++.h>
using namespace std;
struct data{
    int x, y;
};
bool cmp(data a, data b){
    return a.x < b.x;
}
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        vector<data> a(n);
        for(int i=0;i<n;i++){
            cin >> a[i].x;
            a[i].y=i;
        }
        sort(a.begin(),a.end(),cmp);
        int amin=a[0].y;
        int ans=-1;
        for(int i=1;i<n;i++){
            if(a[i].y>=amin){
                ans=max(ans,a[i].y-amin);
            } else {
                amin=a[i].y;
            }
        }
        cout << ans << endl;
    }
}
