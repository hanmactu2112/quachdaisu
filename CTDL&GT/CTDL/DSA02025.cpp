#include<bits/stdc++.h>
using namespace std;
int C[30][30], A[30], B[30]={0}, n, fopt = 1e9, cmin = 1e9, cost = 0;
void quaylui(int i){
    int j;
    for(j=1;j<=n;j++){
        if(B[j]==0){
            A[i] = j; B[j] = 1;
            cost = cost + C[A[i-1]][A[i]];
            if(i==n){
                fopt = min(fopt,cost);
            }
            else if(cost + cmin*(n-i+1) < fopt){
                quaylui(i+1);
            }
            B[j] = 0;
            cost = cost - C[A[i-1]][A[i]];
        }
    }
}
int dem(string s1, string s2){
    int i=0,j=0,d=0;
    while(i<s1.size() && j<s2.size()){
        if(s1[i]==s2[j]){
            d++; i++; j++;
        }
        else if(s1[i] < s2[j]) i++;
        else j++;
    }
    return d;
}
main(){
    int i,j; string tmp; vector<string> vs;
    cin >> n;
    for(i=0;i<n;i++){
        cin >> tmp;
        vs.push_back(tmp);
    }
    for(i=1;i<=n;i++){
        for(j=1;j<=n;j++){
            if(i==j) C[i][j] = 1e9;
            else C[i][j] = dem(vs[i-1],vs[j-1]);
            cmin = min(cmin, C[i][j]);
        }
    }
    quaylui(1);
    cout << fopt << endl;
}
