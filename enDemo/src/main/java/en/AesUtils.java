package en;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@SuppressWarnings("restriction")
public class AesUtils {

	private static final String ivParameter = "0392039203920300";

	/**
	 * 解密
	 * @param sSrc
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String sSrc, String sKey) throws Exception {
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec("0392039203920300".getBytes());
			cipher.init(2, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
			byte[] original = cipher.doFinal(encrypted1);
			return new String(original, "utf-8");
		}
		catch (Exception ex) {
			throw new Exception("AES解密password失败!!!!");
		}

	}

	/**
	 * 加密
	 * @param skey
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String skey, String sSrc) throws Exception {
		if (!sSrc.isEmpty()) {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] raw = skey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(1, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return new BASE64Encoder().encode(encrypted);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("asdfghjkl0iuytbc", "Billing_iso37"));
	}

}