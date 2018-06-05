class Node{
    Node left;
    Node right;
    int data;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class hw6_1_BinarySearchTree {
    Node root;
    public hw6_1_BinarySearchTree(){
        root = null;
    }
    public boolean find(int n){
        Node current = root;
        if(current==null)return false;
        while(current!=null){
            if(current.data==n)return true;
            else if(current.data > n)current = current.left;
            else current = current.right;
        }
        return false;
    }
    public void insert(int n){
        Node node = new Node(n);
        if(root==null){
            root=node;return;
        }
        Node current = root;
        while(true){
            if(current.data > n){
                if(current.left==null){current.left=node;return;}
                current=current.left;
            }
            else{
                if(current.right==null){current.right=node;return;}
                current=current.right;
            }
        }
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }
    public void delete(int n){
        Node c = null;
        Node current = root;
        if(!find(n)){return;}
        while(current.data!=n){
            if(current.data > n){
                if(current.left.data==n){
                    c = current.left;break;
                }
                current=current.left;
            }
            else{
                if(current.right.data==n){
                    c = current.right;break;
                }
                current=current.right;
            }
        }
        display(c);
    }
    
    public static void main(String[]args){
        hw6_1_BinarySearchTree b = new hw6_1_BinarySearchTree();
        b.insert(5);
        b.insert(3);
        b.insert(2);
        b.insert(1);
        b.insert(4);
        b.insert(8);
        b.insert(6);
        b.insert(10);
        b.display(b.root);
    }
}
