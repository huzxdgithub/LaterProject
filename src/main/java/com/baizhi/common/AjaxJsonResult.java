package com.baizhi.common;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Map;

/**
 * AjaxJson结果工具类
 * 
 * 用于在Action层对Ajax请求返回的数据进行统一处理
 * 
 * @author limiao
 * @version 1.0
 */
@SuppressWarnings("all")
public class AjaxJsonResult {

	/**
	 * 成功返回码
	 */
	public static final int CODE_SUCCESS = 1;

	/**
	 * 失败返回码
	 */
	public static final int CODE_ERROR = -1;

	/**
	 * 登陆超时返回码
	 */
	public static final int CODE_TIMEOUT = -2;

	/**
	 * 系统异常返回码
	 */
	public static final int CODE_SYSEXCEP = -9;

	/**
	 * 字段校验失败
	 */
	public static final int CODE_CHECKFAILD = -10;

	/**
	 * 人事代理党委登陆超时
	 */
	public static final int CODE_RSDLTIMEOUT = -4;

	/**
	 * 迁移用户未认证
	 */
	public static final int CODE_QYYHWRZ = -5;

	/**
	 * 单位认证失败
	 */
	public static final int CODE_IDENTIFYFAILD = -3;

	/**
	 * 单位登录 使用个人业务 错误代码
	 */
	public static final int CODE_FBMKGN = -20;
	/**
	 * 个人报考未登录 错误代码
	 */
	public static final int CODE_GEWDL = -30;

	/**
	 * 二级域名不存在
	 */
	public static final int CODE_EJYMOUT = -6;
	/**
	 * 请登录党员账号
	 */
	public static final int CODE_QDLDWZH = -40;
	
	
	public static final int CODE_QDLRcZH = -100;
	
	
	public static final int CODE_QDLDAZH = -50;
	
	private int returnCode;// 返回码（1:成功，-1:失败，-2:登陆超时，-9:系统异常 -3:
							// 单位认证失败，-5迁移用户未认证）

	private String returnMsg;// 返回消息

	private Object returnData = "";// 返回数据

	private int pageCount;// 总页数

	private int rowsCount;// 总行数

	private int startNum;// 开始行号

