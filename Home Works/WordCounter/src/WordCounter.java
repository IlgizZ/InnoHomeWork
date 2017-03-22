import java.util.Iterator;

/**
 * Created by Ilgiz on 26.09.2016.
 */
public class WordCounter {

    private static MyHashTable<String, Node> resultTable;
    private static String[] lines;
    public static final String[] PUNCTUATION_MARKS = new String[]{".", ",", "?", "!", "'", ";", ":", "-"};
    public static final String[] EXCLUDE_WORDS = new String[]{"a", "the", "in", "at",
            "to", "on", "not", "for", "'s", "'d", "'re", "is", "are", "am", "has", "i", "we", "you"};

    public WordCounter(String[] lines) {
        this.lines = lines;
        resultTable = new MyHashTable<>(0);
    }

    public static void setResultTable(MyHashTable<String, Node> resultTable) {
        WordCounter.resultTable = resultTable;
    }

    public String getMaxString() {

        Counter counter1 = new Counter(0, lines.length / 2);
        Counter counter2 = new Counter(lines.length / 2 + 1, lines.length - 1);

        while (true) {
            if (counter1.isEnd() && counter2.isEnd())
                break;
        }

        deleteExcludeWords(resultTable);

        Iterator it = resultTable.iterator();

        if (!it.hasNext()) {
            return "Text hasn't word :(";
        }

        Node maxNode = (Node) it.next();

        while (it.hasNext()) {
            Node node = (Node) it.next();
            if (node.getCount() > maxNode.getCount()) {
                maxNode = node;
            }
        }

        return maxNode.getWord() + " " + maxNode.getCount();
    }

    private void deleteExcludeWords(MyHashTable<String, Node> resultTable) {
        for (String excludeWord : WordCounter.EXCLUDE_WORDS) {
            resultTable.remove(excludeWord);
        }
    }

    public static String[] getLines() {
        return lines;
    }

    public static MyHashTable<String, Node> getResultTable() {
        return resultTable;
    }
}
