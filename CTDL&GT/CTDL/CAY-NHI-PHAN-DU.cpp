#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *L,*R;
    node (int x){
        data=x;
        L=R=NULL;
    }
};
node* makenode(int n){
    node *root=NULL;
    map<int,node*> mp;
    while(n--){
        int x,y; char c;
        cin>>x>>y>>c;
        if(mp.find(x)==mp.end()){
            node *tmp= new node(x);
            mp[x]=tmp;
            if(root==NULL){
                root=tmp;
            }
        }
        node *tmp1=new node(y);
        node *tmp2 = mp[x];
        if(c=='R') tmp2->R=tmp1;
        else tmp2->L=tmp1;
        mp[y]= tmp1;
    }
    return root;
}
int kt;
void tim(node *root){
    if(root!=NULL){
        if((root->L==NULL && root->R!=NULL) || (root->L!=NULL && root->R==NULL)){
            kt=1;
            return;
        }
        tim(root->L);
        tim(root->R);
    }
}
void slove(){
    kt=0;
    int n;
    cin>>n;
    node *root = makenode(n);
    tim(root);
    if(kt==0){
        cout << "1" << endl;
    }
    else cout << "0" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        slove();
    }
}