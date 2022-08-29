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
node* makenode(int n){
    node *root=NULL;
    map<int, node*> mp;
    while(n--){
        int x,y; char c;
        cin>>x>>y>>c;
        if(mp.find(x)==mp.end()){
            node *tmp = new node(x);
            mp[x]=tmp;
            if(root==NULL){
                root=tmp;
            }
        }
        node *tmp = new node(y);
        node *tmp1 = mp[x];
        if(c=='R') tmp1->right=tmp;
        else tmp1->left=tmp;
        mp[y] = tmp;
    }
    return root;
}
void oup(node *root){
    queue<node*> Q;
    Q.push(root);
    int dem=0;
    while(!Q.empty()){
        if(dem%2==1){
            vector<node*> V;
            while(!Q.empty()){
                V.push_back(Q.front()); Q.pop();
            }
            for(int i=V.size()-1;i>=0;i--){
                cout << V[i]->data << " ";
                if(V[i]->left!=NULL) Q.push(V[i]->left);
                if(V[i]->right!=NULL) Q.push(V[i]->right);
            }
        }
        else {
            vector<node*> V;
            while(!Q.empty()){
                V.push_back(Q.front()); Q.pop();
            }
            for(int i=V.size()-1;i>=0;i--){
                cout << V[i]->data << " ";
                if(V[i]->right!=NULL) Q.push(V[i]->right);
                if(V[i]->left!=NULL) Q.push(V[i]->left);
            }
        }
        dem++;
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n;
        cin>>n;
        node *root1=makenode(n);
        oup(root1);
        cout << endl;
    }
}