#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        int a[n], A[100000+5]={0};
        for(int i=0;i<n;i++){
            cin >> a[i];
            A[a[i]]++;
        }
        int kt=1;
        for(int i=0;i<n;i++){
            if(A[a[i]]>n/2){
                kt=0;
                cout << a[i];
                A[a[i]]=0;
            }
        }
        if(kt==1) cout << "NO" ;
        cout << endl;
    }
}
