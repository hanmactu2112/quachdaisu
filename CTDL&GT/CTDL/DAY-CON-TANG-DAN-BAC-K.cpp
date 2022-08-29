#include<bits/stdc++.h>
using namespace std;
int n, k, a[105], b[105], dem=0;
void Try(int i){
    for(int j=b[i-1]+1;j<=n;j++){
        if(a[j]>a[b[i-1]]){
            b[i]=j;
            if(i==k) dem++;
            else Try(i+1);
        }
    }
}
main(){
    cin>>n>>k;
    for(int i=1;i<=n;i++) cin>>a[i];
    Try(1);
    cout << dem << endl;
}
