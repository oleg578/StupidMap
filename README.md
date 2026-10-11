# StupidMap

A deliberately naive hash map in Java, written for learning. Keys are strings, and the hash function is just the **first letter of the key**.

## How it works

- `StupidMap` keeps a fixed array of 8 buckets, each an `ArrayList<Entity>` (separate chaining).
- `Hash.hashCode(key)` maps the first character to a letter index through the `HashCode` enum (`A`=0 … `Z`=25). Case is ignored.
- The bucket is `floorMod(hash, 8)`, so letters share buckets (`A`, `I`, `Q`, `Y` → bucket 0).
- Keys that are empty, `null`, or start with a non-Latin letter hash to `-1`, which lands in bucket 7.
- `put` replaces the value if the key already exists. Otherwise it appends to the bucket.
- The map never resizes. Keys with the same first letter always collide.

## Files

| File | Purpose |
|------|---------|
| `src/StupidMap.java` | The map: `put`, `get`, `prettyPrint` |
| `src/Entity.java` | Key/value pair |
| `src/Hash.java` | First-letter hash function |
| `src/HashCode.java` | Enum of letter → index |
| `src/Main.java` | Demo |

## Usage

```java
StupidMap map = new StupidMap();
map.put(new Entity("Apple", "fruit"));
map.put(new Entity("Berlin", "capital of Germany"));

map.get("Apple");    // Apple: fruit
map.get("Unknown");  // null
map.prettyPrint();   // draws the buckets as a table
```

## Run

`Main.java` uses an instance `main()` method, which needs a recent JDK (instance main methods are a preview feature in Java 21/22 and final in Java 25).

```sh
cd src
javac *.java        # add --enable-preview --release 21 on JDK 21–24
java Main           # add --enable-preview on JDK 21–24
```

## Limitations

**This is a stupid implementation of the map for demonstration only :)**