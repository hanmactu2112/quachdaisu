#include<bits/stdc++.h>
using namespace std;
void xuly(int n, int m){
    if(m*9<n){
        cout << "-1";
        return;
    }
    if(n==0){
        cout << "-1";
        return;
    }
    else {
        n=n-1;
        int a[1000+5]={};
        for(int i=m-1;i>=1;i--){
            if(n>=9){
                a[i]=9;
                n=n-9;
            }
            else {
                a[i]=n;
                n=0;
            }
        }
        a[0]=n+1;
        for(int i=0;i<m;i++){
            cout << a[i];
        }
    }
}
int main(){
    int t; cin >> t;
    while(t--){
        int n,m;
        cin >> n >> m;
        xuly(n,m);
        cout << endl;
    }
}
