package com.cmentech.test;

import com.cmentech.constant.HttpConstant;
import com.cmentech.entity.ResponseEntity;
import com.cmentech.utils.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestSend {

	private static Map<String, Object> params = new HashMap<String, Object>();

	private static String baseUrl = HttpConstant.getBaseUrl();

	private static String url = "";

	private static String result = null;

	/**
	 * 1.同步房源
	 */
	public static void houseSync() {
		params.clear();
		params.put("houseId", DeanUtil.houseId);//房源ID
		params.put("houseName", DeanUtil.houseName);//房源名称
		params.put("houseAddress", DeanUtil.houseAddress);//房源地址
		params.put("floorId", DeanUtil.floorId);//楼层ID
		params.put("floorName", DeanUtil.floorName);//楼层名称
		params.put("roomId", DeanUtil.roomId);//房间ID
		params.put("roomName", DeanUtil.roomName);//房间名称
		url = baseUrl + RouterUtil.house_sync;
	}

	/**
	 * 2.绑定网关
	 */
	public static void houseBindGateway() {
		params.clear();
		params.put("gatewaySN", DeanUtil.gatewaySN);//网关序列号
		params.put("estateId", DeanUtil.houseId);//房源ID
		params.put("floorId", DeanUtil.floorId);//楼层ID
		url = baseUrl + RouterUtil.house_bindGateway;
	}

	/**
	 * 3.网关开启设备入网
	 */
	public static void gatewayPermitJoin() {
		params.clear();
		params.put("gatewaySN", DeanUtil.gatewaySN);//网关序列号
		params.put("roomId", DeanUtil.roomId);//房间ID
		url = baseUrl + RouterUtil.gateway_permitJoin;
	}

	/**
	 * 4.获取锁列表
	 */
	public static void inquireLocks() {
		params.clear();
		params.put("houseId", DeanUtil.houseId);//房源ID
		url = baseUrl + RouterUtil.inquire_locks;
	}

	/**
	 * 5.获取锁
	 */
	public static void inquireLock() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		url = baseUrl + RouterUtil.inquire_lock;
	}

	/**
	 * 6.获取锁密码列表
	 */
	public static void inquireLockPasswords() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		params.put("passwordType", DeanUtil.TEMPCODE);//密码类型
		url = baseUrl + RouterUtil.inquire_lock_passwords;
	}

	/**
	 * 7.获取管理员密码
	 */
	public static void inquireLockAdminPassword() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		url = baseUrl + RouterUtil.inquire_lock_admin_password;
	}

	/**
	 * 8.获取动态离线密码
	 */
	public static void deviceLockDynamicPassword() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		url = baseUrl + RouterUtil.device_lock_dynamic_password;
	}

	/**
	 * 9.指令下发-远程开锁
	 */
	public static void deviceLockOperationUnlock() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		params.put("password", DeanUtil.Admin_Pass);//管理员密码
		url = baseUrl + RouterUtil.device_lock_operation_unlock;
	}

	/**
	 * 10.指令下发-设置门锁密码
	 */
	public static void deviceLockOperationSavePassword() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		params.put("password", AESUtil.encryption("742198",DeanUtil.SID));//自定义密码
		params.put("index", DeanUtil.index);//密码编号
		params.put("startTime", DateUtil.getToday());//密码生效时间
		params.put("endTime", DateUtil.getNextMonth());//密码失效时间
		url = baseUrl + RouterUtil.device_lock_operation_save_password;
	}

	/**
	 * 11.指令下发-冻结、解冻密码
 	 */
	public static void deviceLockOperationFreezePassword() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		params.put("passwordType", DeanUtil.CODE);//密码类型
		params.put("index", DeanUtil.index);//密码编号
//		params.put("enable", DeanUtil.frozen);//冻结密码
		params.put("enable", DeanUtil.unfreeze);//解冻密码
		url = baseUrl + RouterUtil.device_lock_operation_freeze_password;
	}

	/**
	 * 12.删除密码
	 */
	public static void deviceLockOperationRemovePassword() {
		params.clear();
		params.put("lockId", DeanUtil.lockId);//锁ID
		params.put("passwordType", DeanUtil.TEMPCODE);//密码类型
		params.put("index", DeanUtil.index);//密码编号
		url = baseUrl + RouterUtil.device_lock_operation_remove_password;
	}










	public static void main(String[] args) throws IOException {
//		houseSync();
//		houseBindGateway();
//		gatewayPermitJoin();
//		inquireLocks();
//		inquireLock();
//		inquireLockPasswords();
//		inquireLockAdminPassword();
//		deviceLockDynamicPassword();
//		deviceLockOperationUnlock();
//		deviceLockOperationSavePassword();
//		deviceLockOperationFreezePassword();
		deviceLockOperationRemovePassword();

		try {
			result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(AESUtil.getPwdByResult(result));
		System.out.println(JSONUtil.parse2Bean(result, ResponseEntity.class));



//		/**
//		 * 该测试样例以接口对接文档中“注册回调为例”，
//		 * 该接口详情参考api对接文档
//		 */
//		Map<String, Object> params = new HashMap<String, Object>();
////		params.put("callbackUrl", "http://testrd.cmentech.com:8080");
//		params.put("gatewaySN", "CXAA18AAA0101465");
////		params.put("estateId", "FJDASFSAFDJKSFK");
////		params.put("floorId", "DJFSAKFFJDSA");
////		params.put("roomId", "DJALJFKDDFSIA");
////		params.put("houseId", "FJDASFSAFDJKSFK");
//		params.put("lockId", "deb4f9c8801a47bf8916a4b94aecec46");
//		params.put("passwordType", "CODE");
////		params.put("password", AESUtil.encryption("456789","17d57f573741414baa6310204faca89c"));
//		params.put("index", "1001");
//		params.put("enable", false);
////		params.put("startTime", "2019-05-27 00:00:00");
////		params.put("endTime", "2019-06-27 00:00:00");
//
//
//		String url = HttpConstant.getBaseUrl() + "/device/lock/operation/freeze_password";
//
//		String result = null;
//		try {
//			result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(JSONUtil.parse2Bean(result, ResponseEntity.class));



	}
}
