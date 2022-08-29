#include<bits/stdc++.h>
using namespace std;
int a[20], b[20], c[20], n, k;
int m;
void in(){
    for(int i=1;i<=k;i++){
        cout << b[c[i]] << " ";
    }
    cout << endl;
}
void Try(int i){
    for(int j=c[i-1]+1;j<=m;j++){
        c[i]=j;
        if(i==k) in();
        else Try(i+1);
    }
}
main(){
    cin>>n>>k;
    set<int> s;
    for(int i=1;i<=n;i++){
        cin>>a[i];
        s.insert(a[i]);
    }
    int k=0;
    for(auto x:s){
        b[++k]=x;
    }
    m=k;
    Try(1);
}
