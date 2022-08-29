#include<bits/stdc++.h>
using namespace std;
main(){
    int n; cin >> n ;
    int a[n], A[1000+5]={0};
    for(int i=0;i<n;i++){
        cin>>a[i];
        A[a[i]]++;
    }
    for(int i=0;i<n;i++){
        if(A[a[i]]>=1){
            cout << a[i] << " ";
            A[a[i]]=0;
        }
    }
}
