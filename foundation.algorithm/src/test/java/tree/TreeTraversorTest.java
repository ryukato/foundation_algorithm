package tree;

import org.junit.Test;

public class TreeTraversorTest {
	@Test
	public void test(){
		TreeRecord root = new TreeRecord("G");
		final TreeRecord leftChild1 = new TreeRecord("C");
		root.setLeft(leftChild1);
		
		leftChild1.setLeft(new TreeRecord("A"));
		leftChild1.setRight(new TreeRecord("E"));
		
		final TreeRecord rightChild1 = new TreeRecord("L");
		root.setRight(rightChild1);
		
		TreeTraversor preTraversor = new PreTraversor();
		preTraversor.traverse(root);
		
		System.out.println("======================================");
		
		TreeTraversor inOrderTraversor = new InOrderTraversor();
		inOrderTraversor.traverse(root);
		
		System.out.println("======================================");
		
		TreeTraversor postOrderTraversor = new PostOrderTraversor();
		postOrderTraversor.traverse(root);
		
		System.out.println("======================================");
		
		TreeTraversor levelOrderTraversor = new LevelOrderTraversor();
		levelOrderTraversor.traverse(root);
	}
}
