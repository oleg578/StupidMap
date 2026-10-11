void main() {
    StupidMap map = new StupidMap();

    System.out.println("=== empty map ===");
    map.prettyPrint();

    System.out.println("=== add entities to map ===");
    map.put(new Entity("Apple", "fruit"));
    map.put(new Entity("Berlin", "capital of Germany"));
    map.put(new Entity("Dortmund", "city in Germany"));
    map.put(new Entity("Dresden", "city on the Elbe"));
    map.put(new Entity("Hamburg", "port city"));
    map.put(new Entity("The Thing", "A mysterious entity"));
    map.prettyPrint();

    System.out.println("=== update existing key (Apple) ===");
    map.put(new Entity("Apple", "red or green fruit"));
    map.prettyPrint();

    System.out.println("=== get entity from map ===");
    System.out.println(map.get("Dresden"));

    System.out.println("=== get unknown entity from map ===");
    System.out.println(map.get("Unknown"));
}
