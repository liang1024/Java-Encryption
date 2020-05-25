import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;



public class DES {
	
	public static String byteToHexString(byte[] by) {
		StringBuffer SB = new StringBuffer();
		int i = 0;
		while (i < by.length) {
			int k = by[i];
			int j = k;
			if (k < 0) {
				j = k + 256;
			}
			if (j < 16) {
				SB.append("0");
			}
			SB.append(Integer.toHexString(j));
			i += 1;
		}
		return SB.toString();
	}
	
	public static byte[] encrytion_des(String content,String key) throws Exception {
		/*
		 * DES加密
		 * */
		SecureRandom random = new SecureRandom();
		DESKeySpec desKey = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(desKey);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
		byte[] result = cipher.doFinal(content.getBytes());
		String result_s=byteToHexString(result);
		System.out.println("加密之后的结果:"+result_s);
		return result;
	}
	
	public static void decrytion_des(byte[] content,String de_key) throws Exception  {
		/*
		 * DES解密
		 * */
		DESKeySpec desKey = new DESKeySpec(de_key.getBytes());
		SecretKeyFactory key = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = key.generateSecret(desKey);
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE,secretKey);
		byte[] res = cipher.doFinal(content);
		System.out.println("解密之后的结果："+new String(res) );
	}
	
	public static void main(String[] args) throws Exception {
		String key_pass="12345678";// 密码长度必须是8的倍数
		byte[] result_byte=encrytion_des("456789",key_pass);
		decrytion_des(result_byte,key_pass);
		
	}
	
}
