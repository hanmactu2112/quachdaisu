#include<bits/stdc++.h>
using namespace std;
void xuly(int n, int m){
    vector<int> a;
    m=m-1;
    for(int i=1;i<n;i++){
        if(m>9){
            a.push_back(9);
            m=m-9;
        }
        else {
            a.push_back(m);
            m=0;
        }
    }
    a.push_back(m+1);
    for(int i=a.size()-1;i>=0;i--) cout << a[i];
}
void xuly1(int n, int m){
    vector<int> a;
    for(int i=1;i<=n;i++){
        if(m>9){
            a.push_back(9);
            m=m-9;
        }
        else {
            a.push_back(m);
            m=0;
        }
    }
    for(int i=0;i<a.size();i++) cout << a[i];
}
main(){
    int n,m;
    cin>>n>>m;
    if(9*n<m){
        cout << "-1" << " " << "-1" << endl;
    }
    else if(m==0){
        cout << "-1" << " " << "-1" << endl;
    }
    else {
        xuly(n,m);
        cout << " ";
        xuly1(n,m);
    }
}