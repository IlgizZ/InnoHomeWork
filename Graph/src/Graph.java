import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ilgiz on 21.11.2016.
 */
public class Graph<VertexType, EdgeWeight extends Countable> {

    static long currentPosition = 0;
    static long edgePosition = 0;

    private VertexType prevSourse;
    private boolean isMst;

    public class Vertex {
        VertexType key;
        long position;
        HashMap<Vertex, Edge> adj;
        double distance;
        Vertex predecessor;
        boolean wasInQueue;

        public Vertex(VertexType key) {
            this.key = key;
            adj = new HashMap();
            position = currentPosition++;
            distance = Double.MAX_VALUE;
        }

        Edge addAdjacency(Vertex vertex, Edge edge) {
            return adj.put(vertex, edge);
        }

    }

    public class Edge {
        Vertex u;
        Vertex v;
        EdgeWeight weight;
        long position;

        public Edge(Vertex u, Vertex v, EdgeWeight weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
            position = edgePosition++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (u != null ? !u.equals(edge.u) : edge.u != null) return false;
            return v != null ? v.equals(edge.v) : edge.v == null;

        }

        @Override
        public int hashCode() {
            int result = u != null ? u.hashCode() : 0;
            result = 31 * result + (v != null ? v.hashCode() : 0);
            return result;
        }
    }

    private List<Vertex> vertices;
    private List<Edge> edges;
    private int size;

    public Graph(String[] vertices) {
        this.vertices = new ArrayList(vertices.length);

        for (int i = 0; i < vertices.length; i++) {
            this.vertices.add(i, new Vertex((VertexType) vertices[i]));
            this.vertices.get(i).position = i;
        }
        isMst = false;
        this.edges = new ArrayList();

    }

    private Vertex getVertex(VertexType v) {
        for (Vertex v1 : vertices) {
            if (v1.key.equals(v))
                return v1;
        }
        return null;
    }

    public Edge setEdge(VertexType from, VertexType to, EdgeWeight weight) {
        Vertex v = getVertex(from);
        Vertex u = getVertex(to);
        if (v == null)
            v = new Vertex(from);

        if (u == null)
            u = new Vertex(from);

        return setEdge(v, u, weight);
    }

    // min(deg(v), deg(w))
    public Edge setEdge(Vertex from, Vertex to, EdgeWeight weight) {
        Edge e = getEdge(from, to);

        if (e != null)
            e.weight = weight;
        else {
            Edge e1 = new Edge(from, to, weight);
            edges.add(e1);
            from.addAdjacency(to, e1);
            to.addAdjacency(from, e1);
        }

        return e;
    }

    // min(deg(v), deg(w))
    public void setEdgeBoth(Vertex from, Vertex to, EdgeWeight weight) {
        setEdge(from, to, weight);
        setEdge(to, from, weight);
    }

    // 1
    public Edge getEdge(Vertex from, Vertex to) {
        if (from.adj.size() < to.adj.size())
            return from.adj.get(to);
        else
            return to.adj.get(from);

    }

    public Edge removeEdge(Vertex from, Vertex to) {
        Edge e = getEdge(from, to);
        from.adj.remove(to);
        to.adj.remove(from);

        edges.remove(e);
        return e;
    }

    public boolean areAdjacent(Vertex from, Vertex to) {
        return getEdge(from, to) != null;
    }

    public List<Vertex> neighbours(Vertex v) {
        return new ArrayList(v.adj.keySet());
    }

    public Vertex get(int i) {
        return vertices.get(i);
    }

    public void clear() {
        vertices.forEach(vertex -> {
            vertex.adj.clear();
        });

        edges.clear();
        vertices.clear();
    }

    private void initSource(Vertex v) {
        vertices.forEach(vertex -> {
            vertex.distance = Double.MAX_VALUE;
            vertex.predecessor = null;
            vertex.wasInQueue = false;
        });
        v.distance = 0;
    }

