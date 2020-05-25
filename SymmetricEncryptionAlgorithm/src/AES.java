import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	
	public static byte[] encrytion_aes(String content,String iv_s,String key_s) throws Exception {
		/*
		 * AES加密
		 * */
        SecretKeySpec key = new SecretKeySpec(key_s.getBytes(), "AES");
        AlgorithmParameterSpec iv = new IvParameterSpec(iv_s.getBytes());
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aes.init(1, key, iv);
        byte[] bres = aes.doFinal(content.getBytes("UTF-8"));
        System.out.println("加密结果(BASE64):"+Base64.getEncoder().encodeToString(bres) );
		return bres;
	}
	
	public static void decrytion_aes(byte[] content,String iv_s,String key_s) throws Exception  {
		/*
		 * AES解密
		 * */
        SecretKeySpec key = new SecretKeySpec(key_s.getBytes(), "AES");
        AlgorithmParameterSpec iv = new IvParameterSpec(iv_s.getBytes());
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aes.init(2, key, iv);
        byte[] bres = aes.doFinal(content);
		System.out.println("解密之后的结果："+new String(bres) );
	}
	
	
	public static void main(String[] args) throws Exception {
		String content="a12345678544897";
		String iv_s="1234567890abcdef";
		String key_s="1234567890abcdef1234567890abcdef";
		byte[] result_byte=encrytion_aes(content,iv_s,key_s);
		
		decrytion_aes(result_byte,iv_s,key_s);
	
	}
	
}
