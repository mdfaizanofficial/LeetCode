/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        // 1 -> iterativeApproach to solve this problem
        // long result1 = iterativeApproach(root, k);
        // return result1;

        // 2 -> recursive approach to solve this problem
        long result2 = recursiveApproach(root, k);
        return result2;

    }

    public long iterativeApproach(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Long> sum_of_level = new ArrayList<>();

        while (!queue.isEmpty()) {
            long queue_size = queue.size();
            long level_sum = 0;
            for (int i = 0; i < queue_size; i++) {
                TreeNode curr_node = queue.poll();

                level_sum += curr_node.val;

                if (curr_node.left != null) {
                    queue.offer(curr_node.left);
                }

                if (curr_node.right != null) {
                    queue.offer(curr_node.right);
                }
            }
            sum_of_level.add(level_sum);
        }

        if (k > sum_of_level.size())
            return -1;
        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (long val : sum_of_level) {
            heap.offer(val);

            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public long recursiveApproach(TreeNode root, int k) {

        List<Long> sum_of_levels = sumOfLevels(root);
        if (sum_of_levels.size() < k)
            return -1;

        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (long val : sum_of_levels) {
            heap.offer(val);

            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public List<Long> sumOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> sum = new ArrayList<>();
        queue.offer(root);
        helper(queue, sum);
        return sum;
    }

    public void helper(Queue<TreeNode> queue, List<Long> sum) {
        if (queue.isEmpty()) {
            return;
        }

        long value = 0;
        int queue_size = queue.size();
        for (int i = 0; i < queue_size; i++) {
            TreeNode curr = queue.poll();

            value += curr.val;

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        sum.add(value);
        helper(queue, sum);
    }
}