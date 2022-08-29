#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, m; cin >> n >> m;
        int a[n], b[m];
        int A[100000+5]={0}, B[100000+5]={0};
        for(int i=0;i<n;i++){
            cin >> a[i];
            A[a[i]]++;
        }
        for(int i=0;i<m;i++){
            cin >> b[i];
            B[b[i]]++;
        }
        for(int i=0;i<100000+5;i++){
            if(A[i]>0 || B[i]>0){
                cout << i << " ";
            }
        }
        cout << endl;
        for(int i=0;i<100000+5;i++){
            if(A[i]>0 && B[i]>0){
                cout << i << " ";
            }
        }
        cout << endl;
    }
}
