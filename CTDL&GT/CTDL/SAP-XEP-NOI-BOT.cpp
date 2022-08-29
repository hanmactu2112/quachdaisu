#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    int a[n]; int b=1;
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n;i++){
        int kt=1;
        for(int j=0;j<n;j++){
            if(a[j]>a[j+1]){
                kt=0;
                swap(a[j],a[j+1]);
            }
        }
        if(kt==1) break;
        else if(kt==0){
            cout << "Buoc " << b++ << ": ";
            for(int i1=0;i1<n;i1++) cout << a[i1] << " ";
            cout << endl;
        }
    }
}
