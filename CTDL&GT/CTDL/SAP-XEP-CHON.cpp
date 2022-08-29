#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    int a[n];
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n-1;i++){
        int k=i;
        for(int j=i+1;j<n;j++){
            if(a[k]>a[j]) k=j;
        }
        if(k!=i) swap(a[k],a[i]);
        cout << "Buoc " << i+1 << ": ";
        for(int i1=0;i1<n;i1++) cout << a[i1] << " ";
        cout << endl;
    }
}
