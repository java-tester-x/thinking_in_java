package net.mindview.util;

import java.lang.reflect.*;
import java.util.*;

/**
 * RUN:
 *         javac net/mindview/util/ContainerMethodDifferences.java && java net.mindview.util.ContainerMethodDifferences
 * OUTPUT:
 *         Collection: [add, addAll, clear, contains, containsAll, equals, hashCode, isEmpty, 
 *         iterator, remove, removeAll, retainAll, size, toArray]
 *         Interfaces in Collection:
 *         [Iterable]
 *         Set extends Collection, adds:
 *         []
 *         Interfaces in Set:
 *         [Collection]
 *         HashSet extends Set, adds:
 *         []
 *         Interfaces in HashSet:
 *         [Set, Cloneable, Serializable]
 *         LinkedHashSet extends HashSet, adds:
 *         []
 *         Interfaces in LinkedHashSet:
 *         [Set, Cloneable, Serializable]
 *         TreeSet extends Set, adds:
 *         [lower, last, higher, descendingIterator, subSet, pollLast, comparator, 
 *         pollFirst, floor, headSet, ceiling, tailSet, first, descendingSet]
 *         Interfaces in TreeSet:
 *         [NavigableSet, Cloneable, Serializable]
 *         List extends Collection, adds:
 *         [get, set, listIterator, lastIndexOf, indexOf, subList]
 *         Interfaces in List:
 *         [Collection]
 *         ArrayList extends List, adds:
 *         [trimToSize, ensureCapacity]
 *         Interfaces in ArrayList:
 *         [List, RandomAccess, Cloneable, Serializable]
 *         Queue extends Collection, adds:
 *         [element, offer, poll, peek]
 *         Interfaces in Queue:
 *         [Collection]
 *         PriorityQueue extends Queue, adds:
 *         [comparator]
 *         Interfaces in PriorityQueue:
 *         [Serializable]
 *         Map: [clear, containsKey, containsValue, entrySet, equals, get, hashCode, 
 *         isEmpty, keySet, put, putAll, remove, size, values]
 *         HashMap extends Map, adds:
 *         []
 *         Interfaces in HashMap:
 *         [Map, Cloneable, Serializable]
 *         LinkedHashMap extends HashMap, adds:
 *         []
 *         Interfaces in LinkedHashMap:
 *         [Map]
 *         SortedMap extends Map, adds:
 *         [tailMap, firstKey, headMap, comparator, lastKey, subMap]
 *         Interfaces in SortedMap:
 *         [Map]
 *         TreeMap extends Map, adds:
 *         [pollLastEntry, firstKey, floorEntry, ceilingEntry, lowerEntry, lastEntry,
 *          subMap, tailMap, navigableKeySet, higherEntry, lowerKey, headMap, 
 *          firstEntry, comparator, descendingKeySet, descendingMap, pollFirstEntry,
 *          lastKey, higherKey, floorKey, ceilingKey]
 *         Interfaces in TreeMap:
 *         [NavigableMap, Cloneable, Serializable]
 */

public class ContainerMethodDifferences {
    
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<String>();
        for (Method m : type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<String>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static { object.add("clone"); }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);

        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}