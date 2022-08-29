#include<bits/stdc++.h>
using namespace std;
int main(){
    int n; cin >> n;
    int a[n];
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n;i++){
        int k=a[i];
        int j=i-1;
        while(j>=0 && a[j]>k){
                a[j+1]=a[j];
                j--;
        }
        a[j+1]=k;
        cout << "Buoc " << i << ": ";
        for(int i1=0;i1<=i;i1++){
            cout << a[i1] << " ";
        }
        cout << endl;
    }
}

