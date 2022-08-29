#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        queue<int> Q;
        for(int i=0;i<n;i++){
            int x; cin>>x;
            if(x==1){
                cout << Q.size() << endl;
            }
            else if(x==2){
                if(!Q.empty()){
                    cout << "NO" << endl;
                }
                else cout << "YES" << endl;
            }
            else if(x==3){
                int y; cin>>y;
                Q.push(y);
            }
            else if(x==4){
                if(!Q.empty()){
                    Q.pop();
                }
            }
            else if(x==5){
                if(!Q.empty()){
                    cout << Q.front() << endl;
                }
                else cout << "-1" << endl;
            }
            else if(x==6){
                if(!Q.empty()){
                    cout << Q.back() << endl;
                }
                else cout << "-1" << endl;
            }
        }
    }
}