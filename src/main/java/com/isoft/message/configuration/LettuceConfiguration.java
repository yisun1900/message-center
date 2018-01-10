package com.isoft.message.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Created by sunyi on 2018/1/10.
 */
@Configuration
public class LettuceConfiguration {

    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                .master("mymaster")
                .sentinel("192.168.201.21", 26379)
                .sentinel("192.168.201.21", 26380);
        return new LettuceConnectionFactory(sentinelConfig);
    }
}
