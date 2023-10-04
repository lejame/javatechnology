package Repository;

import java.util.List;

public interface Repository <E>{
	boolean add(E e);
	E get(String id);
	List<E> getAll();
	boolean remove(String id);
	boolean remove(E e);
	boolean update(E e);
}
