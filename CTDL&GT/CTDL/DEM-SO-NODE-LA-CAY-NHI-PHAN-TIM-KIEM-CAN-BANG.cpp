#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *left,*right;
    node (int x){
        data=x;
        left=right=NULL;
    }
};
node *makenode(int *a, int st, int en){
    if(st>en) return NULL;
    int mid=(st+en)/2;
    node *root = new node(a[mid]);
    root->left=makenode(a,st,mid-1);
    root->right=makenode(a,mid+1,en);
    return root;
}
int dem;
void oup(node *root){
    if(root->left==NULL && root->right==NULL) dem++;
    if(root->left!=NULL){
        oup(root->left);
    }
    if(root->right!=NULL){
        oup(root->right);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        dem=0;
        int n; cin>>n;
        int a[n+5];
        for(int i=1;i<=n;i++) cin>>a[i];
        sort(a+1,a+n+1);
        node *root=makenode(a,1,n);
        oup(root);
        cout << dem <<  endl;
    }
}