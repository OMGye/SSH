package cn.itcast.shop.util;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * @author OMG丶爱月
 *
 */
public class UUIDUtils {
	
   public static String getUUID() {
	   return UUID.randomUUID().toString().replace("-", "");
   }
} 
