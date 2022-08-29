#include<bits/stdc++.h>
using namespace std;
int main(){
   int t; cin >> t;
   while(t--){
        int n; cin >> n;
        int a[n+5];
        for(int i=0;i<n;i++){
            cin >> a[i];
        }
        int sum = a[0] + a[1];
        for(int i=0;i<n-1;i++){
            int ii;
            for(int j=i+1;j<n;j++){
                ii=a[i]+a[j];
                if(abs(ii)<abs(sum)){
                    sum = ii;
                }
            }
        }
        cout << sum << endl;
   }
}
