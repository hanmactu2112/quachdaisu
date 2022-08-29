#include<bits/stdc++.h>
using namespace std;
int main(){
    long long t; cin>>t;
    while(t--){
        stack<int> st;
        long long n; cin>>n;
        if(n<=9) cout << n;
        else {
            long long m=9; int kt=1;
            while(n>1){
                if(m==1){
                    cout << "-1";
                    kt=0;
                    break;
                }
                if(n%m==0){
                    st.push(m);
                    n=n/m;
                }
                else{
                    m--;
                }
            }
            if(kt==1){
                while(!st.empty()){
                    long long x=st.top();
                    st.pop();
                    cout << x ;
                }
            }
        }
        cout << endl;
    }
}