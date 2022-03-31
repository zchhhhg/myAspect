package com.example.spring.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhoucheng
 * @description 贪心算法 每一步选择中都选择最好或最优的选择，从而希望最终结果是最好或最优的（最终结果不一定都是最优，但会是近似最优的）
 * 电台覆盖问题 每个电台能覆盖几个城市，找出能覆盖所有城市的最少电台
 * @date 2022-03-29-9:22
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        // 已选择的电台key
        HashSet<String> selectBroadcast = new HashSet<>();
        String maxKey = null;
        HashSet<String> tempAreas = new HashSet<>();
        while (allAreas.size()>0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                HashSet<String> areas = broadcasts.get(key);
                tempAreas.clear();
                tempAreas.addAll(areas);
                tempAreas.retainAll(allAreas);
                if (tempAreas.size() > 0 && (maxKey == null || tempAreas.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if(maxKey!=null){
                selectBroadcast.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(selectBroadcast);
    }
}
