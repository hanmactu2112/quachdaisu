#include<bits/stdc++.h>
using namespace std;
main(){
    int n,m; cin>>n>>m;
    string s;
    vector<int> a;
    for(int i=0;i<n;i++){
        cin>>s;
        a.push_back(s.size());
    }
    long long cnt=0;
    int A[1000]={0};
    multiset<int> ms;
    for(int i=0;i<m;i++){
        if(ms.find(a[i])!=ms.end()){
            cnt=cnt+A[a[i]];
        }
        ms.insert(a[i]);
        A[a[i]]++;
    }
    for(int i=m;i<n;i++){
        if(ms.find(a[i])!=ms.end()) cnt=cnt+A[a[i]];
        ms.insert(a[i]);
        A[a[i]]++;
        ms.erase(ms.find(a[i-m]));
        A[a[i-m]]--;
    }
    cout << cnt << endl;
}