	public int getReturnCode() {
		return returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public Object getReturnData() {
		return returnData;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	/**
	 * 构造方法
	 * 
	 */
	public AjaxJsonResult() {
		this.returnCode = CODE_SUCCESS;
		this.returnMsg = "操作成功！";
	}

	/**
	 * 构造方法
	 * 
	 * @param returnCode
	 * @exception IllegalArgumentException
	 */
	public AjaxJsonResult(int returnCode) {
		this.returnCode = returnCode;

		switch (returnCode) {
		case CODE_SUCCESS:
			this.returnMsg = "操作成功！";
			break;
		case CODE_ERROR:
			this.returnMsg = "操作失败！";
			break;
		case CODE_TIMEOUT:
			this.returnMsg = "登录超时，请重新登录！";
			break;
		case CODE_SYSEXCEP:
			this.returnMsg = "系统异常！" + "\n" + "请拨打电话:85287506或85280278 以获得技术支持";
			break;
		case CODE_CHECKFAILD:
			this.returnMsg = "参数校验失败！";
			break;
		case CODE_IDENTIFYFAILD:
			this.returnMsg = "单位认证审批拒绝，请重新认证！";
			break;
		case CODE_QYYHWRZ:
			this.returnMsg = "亲爱的用户您好，应国家《信息安全技术个人信息安全规范》规定，2018年5月1日之后将不再对未实名制的账号提供服务，敬请您绑定手机号！";
			break;
		case CODE_EJYMOUT:
			this.returnMsg = "该域名不存在！";
			break;
		case CODE_QDLDWZH:
			this.returnMsg = "请登录党员账号！";
			break;
		case CODE_QDLDAZH:
		    this.returnMsg = "请登个人账号！";
		    break;
		case CODE_QDLRcZH:
		    this.returnMsg = "请登录单位账号进行报名！";   
			break;
		}
	}

	/**
	 * 设置操作成功 
	 * 
	 */
	public void setOperSuc() {
		this.returnCode = CODE_SUCCESS;
		this.returnMsg = "操作成功！";
	}

	/**
	 * 设置操作成功
	 * 
	 * @param returnData
	 */
	public void setOperSuc(Object returnData) {
		setOperSuc();
		setReturnData(returnData);
	}

	/**
	 * 设置操作失败
	 * 
	 */
	public void setOperErr() {
		this.returnCode = CODE_ERROR;
		this.returnMsg = "操作失败！";
	}

	/**
	 * 设置登陆超时
	 * 
	 */
	public void setLoginTimeOut() {
		this.returnCode = CODE_TIMEOUT;
		this.returnMsg = "登录超时，请重新登录！";
	}

	/**
	 * 设置登陆个人
	 * 
	 */
	public void setPersonLogin() {
		this.returnCode = CODE_FBMKGN;
		this.returnMsg = "单位暂不支持该业务，请登录个人账户";
	}

	/**
	 * 设置登陆个人2
	 * 
	 */
	public void setPersonLogin2() {
		this.returnCode = CODE_GEWDL;
		this.returnMsg = "请先登录个人账号";
	}

	/**
	 * 设置个人跳转
	 * 
	 */
	public void setredirect() {
		this.returnCode = CODE_FBMKGN;
		this.returnMsg = "登录超时，请重新登录！";
	}

	/**
	 * 设置单位认证失败
	 * 
	 */
	public void setIdentifyFaild() {
		this.returnCode = CODE_IDENTIFYFAILD;
		this.returnMsg = "单位认证审批中，请等待认证！";
	}

	/**
	 * 设置迁移用户认证失败
	 * 
	 */
	public void setQyyhrzFaild() {
		this.returnCode = CODE_QYYHWRZ;
		this.returnMsg = "亲爱的用户您好，应国家《信息安全技术个人信息安全规范》规定，2018年5月1日之后将不再对未实名制的账号提供服务，敬请您绑定手机号！";

	}

	/**
	 * 域名不存在
	 */
	public void setCODE_EJYMOUT() {
		this.returnCode = CODE_EJYMOUT;
		this.returnMsg = "该域名不存在！";
	}

	/**
	 * 设置系统异常
	 * 
	 * @param t
	 * @exception NullPointerException
	 */
	public void setSysException(Throwable t) {
		if (t == null) {
			throw new NullPointerException("t is null");
		}
		this.returnCode = CODE_SYSEXCEP;
		// this.returnMsg = "系统异常：" + BjsjzzExceptionUtils.getErrorCode(t);
	}

	/**
	 * 设置系统异常
	 * 
	 * @param excepMsg
	 *            异常描述
	 * @exception NullPointerException
	 */
	public void setSysException(String excepMsg) {
		if (excepMsg == null) {
			throw new NullPointerException("t is null");
		}
		this.returnCode = CODE_SYSEXCEP;
		this.returnMsg = "系统异常：" + excepMsg;
	}

	/**
	 * 设置返回码和返回消息
	 * 
	 * @param returnCode
	 * @param returnMsg
	 * @exception NullPointerException
	 */
	public void setCodeAndMsg(int returnCode, String returnMsg) {
		if (returnMsg == null) {
			throw new NullPointerException("returnMsg is null");
		}
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	/**
	 * 设置返回数据
	 * 
	 * @param returnData
	 * @exception NullPointerException
	 */
	public void setReturnData(Object returnData) {
		if (returnData == null) {
			throw new NullPointerException("returnData is null");
		}
		this.returnData = returnData;
	}

	/**
	 * 获得JSON
	 * 
	 * @return String
	 */
	public static String getJson(AjaxJsonResult ajr) {
		String jsonStr = String.valueOf(JsonHelper.object2str(ajr));

		Object data = ajr.getReturnData();
		if (data instanceof Collection) {
			((Collection) data).clear();
		} else if (data instanceof Map) {
			((Map) data).clear();
		}

		return jsonStr.replaceAll("null", "\"\"");
	}

	/**
	 * 设置分页信息
	 * 
	 * @param startNum
	 *            开始行数
	 * @param pageCount
	 *            总页数
	 * @param rowsCount
	 *            总行数
	 */
	public void setPageInfo(int startNum, int pageCount, int rowsCount) {
		this.startNum = Integer.valueOf(startNum);// 开始行号
		this.pageCount = Integer.valueOf(pageCount);// 总记录条数
		this.rowsCount = Integer.valueOf(rowsCount);
		;// 总页数
	}

	/**
	 * 解码
	 * 
	 * @param formbean
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws UnsupportedEncodingException
	 */
	public static void decode(Object formbean) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException, UnsupportedEncodingException {
		Class clazz = formbean.getClass();

		Field[] fields = clazz.getDeclaredFields();
		for (int index = 0; index < fields.length; index++) {
			if (fields[index].getType() != String.class && fields[index].getType() != String[].class) {
				continue;
			}

			String fieldName = fields[index].getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method getMethod = clazz.getMethod(getMethodName, new Class[] {});
			Object ret = getMethod.invoke(formbean, null);

			if (null == ret) {
				continue;
			}
			if (ret instanceof String) {
				String str = (String) ret;
				if ("".equals(ret)) {
					continue;
				}

				ret = URLDecoder.decode(str, "UTF-8");

				Method setMethod = clazz.getMethod(setMethodName, new Class[] { String.class });
				setMethod.invoke(formbean, new Object[] { ret });
			} else if (ret instanceof String[]) {
				String[] strs = (String[]) ret;
				if (strs.length == 0) {
					continue;
				}
				for (int i = 0; i < strs.length; i++) {
					if (null != strs[i] && !"".equals(strs[i])) {
						strs[i] = URLDecoder.decode(strs[i], "UTF-8");
					}
				}

				Method setMethod = clazz.getMethod(setMethodName, new Class[] { String[].class });
				setMethod.invoke(formbean, new Object[] { ret });
			}
		}
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return String
	 * @throws UnsupportedEncodingException
	 * @throws NullPointerException
	 *             - if str is null
	 */
	public static String decode(String str) throws UnsupportedEncodingException {
		if (str == null) {
			throw new NullPointerException("str is null");
		}

		if ("".equals(str)) {
			return "";
		}

		return URLDecoder.decode(str, "UTF-8");
	}

	/**
	 * 解码
	 * 
	 * @param strArray
	 * @throws UnsupportedEncodingException
	 * @throws NullPointerException
	 *             - if strArray is null
	 */
	public static void decode(String[] strArray) throws UnsupportedEncodingException {
		if (strArray == null) {
			throw new NullPointerException("strArray is null");
		}

		for (int i = 0; i < strArray.length; i++) {
			String str = strArray[i];
			if (str == null) {
				continue;
			}
			if ("".equals(str)) {
				continue;
			}
			strArray[i] = URLDecoder.decode(str, "UTF-8");
		}
	}

	/**
	 * @Title: formatNull
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param ajr
	 * @return
	 * @return AjaxJsonResult 返回类型
	 */
	public static AjaxJsonResult formatNull(AjaxJsonResult ajr) {
		return (AjaxJsonResult) JsonHelper.str2Object(getJson(ajr), AjaxJsonResult.class);
	}
}
