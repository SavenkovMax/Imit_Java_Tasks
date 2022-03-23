package Sixth;

import java.util.*;

public final class CollectionsDemo {

    private CollectionsDemo() {}

    public static int countStrings(List<String> strings, char symbol) {
        if (strings == null) {
            throw new IllegalArgumentException("The list is null");
        }
        int n = 0;
        for (String item : strings)  {
            if (item == null) {
                continue;
            }
            if (item.charAt(0) == symbol) {
                n++;
            }
        }
        return n;
    }

    public static List<Human> listOfNamesakes(List<Human> list, Human human) {
        if (list == null) {
            throw new IllegalArgumentException("The list is null");
        }
        if (human == null) {
            throw new IllegalArgumentException("The human is null");
        }
        ArrayList<Human> namesakes = new ArrayList<>(list.size());
        for (Human item : list) {
            if (item == null) {
                throw new IllegalArgumentException("Some of the humans in the list are null");
            }
            if (item.getSurname().equals(human.getSurname())) {
                namesakes.add(item);
            }
        }
        return namesakes;
    }

    public static List<Human> listWithoutPerson(List<Human> list, Human human) {
        if (list == null) {
            throw new IllegalArgumentException("The list is null");
        }
        if (human == null) {
            throw new IllegalArgumentException("The human is null");
        }
        ArrayList<Human> listHuman = new ArrayList<>(list.size());
        for (Human item : list) {
            if (item == null) {
                throw new IllegalArgumentException("Some of the humans in the list are null");
            }
            if (!item.equals(human)) {
                listHuman.add(item);
            }
        }
        return listHuman;
    }


    public static List<Set<Integer>> listWithoutIntersection(List<Set<Integer>> list, Set<Integer> set) {
        if (list == null ) {
            throw new IllegalArgumentException("The list is null");
        }
        if (set == null) {
            throw new IllegalArgumentException("The set is null");
        }
        boolean integerContains = false;
        ArrayList<Set<Integer>> resultList = new ArrayList<>(list.size());
        for (Set<Integer> item: list) {
            if (item == null) {
                throw new IllegalArgumentException("Some of the sets of the integers are null");
            }
            for (Integer data: item) {
                if (set.contains(data)) {
                    integerContains = true;
                    break;
                }
            }
            if (!integerContains) {
                resultList.add(item);
            }
            integerContains = false;
        }
        return resultList;
    }

    public static Set<Human> setOfMaxAge(List<Human> list) {
        if (list == null) {
            throw new IllegalArgumentException("The list is null");
        }
        int maxAge = 0;
        HashSet<Human> set = new HashSet<>(list.size());
        for (Human item: list){
            if (item == null) {
                throw new IllegalArgumentException("Some of the humans in the list are null");
            }
            if (item.getAge() > maxAge) {
                maxAge = item.getAge();
                set.clear();
                set.add(item);
            }
            if (item.getAge() == maxAge) {
                set.add(item);
            }
        }
        return set;
    }

    public static Set<Human> setWithIdentifiers(Map<Integer, Human> map, Set<Integer> set) {
        if (map == null) {
            throw new IllegalArgumentException("The map is null");
        }
        if (set == null) {
            throw new IllegalArgumentException("The set is null");
        }
        HashSet<Human> humans = new HashSet<>(set.size());
        for (Integer item: set) {
            if (item == null) {
                throw new IllegalArgumentException("Some of the integers are null");
            }
            if (map.containsKey(item)) {
                humans.add(map.get(item));
            }
        }
        return humans;
    }

    public static List<Human> listMajorAge(Map<Integer, Human> map) {
        if (map == null) {
            throw new IllegalArgumentException("The map is null");
        }
        ArrayList<Human> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Human> entry: map.entrySet()) {
            if (entry.getValue() == null) {
                throw new IllegalArgumentException("Some of the humans in the map are null");
            }
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("Some of the integers in the map are null");
            }
            if (entry.getValue().getAge() >= 18) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public static Map<Integer, Integer> ageMap(Map<Integer, Human> map) {
        if (map == null) {
            throw new IllegalArgumentException("The map is null");
        }
        HashMap<Integer, Integer> ageMapping = new HashMap<>(map.size());
        for (Integer item: map.keySet()) {
            if (item == null) {
                throw new IllegalArgumentException("Some of the integers are null");
            }
            ageMapping.put(item, map.get(item).getAge());
        }
        return ageMapping;
    }

    public static Map<Integer, ArrayList<Human>> ageMatchingList(Set<Human> set) {
        if (set == null) {
            throw new IllegalArgumentException("The set is null");
        }
        HashMap<Integer, ArrayList<Human>> ageMapping = new HashMap<>(set.size());
        for (Human item: set) {
            ArrayList<Human> list = new ArrayList<>();
            for (Human data : set) {
                if (data.getAge() == item.getAge()) {
                    list.add(data);
                }
            }
            ageMapping.put(item.getAge(), list);
        }
        return ageMapping;
    }

    public static List<? extends Human> listOfHumans(Set<? extends Human> set) {
        TreeSet<? extends Human> humans = new TreeSet<>(set);
        return new ArrayList<>(humans);
    }

    public static Map<Integer, Map<Character, List<Human>>> ageLetterMap(Set<Human> set) {

        return null;
    }
}

