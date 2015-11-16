package tree;

public class PreTraversor implements TreeTraversor {

	@Override
	public void traverse(TreeRecord t) {
		if(t != null){
			visit(t);
			traverse(t.getLeft());
			traverse(t.getRight());
		}
	}
}
