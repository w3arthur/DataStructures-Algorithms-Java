package b2_avltree;

public class Main {

	public static void main(String[] args) {
		System.out.println("avl tree");
		
		Tree tree = new Tree();
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);
		tree.insert(9);
		tree.insert(8);
		tree.insert(7);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(40);
		
		System.out.println("-"); 
		System.out.println(tree);
		System.out.println(tree.isBalanced());
		Tree tree3 = new Tree();
		System.out.println(tree3.isBalanced());
		System.out.println(tree.isPerfect());
	}

}
