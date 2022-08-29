#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    int a[n];
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n-1;i++){
        int kt=1;
        for(int j=i+1;j<n;j++){
            if(a[i]>a[j]){
                kt=0;
                swap(a[i],a[j]);
            }
        }
        if(kt==0){
            cout << "Buoc " << i+1 << ": ";
            for(int i=0;i<n;i++) cout << a[i] << " ";
            cout << endl;
        }
    }
}
