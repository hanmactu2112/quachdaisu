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
void makenode(node *root, int x, int y, char c){
    if(root==NULL)  return;
    switch(c){
        case 'L': root->L=new node(y); break;
        case 'R': root->R=new node(y); break;
    }
}
void insert(node *root, int x, int y, char c){
    if(root==NULL) return;
    if(root->data==x){
        makenode(root,x,y,c);
    }
    insert(root->L,x,y,c);
    insert(root->R,x,y,c);
}
int kt;
vector<int> a;
void hoan_hao(node *root, int dodai){
    if(root!=NULL){
        if(root->L==NULL && root->R==NULL){
            a.push_back(dodai);
        }
        else if((root->L==NULL && root->R!=NULL) || (root->L!=NULL && root->R==NULL)){
            kt=1;
        } 
        hoan_hao(root->L,dodai+1);
        hoan_hao(root->R,dodai+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        kt=0;
        int n; cin>>n;
        node *root=NULL;
        while(n--){
            int x,y; char c;
            cin>>x>>y>>c;
            if(root==NULL){
                root = new node(x);
                makenode(root,x,y,c);
            }
            else insert(root,x,y,c);
        }
        hoan_hao(root,0);
        int id=0;
        if(kt==0){
            for(int i=1;i<a.size();i++){
                if(a[i]!=a[0]){
                    id=1;
                    break;
                }
            }
            if(id==0) cout << "Yes" << endl;
            else cout << "No" << endl;
        }
        else cout << "No" << endl;
    }
}