#include<bits/stdc++.h>
using namespace std;
int a[20], n, k;
void sinhKT(){
    int i=k;
    while(i>0 && a[i]-a[i-1]==1) i--;
    if(i==0){
        for(int j=n-k+1;j<=n;j++) cout << j << " ";
    }
    else {
        a[i]--;
        for(int j=i+1;j<=k;j++){
            a[j]=n-k+j;
        }
        for(int j=1;j<=k;j++){
            cout << a[j] << " ";
        }
    }
}
int main(){
    int t; cin >> t;
    while(t--){
        cin >> n >> k;
        for(int i=1;i<=k;i++){
            cin >> a[i];
        }
        sinhKT();
        cout << endl;
    }
}
