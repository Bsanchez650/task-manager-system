package data_structures;
import java.util.*;

// Graph for task dependency management

public class Graph {

    // adjacency list: each task ID maps to a list of task IDs it depends on
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        // initialize the adjacency list
        adjList = new HashMap<>();
    }

    public void addNode(int taskId) {
        // add a task to the graph
        if(!adjList.containsKey(taskId)) {// adding task if it doesnt exist
            adjList.put(taskId, new ArrayList<>());
        }
    }

    public void addEdge(int fromId, int toId) {
        // add a dependency: fromId must be done before toId
        addNode(fromId);
        addNode(toId);

        adjList.get(fromId).add(toId);
    }

    public void dfs(int startId) {
        // depth-first traversal
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startId, visited);
    }

    private void dfsHelper(int taskId, Set<Integer> visited){
        if(visited.contains(taskId)){
            return;
        }

        visited.add(taskId);
        System.out.println("visited task: " + taskId);

        for(int neighbor : adjList.get(taskId)){
            dfsHelper(neighbor, visited);
        }
    }

    public void bfs(int startId) {
        // breadth-first traversal
        java.util.Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        visited.add(startId);
        queue.add(startId);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Visited task: " + current);

            for(int neighbor : adjList.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

    }

    

    public boolean detectCycle() {
        // return true if circular dependency exists
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inProgress = new HashSet<>();

        for(int taskId : adjList.keySet()){
            if(detectCycleHelper(taskId, visited, inProgress)){
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleHelper(int taskId, Set<Integer> visited, Set<Integer> inProgress){
        if(inProgress.contains(taskId)){
            return true;
        }
        if(visited.contains(taskId)){
            return false;
        }

        inProgress.add(taskId);

        for(int neighbor : adjList.get(taskId)){
            if(detectCycleHelper(neighbor, visited, inProgress)){
                return true;
            }
        }

        inProgress.remove(taskId);
        visited.add(taskId);
        return false;
    }

}