#include<bits/stdc++.h>
using namespace std;
int A[10000+5]={0}, a[200], n, p, s;
int dem, b[200];
vector<vector<int>> op;
void in(){
    vector<int> op1;
    for(int i=1;i<=n;i++){
        op1.push_back(a[b[i]]);
    }
    op.push_back(op1);
}
void Try(int i, int sum){
    for(int j=b[i-1]+1;j<=dem;j++){
        if(sum+a[j]<=s){
            sum=sum+a[j];
            b[i]=j;
            if(i==n&&sum==s){
                in();
            }
            else Try(i+1,sum);
            sum=sum-a[j];
        }
    }
}
int main(){
    A[0]=1;
    A[1]=1;
    for(int i=2;i<=10000+5;i++){
        if(A[i]==0){
            for(int j=2*i;j<=10000+5;j=j+i){
                A[j]=1;
            }
        }
    }
    int t; cin >> t;
    while(t--){
        op.clear();
        dem=0;
        a[200]={0};
        cin >> n >> p >> s;
        for(int i=p+1;i<=s;i++){
            if(A[i]==0){
                a[++dem]=i;
            }
        }
        Try(1,0);
        if(op.size()==0){
            cout << "0" << endl;
        }
        else {
            cout << op.size() << endl;
            for(int i=0;i<op.size();i++){
                for(int j=0;j<op[i].size();j++){
                    cout << op[i][j] << " ";
                }
                cout << endl;
            }
        }

    }
}
