package com.eventHandling.customEventHandingMechanism;

/**
 * @author KARAN KRISHAN
 *
 * @param <E>
 * @param <V>
 */
public class Event<E, V> {
	E callback;
	V dataModel;
	private int coconutCount;

	public Event(E callback, V dataModel) {
		coconutCount++;
		this.callback = callback;
		this.dataModel = dataModel;
	}

	public E getCallback() {
		return callback;
	}

	public V getDataModel() {
		return dataModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coconutCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (coconutCount != other.coconutCount)
			return false;
		return true;
	}

}
