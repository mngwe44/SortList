import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int index = findInsertPosition(value);
        list.add(index, value);
    }

    public int findInsertPosition(String value) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0) {
                return mid; // Already exists
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // Position to insert
    }

    public int search(String value) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -low - 1; // Not found, return insertion point as -index-1
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return String.join("\n", list);
    }
}
