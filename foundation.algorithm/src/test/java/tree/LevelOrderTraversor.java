package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversor implements TreeTraversor{

	@Override
	public void traverse(TreeRecord t) {
		Queue<TreeRecord> queue = new LinkedList<>();
		queue.add(t);
		while(!queue.isEmpty()){
			System.out.println("queue size : "+ queue.size());
			TreeRecord current = queue.poll();
			visit(current);
			if(current.getLeft() != null){
				queue.add(current.getLeft());
			}
			if(current.getRight() != null){
				queue.add(current.getRight());
			}
		}
	}
}
