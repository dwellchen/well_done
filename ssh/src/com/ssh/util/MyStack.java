package com.ssh.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object[] elements;
	
	private static final int DEFAULT_SIZE = 16;
	
	private int size = 0;
		
	public MyStack(){
		this.elements = new Object[DEFAULT_SIZE];
	}
	
	public void add(E e){
		ensureCapcity();
		elements[size++] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E pop(){
        if (size == 0)
            throw new EmptyStackException();
        E e = (E) elements[size--];
        elements[size] = null; //Eliminate obsolete reference
		return e;
	}
	
	private void ensureCapcity(){
		if(elements.length==size){
			this.elements = Arrays.copyOf(elements, 2*size+1);
		}
	}
	
	 private void writeObject(java.io.ObjectOutputStream s)
	            throws java.io.IOException {
	        final java.io.ObjectOutputStream.PutField fields = s.putFields();
	        final Object[] data;
	        synchronized (this) {
	            fields.put("size", size);
	            data = elements.clone();
	        }
	        fields.put("elements", data);
	        s.writeFields();
	    }
}
