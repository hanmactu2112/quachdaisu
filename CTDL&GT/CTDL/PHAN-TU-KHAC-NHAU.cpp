#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        long long n; cin>>n;
        long long a[n],b[n];
        for(long long i=0;i<n;i++){
            cin>> a[i];
        }
        for(long long i=0;i<n-1;i++){
            cin>>b[i];
        }
        for(long long i=0;i<n;i++){
            if(a[i]!=b[i]){
                cout << i+1;
                break;
            }
        }
        cout << endl;
    }
}
