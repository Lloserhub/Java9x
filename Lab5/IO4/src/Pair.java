import java.util.Objects;

public class Pair {
    public String tag;
    public int freq;

    public Pair(String tag, int freq) {
        this.tag = tag;
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(tag, pair.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }
}
