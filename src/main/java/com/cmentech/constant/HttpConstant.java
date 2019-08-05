package com.cmentech.constant;

public class HttpConstant {
	
	//测试环境接口调用基础地址
//	public final static String TESTBASEURL = "https://testrd.cmentech.com/test_api";
	public final static String TESTBASEURL = "http://zyedu.cmentech.com/student_apartment";

	//产品环境接口调用基础地址
	public final static String PROBASEURL = "https://api.cmentech.com/open_api";
	
	//第三方身份id
	private final static String SID = "c73cc8e31a754a61919c0b05e00b3f14";
	
	//第三方密钥
//	private final static String SERCRET = "73D29C3577E466A5D970C91769F07AD9";

	//周海涛的用户ID
	private final static String SERCRET = "fd99b3c758da4ac6b1e46aca5546b3cg"; //周海涛的用户ID

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