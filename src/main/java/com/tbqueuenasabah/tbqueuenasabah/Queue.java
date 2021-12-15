package com.tbqueuenasabah.tbqueuenasabah;

class Link{
    int dData;
    Link next;
    public Link(int d){
        dData=d;
    }
}

class FirstLastList{
    Link first;
    Link last;

    public FirstLastList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertLast(int dd){
        Link newLink = new Link(dd);
        if(isEmpty())first=newLink;
        else last.next=newLink;
        last=newLink;
    }

    public int deleteFirst(){
        if (first.next==null) last=null;
        int returnVal = first.dData;
        first=first.next;
        return returnVal;
    }
}

public class Queue{
    FirstLastList theList;
    public Queue(){
        theList=new FirstLastList();
    }
    public void enqueue(int j){
        theList.insertLast(j);
    }
    public int dequeue(){
        return theList.deleteFirst();
    }

    boolean gantian = true;
    public boolean isGantian() {
        return gantian;
    }
    public void toggleGantian() {
        gantian = !isGantian();
    }

    int antrianKe = 0;
    public void incrementAntrianKe() {
        antrianKe++;
    }
    public int getAntrianKe() {
        return antrianKe;
    }
}
