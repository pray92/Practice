package Utils;

/*
public class DoubleLinkedList {

    private int value;
    private DoubleLinkedList leftNode;
    private DoubleLinkedList rightNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLinkedList getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(DoubleLinkedList leftNode) {
        this.leftNode = leftNode;
    }

    public DoubleLinkedList getRightNode() {
        return rightNode;
    }

    public void setRightNode(DoubleLinkedList rightNode) {
        this.rightNode = rightNode;
    }


    public DoubleLinkedList(){
        value = 0;
        leftNode = null;
        rightNode = null;
    }
}
 */

public class BinarySearchTree {
    public enum OrderType { IN_ORDER, PRE_ORDER, POST_ORDER,}

    private DoubleLinkedList rootNode;

    public BinarySearchTree(){
        rootNode = null;
    }

    public void add(int value){
        if(rootNode == null){
            rootNode = new DoubleLinkedList();
            rootNode.setValue(value);
            return;
        }

        if(rootNode.getValue() >= value){
            if(null != rootNode.getLeftNode()) {
                add(rootNode.getLeftNode(), value);
            }
            else{
                rootNode.setLeftNode(new DoubleLinkedList());
                rootNode.getLeftNode().setParentNode(rootNode);
                rootNode.getLeftNode().setValue(value);
            }
        }else{
            if(null != rootNode.getRightNode()) {
                add(rootNode.getRightNode(), value);
            }
            else{
                rootNode.setRightNode(new DoubleLinkedList());
                rootNode.getRightNode().setParentNode(rootNode);
                rootNode.getRightNode().setValue(value);
            }
        }
    }

    private void add(DoubleLinkedList node, int value){
        if(null == node)
            return;

        if(node.getValue() >= value){
            if(null != node.getLeftNode()) {
                add(node.getLeftNode(), value);
            }
            else{
                node.setLeftNode(new DoubleLinkedList());
                node.getLeftNode().setParentNode(node);
                node.getLeftNode().setValue(value);
            }
        }else{
            if(null != node.getRightNode()) {
                add(node.getRightNode(), value);
            }
            else{
                node.setRightNode(new DoubleLinkedList());
                node.getRightNode().setParentNode(node);
                node.getRightNode().setValue(value);
            }
        }
    }

