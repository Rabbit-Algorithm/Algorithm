package _1주차.바이러스;

import java.io.*;
import java.util.*;

public class Main_이태균 {

    private static int COMPUTER_SIZE;
    private static int CONNECTED_COMPUTER_SIZE;
    private static Map<Integer, Computer> computerMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        COMPUTER_SIZE = Integer.parseInt(br.readLine());
        CONNECTED_COMPUTER_SIZE = Integer.parseInt(br.readLine());

        for (int i = 1; i <= COMPUTER_SIZE; i++) {
            computerMap.put(i, new Computer(i));
        }

        for (int i = 0; i < CONNECTED_COMPUTER_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Computer compA = computerMap.get(a);
            Computer compB = computerMap.get(b);

            compA.connect(compB);
            compB.connect(compA);
        }

        int infectedCount = bfs(computerMap.get(1));
        System.out.println(infectedCount - 1);
    }

    private static int bfs(Computer start) {
        Queue<Computer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start.id);
        start.isInfected = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Computer current = queue.poll();

            for (Computer neighbor : current.connections) {
                if (!visited.contains(neighbor.id)) {
                    visited.add(neighbor.id);
                    neighbor.isInfected = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count;
    }

    static class Computer {
        int id;
        boolean isInfected;
        List<Computer> connections = new ArrayList<>();

        public Computer(int id) {
            this.id = id;
        }

        public void connect(Computer other) {
            connections.add(other);
        }
    }
}