package cn.itcast.shop.util;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author OMGؼ����
 *
 */
public class UUIDUtils {
	
   public static String getUUID() {
	   return UUID.randomUUID().toString().replace("-", "");
   }
} 
