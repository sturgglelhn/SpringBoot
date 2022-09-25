package com.bjpowernode.redis;

import com.bjpowernode.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    // 注入RedisTemplate
    //泛型key,value都是String，或者Object，不写
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/redis/addstring")
    public String addToRedis(String name,String value){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myname","lisi");

        return "向redis添加String类型的数据";
    }

    @GetMapping("/redis/getk")
    public String getDate(String k){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key是"+k+"，他的值是："+v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k,
                              @PathVariable String v){
        // 使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k,v);
        return "使用StringRedisTemplate对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String getStringValue(@PathVariable String k){

        String v = stringRedisTemplate.opsForValue().get(k);
        return "key的value：" + v;
    }

    /** 设置RedisTemplate 序列化
     *  可以设置key 的序列化，可以设置value的序列化
     *  可以同时设置key和 value的序列化
     */
    @PostMapping("/redis/addstr")
    public String addString(String k,String v){
        // 使用RedisTemplate
        // 设置key 使用String序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 设置value的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k,v);

        return "定义RedisTemplate对象的key,value的序列化";
    }

    @GetMapping("/myname/{k}")
    public String getName(@PathVariable String k){
        //redisTemplate.getKeySerializer();
        String v =  stringRedisTemplate.opsForValue().get(k);

        return "key的value："+ v;
    }

    @PostMapping("/name")
    public String addName(String k,String v){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k,v);

        return "添加成功！";
    }


    /**
     * 使用json 序列化，把java对象转为json存储
     */
    @PostMapping("/redis/addjson")
    public String addJson(){
        Student student = new Student();
        student.setId(1001);
        student.setName("zhangsan");
        student.setAge(20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        redisTemplate.opsForValue().set("mystudent",student);

        return "json序列化";
    }

    @PostMapping("/redis/getjson/{k}")
    public String getJson(@PathVariable String k){

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        Object obj = redisTemplate.opsForValue().get(k);

        return "json反序列化"+ obj;
    }
}
