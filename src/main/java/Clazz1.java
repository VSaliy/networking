import java.util.*;

public class Clazz1 {
    Map<Long, Long> atmStorage = new HashMap<>();

    public Map<Long, Long> getAtmStorage() {
        return atmStorage;
    }

    public void setAtmStorage(Map<Long, Long> atmStorage) {
        this.atmStorage = atmStorage;
    }

    public List withdraw(Long amount) {
        List<Long> denominations = new ArrayList<>(atmStorage.keySet());
        Collections.sort(denominations, new Comparator<Long>() {

            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });

        for(Long denomination : denominations) {
            long l = amount / denomination;
            System.out.println(l);
            if (l <= 0)
                continue;
            Long aLong = atmStorage.get(denomination);
            if(aLong - l > 0) {
                aLong = aLong - l;
            }
        }

        System.out.println(amount / 100L);


        return null;
    }


    public static void main(String[] args) {
        Clazz1 clazz1 = new Clazz1();
        Map<Long, Long> atmStorage = clazz1.getAtmStorage();
        atmStorage.put(2L, 25L);
        atmStorage.put(5L, 25L);
        atmStorage.put(20L, 25L);
        atmStorage.put(10L, 25L);
        atmStorage.put(100L, 25L);

        clazz1.withdraw(37L);


    }



}