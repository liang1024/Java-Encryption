import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
import javax.crypto.SecretKey;  
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;  

//参考博客：
//https://blog.csdn.net/aubdiy/article/details/51520425

public class DESedeCoder {  


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
	public static byte[] encrytion_desede(String content,String key_s) throws Exception {
		/*
		 * DESede加密
		 * */
    	
		DESedeKeySpec desedeKey = new DESedeKeySpec(key_s.getBytes());
		SecretKeyFactory key = SecretKeyFactory.getInstance("DESede");
		SecretKey secretKey = key.generateSecret(desedeKey);
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(1, secretKey);
		byte[] res = cipher.doFinal("a12345678".getBytes());
		System.out.println("加密结果(Base64后)："+Base64.getEncoder().encodeToString(res));
		return res;
	}
	
	public static String decrytion_desede(byte[] content,String key_s) throws Exception  {
		/*
		 * DESede解密
		 * */
		DESedeKeySpec desedeKey = new DESedeKeySpec(key_s.getBytes());
		SecretKeyFactory key = SecretKeyFactory.getInstance("DESede");
		SecretKey secretKey = key.generateSecret(desedeKey);
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(2, secretKey);
//		byte[] res = cipher.doFinal(Base64.getDecoder().decode("vN3o+PDQ0Yo8y5+InEzpwA=="));
		byte[] res = cipher.doFinal(content);

		return new String(res);
	}
	
    public static void main(String[] args) throws Exception {  

    	String key_s="123456781234567812345678"; //密钥
    	String content="a12345678"; // 内容
    	byte[] result_content=encrytion_desede(content,key_s);
    	String result=decrytion_desede(result_content,key_s);
		System.out.println("解析结果:"+result);

    }  

}  