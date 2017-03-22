import java.util.HashMap;

/**
 * Created by Ilgiz on 21.11.2016.
 */
public class MatrixGraph<VertexType, EdgeWeight> {

    public class Vertex {
        VertexType key;
        int position;
        HashMap<Graph.Vertex, Graph.Edge> adj;

        public Vertex(VertexType key) {
            this.key = key;
            adj = new HashMap<Graph.Vertex, Graph.Edge>();
            position = vertices.length;
        }

        Graph.Edge addAdjacency(Graph.Vertex vertex, Graph.Edge edge) {
            return adj.put(vertex, edge);
        }
    }

    public class Edge {
        Graph.Vertex u;
        Graph.Vertex v;
        EdgeWeight weight;
        int position;

        public Edge(Graph.Vertex u, Graph.Vertex v, EdgeWeight weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
            position = edges.length;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Graph.Edge edge = (Graph.Edge) o;

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

    private Vertex[] vertices;
    private Edge[][] edges;
    private int size;

    public MatrixGraph(String[] vertices) {
        this.vertices = (Vertex[]) (new Object[vertices.length]);

        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = (new Vertex((VertexType) vertices[i]));
            this.vertices[i].position = i;
        }
        this.edges = (Edge[][]) new Object[vertices.length][vertices.length];

    }
}
