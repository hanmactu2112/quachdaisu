#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *L,*R;
    node(int x){
        data = x;
        L=R=NULL;
    }
};
void makenode(node *root, int x, int y, char c){
    switch(c){
        case 'L': root->L=new node(y); break;
        case 'R': root->R=new node(y); break;
    }
}
void insert(node *root,int x, int y, char c){
    if(root==NULL) return;
    if(root->data==x){
        makenode(root,x,y,c);
    }
    else {
        insert(root->L,x,y,c);
        insert(root->R,x,y,c);
    }
}
void levelorder(node *root){
    queue<node *> Q;
    Q.push(root);
    while(!Q.empty()){
        node *nd=Q.front(); Q.pop();
        cout << nd->data << " ";
        if(nd->L!=NULL) Q.push(nd->L);
        if(nd->R!=NULL) Q.push(nd->R);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        node *root = NULL;
        while(n--){
            int x,y; char c;
            cin>>x>>y>>c;
            if(root == NULL){
                root = new node(x);
                makenode(root,x,y,c);
            }
            else insert(root,x,y,c);
        }
        levelorder(root);
        cout << endl;
    }
}