    private void relax(Vertex u, Vertex v, double w) {
        if (v.distance > u.distance + w) {
            v.distance = u.distance + w;
            v.predecessor = u;
        }
    }

    private void dijekstra(Vertex s) {
        initSource(s);
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(vertices.size(), (o1, o2) -> {
            return Double.compare(o1.distance, o2.distance);
        });

        queue.add(s);
        s.wasInQueue = true;

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            u.adj.forEach((vertex, edge) -> {
                double w = 50 * edge.weight.getDistance() / edge.weight.getTime();
                relax(u, vertex, w);
                if (!vertex.wasInQueue)
                    queue.add(vertex);
            });
            u.wasInQueue = true;
        }

    }

    public String calculateLogistic(VertexType from, VertexType to, double weight) {
        Vertex s = getVertex(from);
        if (!from.equals(prevSourse))
            dijekstra(s);
        prevSourse = from;
        Vertex vTo = getVertex(to);
        double time = 0;
        double cost = 0;

        while (!vTo.equals(s)) {

            Edge e = getEdge(vTo.predecessor, vTo);
            time += e.weight.getTime();
            cost += e.weight.getCost();
            vTo = vTo.predecessor;

        }
        NumberFormat formatter = new DecimalFormat("#0.0");
        return from + " " + to + " " + formatter.format(weight) + " " + formatter.format(time) + " " + formatter.format(cost * weight);

    }

    public String calculateMaxFlow(VertexType from, VertexType to) {

        Vertex s = getVertex(from);
        Vertex vTo = getVertex(to);

        if (!from.equals(prevSourse)) {
            dijekstra(s);
        }

        prevSourse = from;
        double flow = Double.MAX_VALUE;

        int myConst = 50;

        while (!vTo.equals(s)) {
            Edge e = getEdge(vTo.predecessor, vTo);
            double currentFlow = myConst * e.weight.getDistance() / e.weight.getTime();
            flow = Double.min(flow, currentFlow);
            vTo = vTo.predecessor;
        }
        NumberFormat formatter = new DecimalFormat("#0.0");
        return from + " " + to + " " + Math.round(flow);

    }

    public void addVertex(String vertex) {
        vertices.add(new Vertex((VertexType) vertex));
    }

    public void removeVertex(Vertex vertex) {

        vertices.remove(vertex);
        vertex.adj.clear();
    }

    public String calculateMstLogistic(VertexType from, VertexType to, double weight) {
        if (!isMst)
            mst(from);
        return calculateLogistic(from, to, weight);
    }

    private void mst(VertexType from) {
        Vertex s = vertices.get(0);//getVertex(from);
        initSource(s);
        List<Edge> newEdgesList = new ArrayList();

        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(vertices.size(), (o1, o2) -> {
            return Double.compare(o1.distance, o2.distance);
        });

        queue.add(s);


        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            u.wasInQueue = true;

            u.adj.forEach((vertex, edge) -> {
                Edge e = getEdge(u, vertex);

                if (!vertex.wasInQueue && e.weight.getDistance() < vertex.distance) {

                    vertex.distance = e.weight.getDistance();
                    vertex.predecessor = u;

                    if (queue.contains(vertex)) {
                        queue.remove(vertex);
                    }
                    queue.add(vertex);
                }

            });
//            u.wasInQueue = true;
        }
        vertices.forEach(vertex -> {
            if (vertex.predecessor != null)
                newEdgesList.add(getEdge(vertex.predecessor, vertex));
        });

        edges = newEdgesList;
        changeVertexes();
        isMst = true;
    }

    private void changeVertexes() {
        vertices.forEach(vertex -> {
            vertex.adj = new HashMap();
            vertex.distance = 0;
            vertex.wasInQueue = false;
            vertex.predecessor = null;
        });

        edges.forEach(edge -> {
            Vertex u = edge.u;
            Vertex v = edge.v;
            v.adj.put(u, edge);
            u.adj.put(v, edge);
        });
    }

}
