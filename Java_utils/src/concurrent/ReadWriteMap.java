package concurrent;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> implements Map<K, V>{
	private final Map<K, V> map;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();
	
	public ReadWriteMap(Map<K, V> map) {
		this.map = map;
	}


	@Override
	public int size() {
		r.lock();
		try {
			return map.size();
		} finally {
			r.unlock();

		}
	}

	@Override
	public boolean isEmpty() {
		r.lock();
		try {
			return map.isEmpty();
		} finally {
			r.unlock();

		}
	}

	@Override
	public boolean containsKey(Object key) {
		r.lock();
		try {
			return map.containsKey(key);
		} finally {
			r.unlock();

		}
	}

	@Override
	public boolean containsValue(Object value) {
		r.lock();
		try {
			return map.containsValue(value);
		} finally {
			r.unlock();

		}
	}

	@Override
	public V get(Object key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();

		}
	}

	@Override
	public V put(K key, V value) {
		w.lock();
		try {
			return this.map.put(key, value);
		} finally {
			w.unlock();
		}
	}

	@Override
	public V remove(Object key) {
		w.lock();
		try {
			return this.map.remove(key);
		} finally {
			w.unlock();
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		w.lock();
		try {
			this.map.putAll(m);
		} finally {
			w.unlock();
		}
		
	}

	@Override
	public void clear() {
		w.lock();
		try {
			this.map.clear();
		} finally {
			w.unlock();
		}
	}

	@Override
	public Set<K> keySet() {
		r.lock();
		try {
			return map.keySet();
		} finally {
			r.unlock();

		}
	}

	@Override
	public Collection<V> values() {
		r.lock();
		try {
			return map.values();
		} finally {
			r.unlock();

		}
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		r.lock();
		try {
			return map.entrySet();
		} finally {
			r.unlock();

		}
	}
	
}
