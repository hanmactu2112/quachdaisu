#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n ; cin >> n;
        int dem=0;
        int a[n], A[10000+5]={0};
        for(int i=0;i<n;i++){
            cin >> a[i];
            A[a[i]]++;
        }
        sort(a,a+n);
        for(int i=a[0];i<=a[n-1];i++){
            if(A[i]==0) dem++;
        }
        cout << dem << endl;
    }
}
