#include<bits/stdc++.h>
using namespace std;
void xuly(int a[], int n){
    stack<pair<int,int>> st;
    int sum=0;
    for(int i=1;i<=n;i++){
        if(a[i]!=0){
            if(!st.empty()){
                int j,k,sum1=0,sum2=0;
                while(!st.empty()&&a[i]>st.top().second){
                    pair<int,int> p=st.top();
                    st.pop();
                    j=p.second;
                    k=p.first;
                    sum1=sum1+j;
                    if(!st.empty()){
                        sum2=sum2+(p.first-st.top().first-1)*p.second;
                    }
                }
                if(st.empty()){
                    int S=(i-k)*j-sum1;
                    sum=S;
                }
                else {
                    int S=(i-st.top().first-1)*a[i]-sum2-sum1;
                    sum=sum+S;
                }
            }
            st.push({i,a[i]});
        }
        else continue;
    }
    cout << sum << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n+5];
        for(int i=1;i<=n;i++){
            cin>>a[i];
        }
        xuly(a,n);
    }
}