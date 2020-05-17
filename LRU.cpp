#include "include.h"
class LRUCache {
public:
    
    std::list<int> ls;
    std::map<int,int> m_map;
    int m_capacity;
    LRUCache(int capacity) {
        m_capacity = capacity;
    }
    
    int get(int key) {
        if(m_map.find(key) == m_map.end())
        {
            return -1;
        }
        ls.remove(key);
        ls.push_back(key);
        return m_map[key];
    }
    
    void put(int key, int value) {
        if (m_map.find(key) == m_map.end())
        {
            if(m_map.size() == m_capacity)
            {
                int m_key = ls.front();
                ls.pop_front();
                m_map.erase(m_key);
            }            
            m_map[key] = value;
            ls.push_back(key);    
        }
        else
        {    
            m_map[key] = value;
        }        
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
int main(int argc, char const *argv[])
{
    LRUCache cache( 2 /* 缓存容量 */ );

    cache.put(1, 1);
    cache.put(2, 2);
    std::cout << std::endl;
    std::cout << cache.get(1) << std::endl;       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    std::cout << cache.get(2) << std::endl;     // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    std::cout << cache.get(1) << std::endl;      // 返回 -1 (未找到)
    std::cout << cache.get(3) << std::endl;       // 返回  3
    std::cout << cache.get(4) << std::endl;      // 返回  4

    return 0;
}
