package com.cmentech.constant;

public class HttpConstant {
	
	//测试环境接口调用基础地址
	public final static String TESTBASEURL = "https://testrd.cmentech.com/test_api";
	public final static String TESTNBURL = "http://testrd.cmentech.com:8080/api_test";
//	public final static String TESTBASEURL = "http://zyedu.cmentech.com/student_apartment";

	//产品环境接口调用基础地址
	public final static String PROBASEURL = "https://api.cmentech.com/open_api";
	
	//第三方身份id
	private final static String SID = "17d57f573741414baa6310204faca89c";
//	private final static String SID = "3ff40ff7b1c24ba690fa7bf1f8c51b27"; //小水滴

	//第三方密钥
	private final static String SERCRET = "5C35912AE1B0CE449C0539BCF9CD23D3";
//	private final static String SERCRET = "586621A10C5DEB583AB92BA62B90B6F9"; //小水滴

	//周海涛的用户ID
//	private final static String SERCRET = "fd99b3c758da4ac6b1e46aca5546b3cg";

	/**
	 * 是否为开发模式返回api基础URL
	 * @param isDev：是否为开发模式
	 * @return 返回api基础URL
	 */
	public static String getBaseUrl(boolean isDev) {
		if(isDev) {
			return PROBASEURL;
		}
		return TESTBASEURL;
	}
	
	/**
	 * 调用该方法返回测试环境api基础URL
	 * @return 返回测试环境api基础URL
	 */
	public static String getBaseUrl() {
		return TESTBASEURL;
	}

	public static String getTestbaseurl() {
		return TESTBASEURL;
	}

	public static String getTestNburl() {
		return TESTNBURL;
	}

	public static String getProbaseurl() {
		return PROBASEURL;
	}

	public static String getSid() {
		return SID;
	}

	public static String getSercret() {
		return SERCRET;
	}
}