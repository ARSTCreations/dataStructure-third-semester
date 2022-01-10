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

    public int queueSize() {
        Link current = first;
        int minSize = 0;
        while (current != null) {
            minSize++;
            current = current.next;
        }
        return minSize;
    }
}

public class Queue{
    FirstLastList theList;
    int antrianNow;

    public Queue(){
        theList=new FirstLastList();
    }
    public void enqueue(int j){
        theList.insertLast(j);
    }
    public int dequeue(){
        antrianNow = theList.deleteFirst();
        return antrianNow;
    }
    public int getAntrianNow(){
        return antrianNow;
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

    public int size() {
        return theList.queueSize();
    }


}
