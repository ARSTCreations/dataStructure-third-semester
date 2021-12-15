package com.tbqueuenasabah.tbqueuenasabah;

class Link{
    int dData;
    Link next;
    public Link(int d){
        dData=d;
    }
    public int displayLinkReturn(){
        return dData;
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


    public String displayHead(){
        Link current=first;
        if(current!=null) return String.valueOf(current.displayLinkReturn());
        else return "Kosong!";
    }

    public String displayLast(){
        Link current=last;
        if(current!=null) return String.valueOf(current.displayLinkReturn());
        else return "Kosong!";
    }

    public int queueSize(){
        Link current = first;
        int sizeNya=0;
        while (current!=null) {
            sizeNya++;
            current=current.next;
        }
        return sizeNya;
    }
}

public class Queue{
    FirstLastList theList;
    public Queue(){
        theList=new FirstLastList();
    }
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    public void enqueue(int j){
        theList.insertLast(j);
    }
    public int dequeue(){
        return theList.deleteFirst();
    }
    public String peek(){
        return theList.displayHead();
    }
    public String peekNext(){
        return theList.displayLast();
    }
    public int size(){
        return theList.queueSize();
    }

    boolean gantian = true;
    public boolean isGantian() {
        return gantian;
    }
    public void toggleGantian() {
        if (isGantian()) gantian = false;
        else gantian = true;
    }


    int antrianKe = 0;
    public void setAntrianKe(int antrianKe) {
        this.antrianKe = antrianKe;
    }
    public void incrementAntrianKe() {
        antrianKe++;
    }
    public int getAntrianKe() {
        return antrianKe;
    }
}
