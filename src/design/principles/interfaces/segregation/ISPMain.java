package design.principles.interfaces.segregation;

public class ISPMain {
    public static void main(String[] args) {

        Tree tree = new BinarySearchTree();
        tree.insert();
        tree.delete();
        tree.traverse();

        RotationTree rotationTree = new BalancedTree();
        rotationTree.insert();
        rotationTree.delete();
        rotationTree.traverse();
        rotationTree.rightRotation();
        rotationTree.leftRotation();

    }
}
