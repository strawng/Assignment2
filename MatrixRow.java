//Author: Huakai Zeng
//Date: 28th July 2019
//Description: Assignment 2 MatrixRow class draft




public class MatrixRow {



    //head of this row, HEAD is the FIRST ValueNode

    private ValueNode head;

    // the next row of this row (think of this as the next row's number). this attributes will be utilized in sparsematrix
    private int nextRow;



    //constructor
    public MatrixRow(){

    }


    //this allows you to set the NEXT row of this
    public void setNextRow(int nextRow) {
        this.nextRow = nextRow;
    }

    //get the next row of THIS row
    public int getNextRow(){
        return nextRow;
    }






    //bool for isempty
    public boolean isEmpty(){
        if (head == null){
            return true;

        }else{
            return false;
        }
    }




    //insert a ValueNode at the back
    public void insertBackValueNode(int val){
        ValueNode node = new ValueNode(val);


        if (isEmpty()) {

            head = node;


        }else{
            ValueNode cur = head;

            while(cur.getNextValueNodeRow() != null){
                cur = cur.getNextValueNodeRow();



            }


            cur.setNextValueNodeRow(node);
        }

    }




    //insert valueNode from the front

    public void insertFrontValueNode(int val){

        ValueNode node = new ValueNode(val);

        node.setNextValueNodeRow(head);

        head = node;

    }

    //get a value stored at specifix position

    public int getElementRow(int index){


        //cur = head
        ValueNode cur  = head;

        //test for out of bounds

        for(int i = 0; i < index; i++){
            if(cur == null){

                //throw new when you want to display error and print stuff
                throw new IndexOutOfBoundsException("the index you entered is out of bound");
            }
            //update cur to successor
            cur = cur.getNextValueNodeRow();

        }
        return cur.getValue();
    }


    //print method to test

    public void print() {


        ValueNode cur = head;



        while (cur != null) {

            System.out.printf("%d", cur.getValue());
            cur = cur.getNextValueNodeRow();


        }

        System.out.println();


    }

    //additional methods removeFront, removeBack



    //remove element from row from the front.

    public void removeFront(){
        ValueNode cur = head;

        if(cur == null){
            throw new IndexOutOfBoundsException("there is no element in this linkedList to be removed");
        }else{
            head = head.getNextValueNodeRow();
        }

    }


    //remove element from the back
    public void removeBack(){


        ValueNode cur = head;


        if(head != null){


            if(head.getNextValueNodeRow() == null ){

                head = null;



            }else{

                cur = head.getNextValueNodeRow();

                while(cur.getNextValueNodeRow().getNextValueNodeRow() != null) {

                    cur = cur.getNextValueNodeRow();
                }

                cur.setNextValueNodeRow(null);
            }
        }else{


            throw new NullPointerException("The head is null");
        }
    }

}
