#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        int a[n]; long long sum=0;
        for(int i=0;i<n;i++){
            cin >> a[i];
            sum=sum+a[i];
        }
        long long s=0;
        int k=1; int kt=1;
        for(int i=0;i<k;i++){
            s=s+a[i];
            if(s==sum-s-a[k]){
                kt=0;
                break;
            } else k++;
            if(k>n) break;
        }
        if(kt==1) cout << "-1" << endl;
        else cout << k +1 << endl;
    }
}
