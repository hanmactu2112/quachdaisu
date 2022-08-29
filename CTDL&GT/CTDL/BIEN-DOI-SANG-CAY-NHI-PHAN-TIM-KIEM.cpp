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
node *makenode(int n){
    map<int,node*> mp;
    node *root=NULL;
    while(n--){
        int x,y; char c;
        cin>>x>>y>>c;
        if(mp.find(x)==mp.end()){
            node *tmp = new node(x);
            mp[x]=tmp;
            root=tmp;
        }
        node *tmp=new node(y);
        node *tmp1=mp[x];
        if(c=='L') tmp1->left=tmp;
        else tmp1->right=tmp;
        mp[y]=tmp;
    }
    return root;
}
vector<int> a;
void oup(node* &root){
    if(root!=NULL){
        oup(root->left);
        a.push_back(root->data);
        oup(root->right);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        int n; cin>>n;
        node *root=makenode(n);
        oup(root);
        sort(a.begin(),a.end());
        for(int i=0;i<a.size();i++) cout << a[i] << " ";
        cout << endl;
    }
}