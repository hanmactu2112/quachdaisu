#include<bits/stdc++.h>
using namespace std;
int n, a[20], b[20], s;
int ngto(int l){
    if(l==0||l==1) return 0;
    else {
        for(int i=2;i<=sqrt(l);i++){
            if(l%i==0) return 0;
        }
        return 1;
    }
}
vector<vector<int>> op;
void in(int m){
    vector<int> op1;
    for(int i=m;i>=1;i--){
        op1.push_back(a[b[i]]);
    }
    op.push_back(op1);
}
void Try(int i, int sum){
    for(int j=b[i-1]+1;j<=n;j++){
        if(sum+a[j]<=s){
            b[i]=j;
            sum=sum+a[j];
            if(ngto(sum)==1) in(i);
            Try(i+1,sum);
            sum=sum-a[j];
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        op.clear();
        s=0;
        cin>>n;
        for(int i=1;i<=n;i++){
            cin>>a[i];
            s=s+a[i];
        }
        sort(a,a+n+1);
        Try(1,0);
        sort(op.begin(),op.end());
        for(int i=0;i<op.size();i++){
            for(int j=0;j<op[i].size();j++){
                cout << op[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
}