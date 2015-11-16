package tree;

public class TreeRecord {
	private final String id;
	private TreeRecord left;
	private TreeRecord right;
	
	public TreeRecord(String id){
		this(id, null, null);
	}
	public TreeRecord(String id, TreeRecord left, TreeRecord right) {
		super();
		this.id = id;
		this.left = left;
		this.right = right;
	}
	public TreeRecord getLeft() {
		return left;
	}
	public void setLeft(TreeRecord left) {
		this.left = left;
	}
	public TreeRecord getRight() {
		return right;
	}
	public void setRight(TreeRecord right) {
		this.right = right;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeRecord [id=").append(id).append(", left=")
				.append(left).append(", right=").append(right).append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TreeRecord))
			return false;
		TreeRecord other = (TreeRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
}
