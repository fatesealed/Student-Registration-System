package homework;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author dell
 * @date 2020/7/18 17:09 One
 */

public class One {
    public static void main(String[] args) {

        String jsonString = "{\"name\":\"王儒雅\"}";

        JSONObject object = JSONObject.parseObject(jsonString);
        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        System.out.println(pretty);
    }
}
