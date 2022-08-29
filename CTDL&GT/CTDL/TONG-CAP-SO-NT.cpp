#include<bits/stdc++.h>
using namespace std;
int main(){
    int A[100000+5] = {1};
    for(int i=0;i<100000+5;i++){
        A[i]=1;
    }
    A[1]=0;A[0]=0;
    for(int i=2;i<100000+5;i++){
        if(A[i]!=0){
            for(int j=2*i;j<100000+5;j=j+i){
                A[j]=0;
            }
        }
    }
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        if(n<=3) cout << "-1" << endl;
        else {
            int kt = 1;
            for(int i=2;i<=n/2;i++){
                if(A[i]==1&&A[n-i]==1){
                    kt=0;
                    cout << i << " " << n-i;
                    break;
                }
            }
            if(kt==1) cout << "-1";
            cout << endl;
        }
    }
}
