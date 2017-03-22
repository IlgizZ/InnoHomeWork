import java.util.List;

/**
 * Created by Ilgiz on 22.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Graph<String, Distance> g = loadGraph();

        try {
            List<String> s = MyReaderWriter.read("input.txt");

            StringBuilder sb = new StringBuilder();

            for (String s1 : s) {
                String[] arr = s1.split(" ");
                String out = g.calculateMaxFlow(arr[0], arr[1]);
                sb.append(out);
                sb.append("\n");
            }

            MyReaderWriter.writeToFile("output.txt", sb.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Graph<String, Distance> loadGraph() {
        Graph<String, Distance> g = null;
        try {
            String[] s = MyReaderWriter.readRussia("russia.txt");
            g = new Graph(s[0].split(" "));
            s = s[1].split(" ");

            for (int i = 0; i < s.length; i++) {
                String v = s[i++];
                String u = s[i++];
                String[] d = s[i].split(":");

                double dist = Double.valueOf(d[0]);
                double time = Double.valueOf(d[1]);
                double cost = Double.valueOf(d[2]);

                g.setEdge(v, u, new Distance(dist, time, cost));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return g;
    }
}
