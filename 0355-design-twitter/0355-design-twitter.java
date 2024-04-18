class Twitter {
    public LinkedHashMap<Integer, Integer> map;
    public Map<Integer, List<Integer>> follow;
    
    public Twitter() {
        map = new LinkedHashMap<>();
        follow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        map.put(tweetId, userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList<>();
        List<Integer> reverseOrderedKeys = new ArrayList<>(map.keySet());
        Collections.reverse(reverseOrderedKeys);
        int count = 0; 
        for (int i : reverseOrderedKeys)
        {
            if ((map.get(i) == userId || (follow.containsKey(userId) && follow.get(userId).contains(map.get(i)))) && count < 10) 
            {
                ans.add(i);
                count++;
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new ArrayList<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follow.getOrDefault(followerId, new ArrayList<>()).remove(Integer.valueOf(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */