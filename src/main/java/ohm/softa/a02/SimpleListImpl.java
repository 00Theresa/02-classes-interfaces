package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

	// TODO: Implement the required methods.
    private int size;

    protected Element head;

   public SimpleListImpl(){
       this.head = head;
       //size++;
   }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }

    private static class Element {
        protected Object item;
        protected Element next;

        private Element(Object inhalt) {
            item = inhalt;
            this.next = null;

        }
        public Object getItem(){
            return this.item;
        }

        public Element getNext(){
            return this.next;
        }

        public void setNext(Element next){
            this.next = next;
        }

    }

    private class SimpleIteratorImpl implements Iterator {

       private Element current = head;
       @Override
        public boolean hasNext() {
           if (current != null) return true;
           else return false;
        }

        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    @Override
    public void add(Object o) {
        if (this.head == null){
            this.head = new Element(o);
        } else {
            Element current = this.head;
            while (current.getNext() != null){
                //beim aktuellen item naechste referenz
                current = current.getNext();
            }
            current.setNext(new Element(o));
        }
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList toReturn = new SimpleListImpl();

        for (Object o : this){
            if (filter.include(o)){
                toReturn.add(o);
            }
        }

        return toReturn;
    }

    //SimpleList inst1 = new SimpleListImpl();


}
