package TreeJava;


     class TreeNode<T> {
         T data;
         TreeNode<T> left,right;
         public  TreeNode(T data){
             this.data = data;
             this.left = this.right = null;
         }
         // thêm phần tử vào cây
     }
     public class BinaryTree<T>{
         TreeNode<T> root;
         public BinaryTree(){
             this.root = null;
         }
         public void insert(T data){// khi chạy chương trình thì thằng này nó sẽ gọi thằng insertRec và cứ như vậy nó sẽ chạy
            root = insertRec(root,data);
         }

         // thêm 1 phần tử vào cây nhị phân
         public TreeNode<T> insertRec(TreeNode<T> root,T data){
             if (root == null){
                 root = new TreeNode<>(data);
                 return root;
             }else {
                 if (data.hashCode() > root.data.hashCode()){
                     root.right = insertRec(root.right,data);
                 }else if(data.hashCode() < root.data.hashCode()){
                     root.left = insertRec(root.left,data);
                 }
             }
             return root;
         }

         public void duyetPostorder(TreeNode<T> root){
                 if (root!=null){
                     duyetPostorder(root.left);
                     System.out.println(root.data+ " ");
                     duyetPostorder(root.right);
                 }
         }

         public static void main(String[] args) {
             BinaryTree<Integer> tree = new BinaryTree<>();
             tree.insert(50);
             tree.insert(30);
             tree.insert(70);
             tree.insert(20);
             tree.insert(40);
             tree.insert(60);
             tree.insert(80);
             tree.duyetPostorder(tree.root);
         }
     }

