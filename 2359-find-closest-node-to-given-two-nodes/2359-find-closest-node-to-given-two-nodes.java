class Node {
    int id;
    int dest;
    boolean visit1 = false;
    boolean visit2 = false;

    Node(int id, int dest) {
        this.id = id;
        this.dest = dest;
    }
}

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int num = edges.length;
        Node[] graph = new Node[num];
        int result = -1;
        int[] vt1 = new int[num];
        int[] vt2 = new int[num];

        for (int i = 0; i < num; i++) {
            graph[i] = new Node(i, edges[i]);
        }

        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(node1);

        int vt = 0;
        while(!q1.isEmpty()) {
            int id = q1.poll();
            Node curr = graph[id];
            if (curr.visit1 == true) continue;
            curr.visit1 = true;
            vt1[id] = vt++;
            System.out.println("visit 1: " + curr.id);

            if (curr.dest >= 0)
            q1.offer(curr.dest);
        }

        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(node2);

        while(!q2.isEmpty()) {
            int id = q2.poll();
            Node curr = graph[id];
            if (curr.visit2 == true) continue;
            curr.visit2 = true;
            System.out.println("visit 2: " + curr.id);

            if (curr.visit1 == true) { 
                result = id;
                break;
            }

            if (curr.dest >= 0)
            q2.offer(curr.dest);
        }

        for (Node node: graph) {
            node.visit1 = false;
            node.visit2 = false;
        }

        q1 = new LinkedList<>();
        q1.offer(node2);
        vt = 0;

        while(!q1.isEmpty()) {
            int id = q1.poll();
            Node curr = graph[id];
            if (curr.visit1 == true) continue;
            curr.visit1 = true;
            vt2[id] = vt++;
            System.out.println("visit 1: " + curr.id);

            if (curr.dest >= 0)
            q1.offer(curr.dest);
        }

        q2 = new LinkedList<>();
        q2.offer(node1);

        while(!q2.isEmpty()) {
            int id = q2.poll();
            Node curr = graph[id];
            if (curr.visit2 == true) continue;
            curr.visit2 = true;
            System.out.println("visit 2: " + curr.id);

            if (curr.visit1 == true) { 
                if (result >= 0) {
                    System.out.println( vt1[result] + " | " + vt2[id]);
                    if ( vt1[result] > vt2[id] ) result = id;
                    else if ( vt1[result] == vt2[id] ) result = Math.min(id, result);
                } else {
                    result = id;
                }
                break;
            }

            if (curr.dest >= 0)
            q2.offer(curr.dest);
        }

        return result;
    }
}