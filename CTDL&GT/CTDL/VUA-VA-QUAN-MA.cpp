#include<bits/stdc++.h>
using namespace std;
int t1[8]={-1,-1,-1,0,0,1,1,1};
int t2[8]={-1,0,1,-1,1,-1,0,1};
int m1[8]={2,1,-1,-2,2,1,-1,-2};
int m2[8]={-1,-2,-2,-1,1,2,2,1};
void duong_di(char a[205][205], int n, int x, int y, int x1, int y1){
    queue<pair<int,int>> Qm;
    map<int,int> Mm;
    Qm.push({x,y});
    Mm[x*10+y]=0;
    queue<pair<int,int>> Qt;
    map<int,int> Mt;
    Qt.push({x1,y1});
    Mt[x1*10+y1]=0;
    while(1){
        if(Qm.empty() && Qt.empty()){
            cout << "-1" << endl;
            break;
        }
        if(!Qm.empty()){
            pair<int,int> p=Qm.front();
            Qm.pop();
            if(Mt.find(p.first*10+p.second)!=Mt.end()){
                cout << max(Mt[p.first*10+p.second],Mm[p.first*10+p.second]);
                break;
            }
            for(int i=0;i<8;i++){
                int id1=p.first+m1[i];
                int id2=p.second+m2[i];
                if(id1>=1 && id1<=n && id2 >= 1 && id2 <=n && a[id1][id2]!='#'){
                    if(Mm.find(id1*10+id2)==Mm.end()){
                        Qm.push({id1,id2});
                        Mm[id1*10+id2]=Mm[p.first*10+p.second]+1;
                    }
                }
            }
        }
        if(!Qt.empty()){
            pair<int,int> pt=Qt.front();
            Qt.pop();
            if(Mm.find(pt.first*10+pt.second)!=Mm.end()){
                cout << max(Mm[pt.first*10+pt.second],Mt[pt.first*10+pt.second]);
                break;
            }
            for(int i=0;i<8;i++){
                int id3=pt.first+t1[i];
                int id4=pt.second+t2[i];
                if(id3>=1 && id3<=n && id4>=1 && id4 <=n && a[id3][id4]!='#'){
                    if(Mt.find(id3*10+id4)==Mt.end()){
                        Qt.push({id3,id4});
                        Mt[id3*10+id4]=Mt[pt.first*10+pt.second]+1;
                    }
                }
            }
        }
    }
}
main(){
    int n; char a[205][205];
    cin>>n;
    cin.ignore();
    int x,y,x1,y1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>a[i][j];
        }
    }
    clock_t st,en;
        double time_use;
    st=clock();
    int kt=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(a[i][j]=='M'){
                x=i;
                y=j;
                kt=0;
                break;
            }
        }
        if(kt==0) break;
    }
    kt=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(a[i][j]=='T'){
                x1=i;
                y1=j;
                kt=0;
                break;
            }
        }
        if(kt==0) break;
    }
    duong_di(a,n,x,y,x1,y1);
    en=clock();
    time_use=double(en-st);
    cout << time_use;
}