#include<bits/stdc++.h>
#include <iostream>
using namespace std;
stack <int> st;
struct node{
    int data;
    node *left,*right;
    node(int x){
        data = x;
        left=right=NULL;
    }
};
void levelorder(node *root){
    queue<node *> Q;
    Q.push(root);
    while(!Q.empty()){
        node *nd=Q.front(); Q.pop();
        cout << nd->data << " ";
        if(nd->left!=NULL) Q.push(nd->left);
        if(nd->right!=NULL) Q.push(nd->right);
    }
}
void makenode(node *root, int n1, int n2, char c){
    switch(c){
        case 'L': root->left=new node(n2); break;
        case 'R': root->right=new node(n2); break;
    }
}
void insert(node *root,int n1, int n2, char c){
    if(root==NULL) return;
    if(root->data==n1){
        makenode(root,n1,n2,c);
    }
    else {
        insert(root->left,n1,n2,c);
        insert(root->right,n1,n2,c);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        node *root = NULL;
        while(n--){
            int n1,n2; char c;
            cin>>n1>>n2>>c;
            if(root == NULL){
                root = new node(n1);
                makenode(root,n1,n2,c);
            }
            else insert(root,n1,n2,c);
        }
        levelorder(root);
        cout << endl;
    }
}
