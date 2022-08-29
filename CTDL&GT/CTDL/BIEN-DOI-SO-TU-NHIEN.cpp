#include<bits/stdc++.h>
using namespace std;
void xuly(int n){
    queue<int> Q;
    Q.push(n);
    map<int,int> M;
    M[n]=0;
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        if(j==2){
            int d=M[j];
            cout << d+1 << endl;
            break;
        }
        for(int i=2;i<=sqrt(j);i++){
            if(j%i==0 && M.find(j/i)==M.end()){
                Q.push(j/i);
                M[j/i]=M[j]+1;
            }
        }
        if(M.find(j-1)==M.end()){
            Q.push(j-1);
            M[j-1]=M[j]+1;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        xuly(n);
    }
}