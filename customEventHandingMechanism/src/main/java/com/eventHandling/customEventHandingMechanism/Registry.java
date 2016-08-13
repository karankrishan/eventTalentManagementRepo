package com.eventHandling.customEventHandingMechanism;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KARAN KRISHAN
 *
 */
public class Registry {
	private static Map<Event, IHandler> hashMap = new HashMap<Event, IHandler>();

	public static <P, Q> void register(Event<P, Q> event, IHandler handler) {
		hashMap.put(event, handler);
	}

	public static <T, R> void fireEvent(Event<T, R> event) {
		IHandler iHandler = hashMap.get(event);
		iHandler.handle(event);
	}
}
