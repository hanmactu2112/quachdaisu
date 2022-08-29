#include<bits/stdc++.h>
using namespace std;
int a[10]={1,2,5,10,20,50,100,200,500,1000};
void xuly(int n){
    int i=9;
    int dem=0;
    while(n>0){
        if(n<a[i]) i--;
        else {
            dem++;
            n=n-a[i];
        }
    }
    cout << dem << endl;
}
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        xuly(n);
    }
}