#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n, k; cin >> n >> k;
        int a[n], A[100]={0};
        for(int i=0;i<k;i++){
            cin >> a[i];
            A[a[i]]++;
        }
        int i=k-1, dem=0;
        while(i>=0 && a[i]>n-k+i){
            i--;
        }
        if(i==-1){
            cout << k << endl;
        }
        else {
            a[i]=a[i]+1;
            for(int j=i+1;j<n;j++){
                a[j]=a[i]+j-i;
            }
            for(int j=0;j<k;j++){
                if(A[a[j]]==0) dem++;
            }
            cout << dem << endl;
        }
    }
}
