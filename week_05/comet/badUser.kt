class Solution {
    val answer = mutableSetOf<List<String>>()
    var usersSize = 0
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        usersSize = user_id.size
        
        dfs(user_id.toList(), banned_id.toList(), 0)
        
        return answer.size
    }
    
    fun dfs(userIds: List<String>, bannedIds: List<String>, index: Int) {
        if (index == bannedIds.size) {
            answer.add(bannedIds.sorted())
            
            return
        }
        
        val users = userIds.toMutableList()
        val banneds = bannedIds.toMutableList()
        
        for (i in userIds.indices) {
            val user = users[i]
            val banned = banneds[index]
            
            if (compare(user, banned)) {
                users.removeAt(i)
                banneds[index] = user
                
                dfs(users, banneds, index + 1)
                
                users.add(i, user)
                banneds[index] = banned
            }
        }
    }
    
    fun compare(original: String, secured: String): Boolean {
        if (original.length != secured.length) return false
        
        var isPossible = true
        for (i in original.indices) {            
            if (secured[i] != '*' && original[i] != secured[i]) {
                isPossible = false
                break
            }
        }
        
        return isPossible
    }
}