public class Hash {

    public static int hashCode(String key) {
        if (key == null || key.isEmpty()) {
            return -1;
        }
        try {
            String firstChar = String.valueOf(key.charAt(0)).toUpperCase();
            return HashCode.valueOf(firstChar).getBucket();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}
