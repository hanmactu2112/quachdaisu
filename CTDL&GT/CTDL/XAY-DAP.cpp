#include<bits/stdc++.h>
using namespace std;
void xuly(int n, int m, int a[], int b[]){
    if(m <= (a[1]-0)*b[1]){
        cout << "0" << endl;
    }
    else {
        stack<pair<int,int>> st;
        st.push({a[1],b[1]});
        int ans=0,sum=(a[1])*b[1];
        for(int i=2;i<=n;i++){
            int sum1=0,sum2=0;
            if(!st.empty()){
                while(!st.empty()&&b[i]>st.top().second){
                    pair<int,int> p = st.top();
                    sum1=sum1+p.second;
                    st.pop();
                    int x=p.first, y=p.second;
                    if(!st.empty()){
                        sum2=sum2+(x-st.top().first-1)*y;
                    }
                }
                if(st.empty()){
                    int S=(a[i]-0)*(b[i])-sum1;
                    if(m<=S){
                        ans=i;
                        break;
                    }
                    else sum=S;
                }
                else {
                    int S=(a[i]-st.top().first-1)*b[i]-sum1-sum2;
                    sum=sum+S;
                    if(m<=sum){
                        ans=i;
                        break;
                    }
                }
            } 
            st.push({a[i],b[i]});
        }
        if(ans==0) cout << n << endl;
        else {
            cout << ans-1 << endl;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n+5], b[n+5];
        for(int i=1;i<=n;i++) cin>>a[i];
        for(int i=1;i<=n;i++) cin>>b[i];
        int m; cin>>m;
        int c[m+5];
        for(int i=1;i<=m;i++){
            cin>>c[i];
            xuly(n,c[i],a,b);
        }
        cout << endl;
    }
}
