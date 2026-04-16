import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: column -> list of (row, value)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> nodes : map.values()) {
            // Sort by row, then value
            Collections.sort(nodes, (a, b) -> 
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
            );
            List<Integer> col = new ArrayList<>();
            for (int[] node : nodes) col.add(node[1]);
            result.add(col);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col, TreeMap<Integer, List<int[]>> map) {
        if (node == null) return;
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
