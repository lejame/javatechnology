package org.example;
import java.util.*;
public interface Repository <T, K>{
	public K add(T item);
	public List<T> readAll();
	public T read(K id);
	public boolean update(T item);
	public boolean delete(K id);

}
