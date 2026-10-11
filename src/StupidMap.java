import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StupidMap {
    private static final int CAPACITY = 8;
    private final List<Entity>[] buckets;

    @SuppressWarnings("unchecked")
    public StupidMap() {
        buckets = new List[CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    // pack any latin character into buckets
    private int indexOf(String key) {
        return Math.floorMod(Hash.hashCode(key), buckets.length);
    }

    public void put(Entity entity) {
        List<Entity> bucket = buckets[indexOf(entity.getKey())];
        for (Entity e : bucket) {
            if (Objects.equals(e.getKey(), entity.getKey())) {
                e.setValue(entity.getValue());
                return;
            }
        }
        bucket.add(entity);
    }

    public Entity get(String key) {
        for (Entity e : buckets[indexOf(key)]) {
            if (Objects.equals(e.getKey(), key)) {
                return e;
            }
        }
        return null;
    }

    public void prettyPrint() {
        List<String> rows = new ArrayList<>();
        int width = 0;
        for (List<Entity> bucket : buckets) {
            StringBuilder row = new StringBuilder();
            if (bucket.isEmpty()) {
                row.append("(empty)");
            }
            for (Entity e : bucket) {
                row.append("-> [").append(e).append("] ");
            }
            String text = row.toString().stripTrailing();
            rows.add(text);
            width = Math.max(width, text.length());
        }

        String border = "+-----+" + "-".repeat(width + 2) + "+";
        System.out.println(border);
        for (int i = 0; i < rows.size(); i++) {
            System.out.printf("| %3d | %-" + width + "s |%n", i, rows.get(i));
        }
        System.out.println(border);
    }
}


