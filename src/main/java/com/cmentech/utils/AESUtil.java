package com.cmentech.utils;

import com.cmentech.entity.BaseEntity;
import com.cmentech.entity.ResponseEntity;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 该AES工具类用于接口调用时，凡接口中提及需要加密下发时，
 * 需使用该工具类加密后向智能锁下发。该工具类中的字符编码均采用utf-8
 * 加密方式采用 AES加密+Base64编码
 * 解密方式采用Base64解码+AES解密
 * @author hyh
 * @date 2018/05/10
 */
public class AESUtil {
	
	/**
	 * 将明文进行AES加密+Base64编码，返回加密后的密文
	 * @param content：待加密的明文
	 * @param password：AES密钥为对接方在我司申请的sid
	 * @return 返回经AES加密及Base64编码后的密文
	 */
    public static String encryption(String content, String password) {
        try {
        	SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes(CharSetUtil.getUtf8()));
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] encodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(encodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes(CharSetUtil.getUtf8());
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            //Base64编码
            byte[] encode = Base64.getEncoder().encode(result);
            
            return new String(encode, CharSetUtil.getUtf8()) ; // 加密
        } catch (NoSuchAlgorithmException e) {
        	throw new RuntimeException("没找到算法，"+e.getMessage());
        } catch (NoSuchPaddingException e) {
        	throw new RuntimeException("没找到填充，"+e.getMessage());
        } catch (InvalidKeyException e) {
        	throw new RuntimeException("无效密钥，"+e.getMessage());
        } catch (UnsupportedEncodingException e) {
        	throw new RuntimeException("不支持的字符编码，"+e.getMessage());
        } catch (IllegalBlockSizeException e) {
        	throw new RuntimeException("块大小无效，"+e.getMessage());
        } catch (BadPaddingException e) {
        	throw new RuntimeException("填充损坏，"+e.getMessage());
        }
    }
    
    /**
     * 将经过AES加密及Base64编码后的密文字符串解密为加密前的明文。
     * @param base64Str：加密后的密文
     * @param password：AES密钥为对接方在我司申请的sid
     * @return 返回解密后的明文
     */
    public static String decryption(String base64Str, String password) {
        try {
        	//Base64 解码
        	byte[] content = Base64.getDecoder().decode(base64Str);
        	//指定生成随机数算法名称
        	SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes(CharSetUtil.getUtf8()));
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			return new String(cipher.doFinal(content), CharSetUtil.getUtf8());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没找到算法，"+e.getMessage());
        } catch (NoSuchPaddingException e) {
        	throw new RuntimeException("没找到填充，"+e.getMessage());
        } catch (InvalidKeyException e) {
        	throw new RuntimeException("无效密钥，"+e.getMessage());
        } catch (IllegalBlockSizeException e) {
        	throw new RuntimeException("块大小无效，"+e.getMessage());
        } catch (BadPaddingException e) {
        	throw new RuntimeException("填充损坏，"+e.getMessage());
        } catch (UnsupportedEncodingException e) {
        	throw new RuntimeException("不支持的字符编码，"+e.getMessage());
        }
    }


    public static String getPwdByResult(String result) {
        ResponseEntity resp = JSONUtil.parse2Bean(result, ResponseEntity.class);
        BaseEntity entity = JSONUtil.parse2Bean(String.valueOf(resp.getData()), BaseEntity.class);
        String pwd = AESUtil.decryption(entity.getPassword(), DeanUtil.SID);
        return pwd;
    }

    
    public static void main(String[] args) {
        String result = "{\"code\":0,\"data\":{\"password\":\"qwiTMrvMt6GK+dkfs/EcXg==\",\"status\":\"已录入\"},\"message\":\"ok\"}";
        getPwdByResult(result);
	}

}
