package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import frank.model.Result;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JSONUtil {

     public static final String DATE_PATTERN="yyyy-MM-dd HH:mm:ss";
      public static String serialize(Object obj){
          ObjectMapper mapper=new ObjectMapper();
          //设置日期格式类
          mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
          try {
              return mapper.writeValueAsString(obj);
          } catch (JsonProcessingException e) {
              throw new RuntimeException("JSON序列化失败："+obj,e);
          }
      }

      public static <T> T deserialize(String json,Class<T> clazz){
          ObjectMapper mapper=new ObjectMapper();
          //设置日期格式类
          mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
          try {
              return mapper.readValue(json,clazz);
          } catch (IOException e) {
              throw new RuntimeException("JSON字符串反序列化失败",e);
          }
      }

    public static void main(String[] args) {
        Result result = new Result();
        result.setCode("xxx001");
        result.setMessage("发表文章出错");
        result.setData("文章数据");
        System.out.println(serialize(result));
    }
}
