 #include<bits/stdc++.h>
 using namespace std;
 int main(){
    int t; cin >> t;
    while(t--){
        int n, k; cin >> n >> k;
        vector<int> a(n);
        for(int i=0;i<n;i++) cin >> a[i];
        sort(a.begin(),a.end());
        long long dem=0;
        for(int i=0;i<n;i++){
            int id = upper_bound(a.begin(),a.end(),a[i]-k)-a.begin();
            int m = i-id;
            if(m>0) dem = dem + m;
        }
        cout << dem << endl;
    }
 }
