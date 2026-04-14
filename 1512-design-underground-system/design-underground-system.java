import java.util.*;

class UndergroundSystem {

    Map<Integer, Object[]> checkIn = new HashMap<>();
    Map<String, int[]> map = new HashMap<>();

    public UndergroundSystem() {}
    
    public void checkIn(int id, String station, int t) {
        checkIn.put(id, new Object[]{station, t});
    }
    
    public void checkOut(int id, String station, int t) {
        Object[] data = checkIn.get(id);
        String start = (String) data[0];
        int time = (int) data[1];
        checkIn.remove(id);

        String key = start + "-" + station;
        map.putIfAbsent(key, new int[2]);

        map.get(key)[0] += (t - time);
        map.get(key)[1]++;
    }
    
    public double getAverageTime(String start, String end) {
        int[] d = map.get(start + "-" + end);
        return (double) d[0] / d[1];
    }
}