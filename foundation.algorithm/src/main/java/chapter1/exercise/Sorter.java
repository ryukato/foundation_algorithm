package chapter1.exercise;

interface Sorter<E>{
	Comparable<E>[] sort(Comparable<E>[] input);
}