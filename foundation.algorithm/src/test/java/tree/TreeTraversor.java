package tree;


public interface TreeTraversor {
	void traverse(TreeRecord t);
	default void visit(TreeRecord t){
		System.out.println(t.getId());
	}
	
}
