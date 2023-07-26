package org.example;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.concurrent.TimeUnit;

public class HazelcastRandom {
    public static void main(String[] args) {
		int count=20000;
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();


        IMap<String, Integer> map = hzInstance.getMap("randomNumbers2");
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            map.put("Number" + i, (int) (Math.random() * 1000));
        }
        long endTime = System.nanoTime();
        long insertionTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Hazelcast "+ count+ " sayı eklemesi süresi: " + insertionTime + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            map.get("Number" + (int) (Math.random() * 1000));
        }
        endTime = System.nanoTime();
        long retrievalTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Hazelcast "+ count+"sayı seçme süresi: " + retrievalTime + " ms");


        hzInstance.shutdown();
    }
}
