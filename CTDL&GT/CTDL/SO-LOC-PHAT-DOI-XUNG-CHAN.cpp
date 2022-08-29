#include<bits/stdc++.h>
using namespace std;
void xuly(int n){
    int dem=0;
    queue<string> Q;
    Q.push("6"); Q.push("8");
    cout << "66" << " " << "88" << " ";
    while(1){
        if(dem==n-2) break;
        string top=Q.front();
        Q.pop();
        string m=top+"6";
        cout << m;
        for(int i=m.size()-1;i>=0;i--){
            cout << m[i];
        }
        cout << " ";
        dem++;
        if(dem==n-2) break;
        string t=top+"8";
        cout << t;
        for(int i=t.size()-1;i>=0;i--){
            cout << t[i];
        }
        cout << " ";
        dem++;
        if(dem==n-2) break;
        Q.push(top+"6");
        Q.push(top+"8");
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        xuly(n);
        cout << endl;
    }
}

