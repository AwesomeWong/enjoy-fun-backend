package com.wong.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;

import static com.wong.utils.RedisConstants.BLOOM_FILTER_KEY;

// 布隆过滤器解决缓存穿透
public class BloomFiler {


        private static final int DEFAULT_SIZE = 1 << 24;
        private static final int[] SEEDS = new int[]{31, 41, 59, 93, 97, 3, 5, 7, 11}; // 哈希函数种子

        private StringRedisTemplate stringRedisTemplate;


        public BloomFiler(StringRedisTemplate stringRedisTemplate){
            this.stringRedisTemplate = stringRedisTemplate;
        }

        public void add(String value) {

            for(int seed : SEEDS){
                int hash  = hash(value, seed);
                stringRedisTemplate.opsForValue().setBit(BLOOM_FILTER_KEY, hash, true);
//                bitSet.set(hash);
            }
        }

        public boolean contains(String value) {
            for (int seed : SEEDS) {
                int hash = hash(value, seed);
//                if (!bitSet.get(hash)) {
//                    return false;
//                }
                // 使用 Redis 的 GETBIT 命令检查位
                Boolean bit = stringRedisTemplate.opsForValue().getBit(BLOOM_FILTER_KEY, hash);
                if (bit == null || !bit) {
                    return false;
                }
            }
            return true;
        }

        public int hash(String value, int seed) {
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
            int result = 0;
            for (byte b : bytes) {
                result = seed * result + b;
            }
            return Math.abs(result) % DEFAULT_SIZE;
        }

}