    /**
     * 전제
     * 1. 자식이 없는 노드 삭제        -> 단순 삭제 처리
     * 2. 자식이 하나만 있는 노드 삭제  -> 해당 노드가 속한 부모 노드의 자식 노드 위치에 해당 노드의 자식 노드 배치
     * 3. 자식이 둘 있는 노드 삭제     -> 1. 기준 노드를 정함
     *                             -> 1-1. 삭제 노드의 좌측 노드 중 제일 큰 노드
     *                             -> 1-2. 삭제 노드의 우측 노드 중 제일 작은 노드
     *                             -> 2.(두번째 기준 노드 기준)
     *                             -> 2-1. 기준 노드 최좌측에 삭제 노드의 좌측 노드 배치
     *                             -> 2-2. 기준 노드 최우측에 삭제 노드의 우측 노드 배치
     *                             -> 2-3. 기준 노드를 삭제 노드 위치에 배치(삭제 노드의 부모 위치)
     * @param value : 없애려는 값
     */
    public void delete(int value){
        DoubleLinkedList deleteNode = findNode(value);
        if(null == deleteNode)
            return;

        // 1. 자식이 없음
        if(deleteNode.getLeftNode() == null && deleteNode.getRightNode() == null){
            if(deleteNode == rootNode){
                rootNode = null;
                return;
            }

            var parentNode = deleteNode.getParentNode();
            if(deleteNode == parentNode.getLeftNode())
                parentNode.setLeftNode(null);
            else if(deleteNode == parentNode.getRightNode())
                parentNode.setRightNode(null);
            deleteNode.setParentNode(null);
        }
        // 2-1. 좌측에만 존재
        else if(deleteNode.getLeftNode() != null && deleteNode.getRightNode() == null){
            var leftNode= deleteNode.getLeftNode();
            if(deleteNode == rootNode){
                rootNode = leftNode;
            }else{
                var parentNode = deleteNode.getParentNode();
                if(deleteNode == parentNode.getLeftNode()){
                    parentNode.setLeftNode(leftNode);

                }
                else if(deleteNode == parentNode.getRightNode()){
                    parentNode.setRightNode(leftNode);
                }

                deleteNode.setParentNode(null);
                deleteNode.setLeftNode(null);
                deleteNode.setRightNode(null);
            }
        }
        // 2-2. 우측에만 존재
        else if(deleteNode.getLeftNode() == null && deleteNode.getRightNode() != null){
            var rightNode= deleteNode.getRightNode();
            if(deleteNode == rootNode){
                rootNode = deleteNode.getRightNode();
            }else{
                var parentNode = deleteNode.getParentNode();
                if(deleteNode == parentNode.getLeftNode()){
                    parentNode.setLeftNode(rightNode);

                }
                else if(deleteNode == parentNode.getRightNode()){
                    parentNode.setRightNode(rightNode);
                }

                deleteNode.setParentNode(null);
                deleteNode.setLeftNode(null);
                deleteNode.setRightNode(null);
            }
        }
        // 3. 자식이 두개 존재
        else{
            // 1. 기준 노드 -> 삭제 노드의 우측 자식 중 가장 작은 노드
            var minNode = deleteNode.getRightNode();
            while(null != minNode.getLeftNode())
                minNode = minNode.getLeftNode();

            if(null == minNode)
                return;

            // 2-1. 기준 노드 좌측에 삭제 노드의 좌측 노드 배치
            if(deleteNode.getLeftNode() != minNode){
                minNode.setLeftNode(deleteNode.getLeftNode());
            }
            // 2-2. 기준 노드 우측에 삭제 노드의 '최'우측 노드 배치
            if(deleteNode.getRightNode() != minNode){
                var minestNode = minNode;
                while(null != minestNode.getRightNode())
                    minestNode = minestNode.getRightNode();
                minestNode.setRightNode(deleteNode.getRightNode());
                // 삭제 노드 좌측 노드 삭제
                deleteNode.getRightNode().setLeftNode(null);
            }
            // 2-3. 기준 노드를 삭제 노드 위치에 배치(삭제 노드의 부모 위치)
            if(null != deleteNode.getParentNode()){
                var parentNode = deleteNode.getParentNode();
                if(deleteNode == parentNode.getLeftNode()){
                    parentNode.setLeftNode(minNode);
                }
                else if(deleteNode == parentNode.getRightNode()){
                    parentNode.setRightNode(minNode);
                }
            }

            deleteNode.setParentNode(null);
            deleteNode.setLeftNode(null);
            deleteNode.setRightNode(null);
        }

    }

    private DoubleLinkedList findNode(int value){
        if(rootNode.getValue() == value)
            return rootNode;

        DoubleLinkedList node = null;
        if(rootNode.getValue() > value){
            node = findNode(rootNode.getLeftNode(), value);
        }
        else if(rootNode.getValue() < value){
            node = findNode(rootNode.getRightNode(), value);
        }

        return node;
    }
    private DoubleLinkedList findNode(DoubleLinkedList node, int value){
        if(null == node)
            return null;

        DoubleLinkedList node2 = null;
        if(node.getValue() > value){
            node2 = findNode(node.getLeftNode(), value);
        }
        else if(node.getValue() < value){
            node2 = findNode(node.getRightNode(), value);
        }
        else{
            node2 = node;
        }
        return node2;
    }

    public void print(OrderType type){
        if(null == rootNode)
            return;

        switch (type){
            case IN_ORDER:{
                print(type, rootNode.getLeftNode());
                System.out.printf("%d ", rootNode.getValue());
                print(type, rootNode.getRightNode());
            } break;
            case PRE_ORDER:{
                System.out.printf("%d ", rootNode.getValue());
                print(type, rootNode.getLeftNode());
                print(type, rootNode.getRightNode());
            } break;
            case POST_ORDER:{
                print(type, rootNode.getLeftNode());
                print(type, rootNode.getRightNode());
                System.out.printf("%d ", rootNode.getValue());
            } break;
        }
        System.out.println();
    }

    private void print( OrderType type, DoubleLinkedList node){
        if(null == node)
            return;

        switch (type){
            case IN_ORDER:{
                print(type, node.getLeftNode());
                System.out.printf("%d ", node.getValue());
                print(type, node.getRightNode());
            } break;
            case PRE_ORDER:{
                System.out.printf("%d ", node.getValue());
                print(type, node.getLeftNode());
                print(type, node.getRightNode());
            } break;
            case POST_ORDER:{
                print(type, node.getLeftNode());
                print(type, node.getRightNode());
                System.out.printf("%d ", node.getValue());
            } break;
        }
    }

}
