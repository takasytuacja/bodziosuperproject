package pl.bodzio.superproject.service.binarytree;

public class BinaryTree {

	Node root;

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}
}
