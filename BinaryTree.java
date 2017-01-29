package binarytree;
import java.util.*;
/*
Write a program to return the mirror tree of a given binary tree.
Print the Level order traversal and other traversals
Create a Balanced BST
Search in BST
Height of the given tree
*/
public class BinaryTree {
    Node root;
    Node mirrorRoot;
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        List<Integer> ls = new LinkedList<Integer>();
        ls.add(25);
        ls.add(15);
        ls.add(30);
        ls.add(75);
        ls.add(85);
        ls.add(50);
        Collections.sort(ls);
        //Iterator itr = ls.iterator();
        //while(itr.hasNext())
        //   System.out.print(itr.next()+" ");
        tree.createBalancedBST(ls,0,ls.size()-1);
		System.out.println(tree.findNode(50, tree.root));
        System.out.println("Root key: "+tree.root.key);
        System.out.println("Inorder Traversal:");
        tree.inOrderTraversal(tree.root,null);
        System.out.println();
        System.out.println("Inorder Traversal without recursion:");
        tree.inOrderTraversal(tree.root,false);
        System.out.println();        
        System.out.println("Inorder Traversal of parent nodes");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        int h = tree.height(tree.root);
        System.out.println("Tree height: " + h);
        
        /*
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(30);
        tree.addNode(75);
        tree.addNode(85);        
        tree.addNode(50);
        System.out.println("Inorder Traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Preorder Traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Postorder Traversal:");
        tree.postOrderTraversal(tree.root);
        System.out.println();
        System.out.println(tree.findNode(50, tree.root));
        tree.addNodeMirror(50);
        tree.addNodeMirror(25);
        tree.addNodeMirror(15);
        tree.addNodeMirror(30);
        tree.addNodeMirror(75);
        tree.addNodeMirror(85);
        System.out.println("Mirrored Inorder Traversal:");
        tree.inOrderTraversal(tree.mirrorRoot);
        System.out.println();        
        System.out.println("Levelorder Traversal:");
        tree.levelOrderTraversal(tree.root);
        System.out.println();     
        */
    }   
    
    int height(Node n){
        if (n==null)
            return 0;
        int lheight = height(n.left);
        int rheight = height(n.right);
        
        if (lheight>rheight)
            return lheight + 1;
        else
            return rheight + 1;        
    }
    
    //Under construction
    void removeNode(int key,Node parent,Node CurrentNode){
        parent = CurrentNode;
        if(CurrentNode==null){
            return;
        }
        else if(key<CurrentNode.key){
            CurrentNode = CurrentNode.left;
            removeNode(key,parent,CurrentNode);
        }
        else if(key>CurrentNode.key){
            CurrentNode = CurrentNode.right;
            removeNode(key,parent,CurrentNode);
        }
        else{
            if(CurrentNode.left==null && CurrentNode.right==null)
                CurrentNode=null;
            
            return;
        }        
        return;
    }
    void createBalancedBST(List<Integer> ls,int start,int end){
        int mid = (end+start)/2;
        if(end<start)
            return;
        addNode(ls.get(mid));
        createBalancedBST(ls,start,mid-1);
        createBalancedBST(ls,mid+1,end);
    }
    void addNode(int key){
        Node n=new Node(key);
        Node CurrentNode;
        if (root==null){
            root=n;
        }
        else{
            CurrentNode=root;
            Node parent;
            while(true){
                parent=CurrentNode;
                if(key<parent.key){
                    CurrentNode=CurrentNode.left;
                    if (CurrentNode==null){
                        parent.left=n;
                        return;
                    }
                }
                else{
                    CurrentNode=CurrentNode.right;
                    if (CurrentNode==null){
                        parent.right=n;
                        return;
                    }                    
                }
            }
        }
    }
    void addNodeMirror(int key){
        Node n=new Node(key);
        Node CurrentNode;
        if (mirrorRoot==null){
            mirrorRoot=n;
        }
        else{
            CurrentNode=mirrorRoot;
            Node parent;
            while(true){
                parent=CurrentNode;
                if(key>parent.key){
                    CurrentNode=CurrentNode.left;
                    if (CurrentNode==null){
                        parent.left=n;
                        return;
                    }
                }
                else{
                    CurrentNode=CurrentNode.right;
                    if (CurrentNode==null){
                        parent.right=n;
                        return;
                    }                    
                }
            }
        }
    }    

    void inOrderTraversal(Node CurrentNode, Node ParentNode){
        if (CurrentNode != null) {
            inOrderTraversal(CurrentNode.left,CurrentNode);           
            System.out.print(CurrentNode.key+" ");
            CurrentNode.parent = ParentNode;
            inOrderTraversal(CurrentNode.right,CurrentNode);    
        }        
    }
    void inOrderTraversal(Node CurrentNode){
        if (CurrentNode != null) {
            inOrderTraversal(CurrentNode.left);  
            if (CurrentNode.parent != null)
                System.out.print(CurrentNode.parent.key+" ");
            else
                System.out.print("null ");
            inOrderTraversal(CurrentNode.right);    
        }        
    }    
    void inOrderTraversal(Node CurrentNode, boolean placeHolder){ //without using recursion
        if (CurrentNode == null)
            return;
        Stack<Node> st = new Stack<Node>();        
        st.push(CurrentNode);
        while(true){            
            while(CurrentNode.left!=null){
                st.push(CurrentNode.left);    
                CurrentNode = CurrentNode.left;
            }
            CurrentNode = st.pop();            
            System.out.print(CurrentNode.key+" ");         
            if(CurrentNode.right!=null){
                CurrentNode = CurrentNode.right;               
                st.push(CurrentNode);                
            }                
            if (st.empty())
                break;
        }
    }        
    void preOrderTraversal(Node CurrentNode){
        if (CurrentNode != null) {
            System.out.print(CurrentNode.key+" ");
            preOrderTraversal(CurrentNode.left);            
            preOrderTraversal(CurrentNode.right);    
        }        
    }    
    void postOrderTraversal(Node CurrentNode){
        if (CurrentNode != null) {            
            postOrderTraversal(CurrentNode.left);            
            postOrderTraversal(CurrentNode.right);    
            System.out.print(CurrentNode.key+" ");            
        }        
    }    
    void levelOrderTraversal(Node CurrentNode){
        if (CurrentNode != null) {            
            if (CurrentNode==root)
                System.out.print(CurrentNode.key+" ");
            if (CurrentNode.left != null)
                System.out.print(CurrentNode.left.key+" ");
            if (CurrentNode.right != null)
            System.out.print(CurrentNode.right.key+" ");
            levelOrderTraversal(CurrentNode.left);            
            levelOrderTraversal(CurrentNode.right);                            
        }        
    }     
    String findNode(int key,Node CurrentNode){
        if(CurrentNode!=null){ 
			if(CurrentNode.key==key){
				return "Found: "+key;
			}
			else if(key<CurrentNode.key){
				return findNode(key,CurrentNode.left);
			}
			else if(key>CurrentNode.key){
				return findNode(key,CurrentNode.right);
			}      
			return "Not found";
		}
    }  
}

class Node{
    int key;
    Node left,right,parent;
    Node(int key){
        this.key=key;
    }
}