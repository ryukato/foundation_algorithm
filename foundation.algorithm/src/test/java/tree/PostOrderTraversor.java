package tree;

public class PostOrderTraversor implements TreeTraversor {

	@Override
	public void traverse(TreeRecord t) {
		if(t != null){
			traverse(t.getLeft());
			traverse(t.getRight());
			visit(t);
		}
	}
}
