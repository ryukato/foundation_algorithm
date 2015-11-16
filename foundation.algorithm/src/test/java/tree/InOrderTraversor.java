package tree;

public class InOrderTraversor implements TreeTraversor{

	@Override
	public void traverse(TreeRecord t) {
		if(t != null){
			traverse(t.getLeft());
			visit(t);
			traverse(t.getRight());
		}
	}

}
