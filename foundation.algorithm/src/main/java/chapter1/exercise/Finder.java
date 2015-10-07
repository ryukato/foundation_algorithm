package chapter1.exercise;

@SuppressWarnings("rawtypes")
public interface Finder<E extends Comparable> {
	public E find(E[] input);
}
