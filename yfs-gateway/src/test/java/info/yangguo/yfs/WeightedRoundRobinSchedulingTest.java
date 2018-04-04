package info.yangguo.yfs;

import info.yangguo.yfs.util.WeightedRoundRobinScheduling;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:杨果
 * @date:2017/5/17 下午2:16
 * <p>
 * Description:
 */
public class WeightedRoundRobinSchedulingTest {
    @Test
    public void test1() {
        WeightedRoundRobinScheduling.Server s1 = new WeightedRoundRobinScheduling.Server("g1", "s1", "192.168.0.100", 80, 1);//3
        WeightedRoundRobinScheduling.Server s2 = new WeightedRoundRobinScheduling.Server("g1", "s2", "192.168.0.101", 80, 1);//2
        WeightedRoundRobinScheduling.Server s3 = new WeightedRoundRobinScheduling.Server("g1", "s3", "192.168.0.102", 80, 1);//6
        WeightedRoundRobinScheduling.Server s4 = new WeightedRoundRobinScheduling.Server("g2", "s1", "192.168.0.103", 80, 1);//4
        WeightedRoundRobinScheduling.Server s5 = new WeightedRoundRobinScheduling.Server("g2", "s2", "192.168.0.104", 80, 1);//1
        List<WeightedRoundRobinScheduling.Server> serverList = new ArrayList<>();
        serverList.add(s1);
        serverList.add(s2);
        serverList.add(s3);
        serverList.add(s4);
        serverList.add(s5);
        WeightedRoundRobinScheduling obj = new WeightedRoundRobinScheduling();
        obj.healthilyServers.addAll(serverList);

        Map<String, Integer> countResult = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            WeightedRoundRobinScheduling.Server s = obj.getServer();
            String log = "group:" + s.getGroup() + ";id:" + s.getId() + ";ip:" + s.getIp() + ";weight:" + s.getWeight();
            if (countResult.containsKey(log)) {
                countResult.put(log, countResult.get(log) + 1);
            } else {
                countResult.put(log, 1);
            }
            System.out.println(log);
        }

        for (Map.Entry<String, Integer> map : countResult.entrySet()) {
            System.out.println("服务器 " + map.getKey() + " 请求次数： " + map.getValue());
        }

        countResult = new HashMap<>();
        obj.healthilyServers.remove(0);
        for (int i = 0; i < 100; i++) {
            WeightedRoundRobinScheduling.Server s = obj.getServer();
            String log = "group:" + s.getGroup() + ";id:" + s.getId() + ";ip:" + s.getIp() + ";weight:" + s.getWeight();
            if (countResult.containsKey(log)) {
                countResult.put(log, countResult.get(log) + 1);
            } else {
                countResult.put(log, 1);
            }
            System.out.println(log);
        }

        for (Map.Entry<String, Integer> map : countResult.entrySet()) {
            System.out.println("服务器 " + map.getKey() + " 请求次数： " + map.getValue());
        }
    }

    @Test
    public void test2() {
        WeightedRoundRobinScheduling.Server s1 = new WeightedRoundRobinScheduling.Server("g1", "s1", "192.168.0.100", 80, 1);//3
        WeightedRoundRobinScheduling.Server s2 = new WeightedRoundRobinScheduling.Server("g1", "s2", "192.168.0.101", 80, 2);//2
        WeightedRoundRobinScheduling.Server s3 = new WeightedRoundRobinScheduling.Server("g1", "s3", "192.168.0.102", 80, 1);//6
        WeightedRoundRobinScheduling.Server s4 = new WeightedRoundRobinScheduling.Server("g2", "s1", "192.168.0.103", 80, 2);//4
        WeightedRoundRobinScheduling.Server s5 = new WeightedRoundRobinScheduling.Server("g2", "s2", "192.168.0.104", 80, 1);//1
        List<WeightedRoundRobinScheduling.Server> serverList = new ArrayList<>();
        serverList.add(s1);
        serverList.add(s2);
        serverList.add(s3);
        serverList.add(s4);
        serverList.add(s5);
        WeightedRoundRobinScheduling obj = new WeightedRoundRobinScheduling();
        obj.healthilyServers.addAll(serverList);

        Map<String, Integer> countResult = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            WeightedRoundRobinScheduling.Server s = obj.getServer();
            String log = "group:" + s.getGroup() + ";id:" + s.getId() + ";ip:" + s.getIp() + ";weight:" + s.getWeight();
            if (countResult.containsKey(log)) {
                countResult.put(log, countResult.get(log) + 1);
            } else {
                countResult.put(log, 1);
            }
            System.out.println(log);
        }

        for (Map.Entry<String, Integer> map : countResult.entrySet()) {
            System.out.println("服务器 " + map.getKey() + " 请求次数： " + map.getValue());
        }

        countResult = new HashMap<>();
        obj.healthilyServers.remove(0);
        for (int i = 0; i < 100; i++) {
            WeightedRoundRobinScheduling.Server s = obj.getServer();
            String log = "group:" + s.getGroup() + ";id:" + s.getId() + ";ip:" + s.getIp() + ";weight:" + s.getWeight();
            if (countResult.containsKey(log)) {
                countResult.put(log, countResult.get(log) + 1);
            } else {
                countResult.put(log, 1);
            }
            System.out.println(log);
        }

        for (Map.Entry<String, Integer> map : countResult.entrySet()) {
            System.out.println("服务器 " + map.getKey() + " 请求次数： " + map.getValue());
        }
    }
}
