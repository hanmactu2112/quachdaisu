#include<bits/stdc++.h>
using namespace std;
int a[20], n, d[20], c[20];
vector<vector<string>> id;
void in(int m){
    vector<string> b;
    for(int i=1;i<=m;i++){
        b.push_back(to_string(a[d[i]]));
    }
    id.push_back(b);
}
void Try(int i){
    for(int j=d[i-1]+1;j<=n;j++){
        if(a[j]>a[d[i-1]]){
            d[i]=j;
            if(i>=2) in(i);
            Try(i+1);
        }
    }
}
main(){
    cin >> n;
    for(int i=1;i<=n;i++) cin >> a[i];
    d[0]=0;
    Try(1);
    sort(id.begin(),id.end());
    for(int i=0;i<id.size();i++){
        for(int j=0;j<id[i].size();j++){
            cout << id[i][j] << " ";
        }
        cout << endl;
    }

}
