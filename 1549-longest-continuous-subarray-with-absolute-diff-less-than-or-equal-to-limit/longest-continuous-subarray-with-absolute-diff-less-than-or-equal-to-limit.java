class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offer(nums[right]);

            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offer(nums[right]);

            while (maxDeque.peek() - minDeque.peek() > limit) {
                if (maxDeque.peek() == nums[left]) maxDeque.poll();
                if (minDeque.peek() == nums[left]) minDeque.poll();
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
