import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ilgiz on 27.09.2016.
 */
public class Counter implements Runnable {
    private Thread thread;
    private int startLine;
    private int endLine;
    private boolean end;

    public Counter(int startLine, int endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
        thread = new Thread(this);
        thread.start();
    }

    private MyHashTable<String, Node> mergeTables(List<MyHashTable<String, Node>> tables) {
        synchronized (WordCounter.getResultTable()) {

            int capacity = 0;

            for (MyHashTable<String, Node> table : tables) {
                capacity += table.size();
            }

            MyHashTable<String, Node> resultTable = WordCounter.getResultTable();

            if (resultTable.size() != 0) {
                tables.add(resultTable);
                capacity += resultTable.size();
            }

            resultTable = new MyHashTable<>(capacity);

            for (MyHashTable<String, Node> table : tables) {
                Iterator it = table.iterator();

                while (it.hasNext()) {

                    Node node = (Node) it.next();
                    String key = node.getWord();
                    Integer count = node.getCount();
                    Node oldValue = resultTable.put(key, node);

                    if (oldValue != null) {
                        oldValue.incCountTo(count);
                        resultTable.put(key, oldValue);
                    }

                }
            }

            WordCounter.setResultTable(resultTable);
            return resultTable;
        }
    }

    private List<MyHashTable<String, Node>> separateToHashTables() {
        int length = endLine - startLine + 1;
        List<MyHashTable<String, Node>> tables = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String[] words = parseWords(WordCounter.getLines()[i + startLine]);
            tables.add(generateHashTable(words));
        }

        return tables;
    }

    private MyHashTable<String, Node> generateHashTable(String[] words) {
        MyHashTable<String, Node> table = new MyHashTable<>(words.length);

        for (String word : words) {
            if (word.equals(""))
                continue;
            Node node = new Node(word, 1);
            Node value = table.put(word, node);

            if (value != null) {
                value.incCountTo(1);
                table.put(word, value);
            }
        }

        return table;
    }

    private String[] parseWords(String line) {
        String[] words = line.split(" ");

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < WordCounter.PUNCTUATION_MARKS.length; j++) {

                if (words[i].indexOf(WordCounter.PUNCTUATION_MARKS[j]) != -1) {

                    if (WordCounter.PUNCTUATION_MARKS[j].equals("-") && words[i].length() != 1) {
                        continue;
                    }

                    int end = words[i].indexOf(WordCounter.PUNCTUATION_MARKS[j]);
                    words[i] = words[i].substring(0, end);

                    break;
                }
            }

            words[i] = words[i].toLowerCase();
        }

        return words;
    }

    public void generateResultTable() {
        List<MyHashTable<String, Node>> tables = separateToHashTables();
        mergeTables(tables);
    }

    public boolean isEnd() {
        return end;
    }

    @Override
    public void run() {
        generateResultTable();
        end = true;
    }
}
