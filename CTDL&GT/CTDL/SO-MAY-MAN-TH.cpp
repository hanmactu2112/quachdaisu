#include<bits/stdc++.h>
using namespace std;
main(){
    long long a,b; cin>>a>>b;
    queue<long long> Q;
    Q.push(4);
    Q.push(7);
    vector<long long> V;
    V.push_back(4);
    V.push_back(7);
    while(1){
        long long i=Q.front();
        Q.pop();
        if(i>=b) break;
        long long j = i*10+4;
        V.push_back(j);
        Q.push(j);
        if(j>=b) break;
        long long k=i*10+7;
        Q.push(k);
        V.push_back(k);
        if(k>=b) break;
    }
    long long sum=0;
    for(long long i=a;i<=b;i++){
        long long vt=lower_bound(V.begin(),V.end(),i)-V.begin();
        sum=sum+V[vt];
    }
    cout << sum << endl;
}
