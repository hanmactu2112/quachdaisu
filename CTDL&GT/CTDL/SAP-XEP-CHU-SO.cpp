#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        int a[n];
        for(int i=0;i<n;i++){
            cin >> a[i];
        }
        set<int> st;
        for(int i=0;i<n;i++){
            while(a[i]>0){
                int i1 = a[i]%10;
                a[i]=a[i]/10;
                st.insert(i1);
            }
        }
        for(auto x:st){
            cout << x << " ";
        }
        cout << endl;
    }
}
