package util;

public class ComparableUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <E extends Comparable> boolean equals(E e1, E e2) {
		return e1.compareTo(e2) == 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <E extends Comparable> boolean less(E e1, E e2) {
		return e1.compareTo(e2) < 0;
	}
}
