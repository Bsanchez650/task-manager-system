package managers;
import data_structures.Graph;

public class GraphManager {

    private Graph graph;

    public GraphManager() {
        // initialize
        this.graph = new Graph();
    }

    public void addTask(int taskId) {
        // add node to graph
        graph.addNode(taskId);
    }

    public void addDependency(int fromId, int toId) {
        // add edge, but check for cycles after
        graph.addEdge(fromId, toId);
        if(graph.detectCycle()){
            System.out.println("Circular dependencies detected! Removing edge.");
            graph.removeEdge(fromId, toId);
        }
        
    }

    public void viewDependenciesDFS(int taskId) {
        // run DFS from task
          if(graph == null){
            return;
        }
        graph.dfs(taskId);
    }

    public void viewDependenciesBFS(int taskId) {
        // run BFS from task
        if(graph == null){
            return;
        }
        graph.bfs(taskId);
    }

    public boolean hasCycle() {
        // check for circular dependencies
        return graph.detectCycle();
    }
}