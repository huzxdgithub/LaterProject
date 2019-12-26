package com.baizhi.common;

import com.sx.conf.AppConfig;
import com.sx.conf.ReadXml;
import com.sx.conf.SysConfig;

/**
 * @author windy 若需要在 sx_app_config.xml 中自定义一些配置，
 *         <li>比如：&lt;project-config&gt;</li> &lt;test&gt;test&lt;/test&gt;
 *         &lt;/project-config&gt; 在配置文件中配置后，可入代码中所示获得配置的数据
 */
public class SxAppConfig extends AppConfig {

	private static String TEST;

	public static String getZPHLBTS() {
		return ZPHLBTS;
	}

	public static void setZPHLBTS(String ZPHLBTS) {
		SxAppConfig.ZPHLBTS = ZPHLBTS;
	}

	public static String getMRGMJLSXZ() {
		return MRGMJLSXZ;
	}

	public static void setMRGMJLSXZ(String MRGMJLSXZ) {
		SxAppConfig.MRGMJLSXZ = MRGMJLSXZ;
	}

	@Override
	public boolean initSxConfig() {
		// 读取配置文件中临时表缓存数据量
		ReadXml rx = new ReadXml("xml路径 可封装为一个类中的静态方法方便更改路径");
		try {
			// 读取test节点中的文本值
			RGPXZDQYS=rx.read("sx-app-Config", "rgpxzdqys");
			HYPXZDQY=rx.read("sx-app-Config", "hypxzdqy");
			ZDZDQYS=rx.read("sx-app-Config", "zdzdqys");
		    FWBWJDZ = rx.read("sx-app-Config", "fwbwjdz");
			FWBZSZDZ = rx.read("sx-app-Config", "fwbzszdz");
			MRGMJLSXZ = rx.read("sx-app-Config", "mrgmjlsxz");
			ZPHLBTS = rx.read("sx-app-Config", "zphlbts");
			DWXYZ = rx.read("sx-app-Config", "dwxyz");
			KSLX1LBXSSJ = rx.read("sx-app-Config", "kslx1lbxssj");
			KSLX2LBXSSJ = rx.read("sx-app-Config", "kslx2lbxssj");
			appewmpictureServer = rx.read("sx-app-Config", "appewmpictureServer");
			zmpictureServer = rx.read("sx-app-Config", "zmpictureServer");
			KJZMHJYZ = rx.read("sx-app-Config", "kjzmhjyz");
			DDHEWM = rx.read("sx-app-Config", "ddhewm");
			DDHYZLJ = rx.read("sx-app-Config", "ddhyzlj");
			RSDLRYWYH = rx.read("sx-app-Config", "rsdlrywyh");
			SQZWSL = rx.read("sx-app-Config", "sqzwsl");
			SCZWYXQ = rx.read("sx-app-Config", "sczwyxq");
			XCZPZWSDSJ = rx.read("sx-app-Config", "xczpzwsdsj");
			FXCZPZWSDSJ = rx.read("sx-app-Config", "fxczpzwsdsj");
			JLSL = rx.read("sx-app-Config", "jlsl");
			JYBJSL = rx.read("sx-app-Config", "jybjsl");
			GZJYSL = rx.read("sx-app-Config", "gzjysl");
			XMJYSL = rx.read("sx-app-Config", "xmjysl");
			GRZSSL = rx.read("sx-app-Config", "grzssl");
			YYNLSL = rx.read("sx-app-Config", "yynlsl");
			TDJLYXQ = rx.read("sx-app-Config", "tdjlyxq");
			XCTDJLYXQ = rx.read("sx-app-Config", "xctdjlyxq");
			JLBCKYXQ = rx.read("sx-app-Config", "jlbckyxq");
			JLBSCYXQ = rx.read("sx-app-Config", "jlbscyxq");
			PBDWSL = rx.read("sx-app-Config", "pbdwsl");
			GMJLYXQ = rx.read("sx-app-Config", "gmjlyxq");
			JLDS = rx.read("sx-app-Config", "jlds");
			WTZPZWSDSJ = rx.read("sx-app-Config", "wtzpzwsdsj");
			SPJJYXQ = rx.read("sx-app-Config", "spjjyxq");
			WSPYXQ = rx.read("sx-app-Config", "wspyxq");
			XCZPZWYXQ = rx.read("sx-app-Config", "xczpzwyxq");
			SJYZMYXQ = rx.read("sx-app-Config", "sjyzmyxq");
			YXJHMYXQ = rx.read("sx-app-Config", "yxjhmyxq");
			SFKQ3LZW = rx.read("sx-app-Config", "sfkq3lzw");
			SFKQ2LZW = rx.read("sx-app-Config", "sfkq2lzw");
			DXDJ = rx.read("sx-app-Config", "dxjg");
			ZPDSDJ = rx.read("sx-app-Config", "zpdsdj");
			JLDSDJ = rx.read("sx-app-Config", "jldsdj");
			XSZWYXQ = rx.read("sx-app-Config", "xszwyxq");
			RDTBDJ = rx.read("sx-app-Config", "rdtbdj");
			BANNERDJ = rx.read("sx-app-Config", "bannerdj");
			WTZPDJ = rx.read("sx-app-Config", "wtzpdj");
			WSYDXCZWJZSJ = rx.read("sx-app-Config", "wsydxczwjzsj");
			WSZFKDF = rx.read("sx-app-Config", "wszfkdf");
			ZPHLC2L = rx.read("sx-app-Config", "zphlc2l");
			ZPHLC3L = rx.read("sx-app-Config", "zphlc3l");
			ZPHLC3L = rx.read("sx-app-Config", "zphlc3l");
			SCJLYXQ = rx.read("sx-app-Config", "scjlyxq");
			SUCCODE = rx.read("sx-app-Config", "succode");
			BHSCCSZ = rx.read("sx-app-Config", "bhsxcsz");
			PICTURESERVER = rx.read("sx-app-Config", "pictureServer");
			GYRCZYWZ = rx.read("sx-app-Config", "gyrczywz");
			WZYHHCWJLJ = rx.read("sx-app-Config", "wzyhhcwjlj");
			JLHCWJLJ = rx.read("sx-app-Config", "jlhcwjlj");
			FJSCCUTOUTLJ = rx.read("sx-app-Config", "fjscCutOutLj");
			NETWORKSERVER = rx.read("sx-app-Config", "networkServer");
			PAGESIZE = Integer.parseInt(rx.read("sx-app-Config", "pageSize"));
			GYWMLXDH = rx.read("sx-app-Config", "lxdh");
			GYWMRCJS = rx.read("sx-app-Config", "gyrcjs");
			GYWMWZ = rx.read("sx-app-Config", "wz");
			// 人才信息各模块添加数量
			JTCYSL = rx.read("sx-app-Config", "jtcysl");
			SQFWSL = rx.read("sx-app-Config", "sqfwsl");
			YBDXSL = rx.read("sx-app-Config", "ybdxsl");
			SHBTSL = rx.read("sx-app-Config", "shbtsl");
			ZFBTSL = rx.read("sx-app-Config", "zfbtsl");
			ZYJSZWSL = rx.read("sx-app-Config", "zyjszwsl");
			ZYZGDJZSSL = rx.read("sx-app-Config", "zyzgdjzssl");

			// 支付宝
			NOTIFYURL = rx.read("sx-app-Config", "notifyUrl");
			RETURNURL = rx.read("sx-app-Config", "returnUrl");
			APPID = rx.read("sx-app-Config", "appId");
			DYAPPID = rx.read("sx-app-Config", "dyappId");
			ALIPAYURL = rx.read("sx-app-Config", "alipayUrl");
			QQGWURL = rx.read("sx-app-Config", "qqgwUrl");
			// 邮箱
			SERVERHOST = rx.read("sx-app-Config", "serverHost");
			SERVERPOST = rx.read("sx-app-Config", "serverPort");
			USERNAME = rx.read("sx-app-Config", "userName");
			PASSWORD = rx.read("sx-app-Config", "passWord");
			// 二级域名
			NGINXSERVER = rx.read("sx-app-Config", "nginxServer");
			NGINXSNAME = rx.read("sx-app-Config", "nginxName");
			NGINXSPWD = rx.read("sx-app-Config", "nginxPwd");
			EJYMHZ = rx.read("sx-app-Config", "ejymhz");
			// 手机发短信配置
			SJUSER = rx.read("sx-app-Config", "sjUser");
			SJPWD = rx.read("sx-app-Config", "sjPwd");
			GSDZ = rx.read("sx-app-Config", "gsdz");
			ZWS = rx.read("sx-app-Config", "zws");
			// banner购买数量
			HTTJBANNERSL = rx.read("sx-app-Config", "httjbannersl");// 后台添加数量
			DWGMBANNERSL = rx.read("sx-app-Config", "dwgmbannersl");// 单位购买数量
			// 图片需压缩的模块名
			TPYSMODENAME = rx.read("sx-app-Config", "tpysmodename");//
			// 图片需压缩限制大小
			TPYSXZSIZE = rx.read("sx-app-Config", "tpysxzsize");//
			// 图片压缩质量
			TPYSQUALITY = rx.read("sx-app-Config", "tpysquality");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String getTEST() {
		return TEST;
	}

	/**
	 * 系统参数表(gyrlzyw_qzzp_xtcs)中的参数代码(csdm)
	 */
	/**
	 * 富文本字数最大值
	 */
	private static String FWBZSZDZ;
	/**
	 * 每日购买简历上限值
	 */
	private static String MRGMJLSXZ;
	/**
	 * 招聘会列表条数
	 */
	private static String ZPHLBTS;
	/**
	 * 单位信誉值
	 */
	private static String DWXYZ;
	/**
	 * 考试类型1列表显示时间天
	 */
	private static String KSLX1LBXSSJ;
	/**
	 * 考试类型2列表显示时间天
	 */
	private static String KSLX2LBXSSJ;
	/**
	 * 调档函档案印章
	 */
	private static String DDHYZLJ;
	/**
	 * 调档函二维码
	 */
	private static String DDHEWM;
	/**
	 * 开具证明户籍印章
	 */
	private static String KJZMHJYZ;
	/**
	 * 人事代理人员委员会
	 */
	private static String RSDLRYWYH;

	/**
	 * 公司地址
	 */
	private static String GSDZ;
	/**
	 * 展位数
	 */
	private static String ZWS;
	/**
	 * 二级域名服务器
	 */
	private static String SJUSER;
	/**
	 * 账号
	 */
	private static String SJPWD;
	/**
	 * 二级域名服务器
	 */
	private static String NGINXSERVER;
	/**
	 * 账号
	 */
	private static String NGINXSNAME;
	/**
	 * 密码
	 */
	private static String NGINXSPWD;
	/**
	 * 二级域名后缀
	 */
	private static String EJYMHZ;
	/**
	 * 邮箱服务
	 */
	private static String SERVERHOST;
	/**
	 * 邮箱端口号
	 */
	private static String SERVERPOST;
	/**
	 * 邮箱账号
	 */
	private static String USERNAME;
	/**
	 * 邮箱密码
	 */
	private static String PASSWORD;

	/**
	 * 服务器异步通知页面路经
	 */
	private static String NOTIFYURL;
	/**
	 * 页面跳转同步通知页面路经
	 */
	private static String RETURNURL;
	/**
	 * 请求关网地址
	 */
	private static String QQGWURL;
	/**
	 * 商户appid
	 */
	private static String APPID;
	/**
	 * 商户appid
	 */
	private static String DYAPPID;
	/**
	 * 私钥
	 */
	private static String ALIPAYURL;

	/**
	 * 外网服务器地址
	 */
	private static String NETWORKSERVER;
	/**
	 * 支付宝接口返回code---成功
	 */
	private static String SUCCODE;

	/**
	 * 编号生成初始值
	 */
	private static String BHSCCSZ;

	/**
	 * 招聘会楼层2楼
	 */
	private static String ZPHLC2L;
	/**
	 * 招聘会楼层3楼
	 */
	private static String ZPHLC3L;
	/**
	 * 申请职位数量
	 */
	private static String SQZWSL;
	/**
	 * 收藏职位有效期
	 */
	private static String SCZWYXQ;
	/**
	 * 现场招聘展位锁定时间 xczpzwsdsj
	 */
	private static String XCZPZWSDSJ;
	/**
	 * 非现场招聘展位锁定时间 fxczpzwsdsj
	 */
	private static String FXCZPZWSDSJ;
	/**
	 * 简历数量 jlsl
	 */
	private static String JLSL;
	/**
	 * 教育背景数量 jybjsl
	 */
	private static String JYBJSL;
	/**
	 * 工作经验数量 gzjysl
	 */
	private static String GZJYSL;
	/**
	 * 项目经验数量 xmjysl
	 */
	private static String XMJYSL;
	/**
	 * 个人证书数量 grzssl
	 */
	private static String GRZSSL;
	/**
	 * 语言能力数量 yynlsl
	 */
	private static String YYNLSL;
	/**
	 * 投递记录有效期 tdjlyxq
	 */
	private static String TDJLYXQ;
	/**
	 * 现场投递记录有效期 xctdjlyxq
	 */
	private static String XCTDJLYXQ;
	/**
	 * 简历被查看有效期 jlbckyxq
	 */
	private static String JLBCKYXQ;
	/**
	 * 简历被收藏有效期 jlbscyxq
	 */
	private static String JLBSCYXQ;
	/**
	 * 屏蔽单位数量 pbdwsl
	 */
	private static String PBDWSL;
	/**
	 * 购买简历有效期 gmjlyxq
	 */
	private static String GMJLYXQ;
	/**
	 * 简历点数
	 */
	private static String JLDS;

	/**
	 * 短信条数
	 */
	private static String DXTS;
	/**
	 * 委托招聘展位锁定时间 wtzpzwsdsj
	 */
	private static String WTZPZWSDSJ;
	/**
	 * 审批拒绝有效期 spjjyxq
	 */
	private static String SPJJYXQ;
	/**
	 * 未审批有效期 wspyxq
	 */
	private static String WSPYXQ;
	/**
	 * 现场招聘职位有效期
	 */
	private static String XCZPZWYXQ;
	/**
	 * 手机验证码有效期 sjyzmyxq
	 */
	private static String SJYZMYXQ;
	/**
	 * 邮箱激活码有效期
	 */
	private static String YXJHMYXQ;
	/**
	 * 短信单价
	 */
	private static String DXDJ;
	/**
	 * 招聘点数单价
	 */
	private static String ZPDSDJ;
	/**
	 * 简历点数单价
	 */
	private static String JLDSDJ;
	/**
	 * 相似职位有效期
	 */
	private static String XSZWYXQ;
	/**
	 * 名企图标单价
	 */
	private static String RDTBDJ;
	/**
	 * BANNER单价
	 */
	private static String BANNERDJ;
	/**
	 * 委托招聘单价
	 */
	private static String WTZPDJ;

	/**
	 * 网上预订现场展位截止时间
	 */
	private static String WSYDXCZWJZSJ;
	/**
	 * 网上支付快递费
	 */
	private static String WSZFKDF;

	/**
	 * 是否开启3楼展位
	 */
	private static String SFKQ3LZW;
	/**
	 * 是否开启2楼展位
	 */
	private static String SFKQ2LZW;
	/**
	 * 分页参数 pageSize
	 */
	private static int PAGESIZE;
	/**
	 * 收藏简历有效期
	 */
	private static String SCJLYXQ;
	/**
	 * 图片服务器ip地址
	 */
	private static String PICTURESERVER;
	/**
	 * 贵阳人才主页网址
	 */
	private static String GYRCZYWZ;
	/**
	 * 附件上传截取服务器路径(windows用2,linux用5)
	 */
	private static String FJSCCUTOUTLJ;
	/**
	 * 网站用户缓存文件路径
	 */
	private static String WZYHHCWJLJ;
	/**
	 * 简历缓存文件路径
	 */
	private static String JLHCWJLJ;
	/**
	 * 关于我们联系电话
	 */
	private static String GYWMLXDH;
	/**
	 * 关于我们贵阳人才介绍
	 */
	private static String GYWMRCJS;
	/**
	 * 关于我们网址
	 */
	private static String GYWMWZ;
	/**
	 * 后台添加banner广告数量
	 */
	private static String HTTJBANNERSL;
	/**
	 * 单位购买bannner广告数量
	 */
	private static String DWGMBANNERSL;
	/**
	 * 图片需压缩的模块名
	 */
	private static String TPYSMODENAME;
	/**
	 * 图片需压缩限制大小
	 */
	private static String TPYSXZSIZE;
	/**
	 * 证明图片ip地址
	 */
	private static String zmpictureServer;
	/**
	 * 图片压缩质量
	 */
	private static String TPYSQUALITY;
	/**
	 * app服务 档案二维码图片获 ip地址
	 */
	private static String appewmpictureServer;

	private static String DWXYZCS;

	public static String getDWXYZCS() {
		return DWXYZCS;
	}

	public static void setDWXYZCS(String DWXYZCS) {
		SxAppConfig.DWXYZCS = DWXYZCS;
	}

	public static String getKSLX1LBXSSJ() {
		return KSLX1LBXSSJ;
	}

	public static void setKSLX1LBXSSJ(String kSLX1LBXSSJ) {
		KSLX1LBXSSJ = kSLX1LBXSSJ;
	}

	public static String getKSLX2LBXSSJ() {
		return KSLX2LBXSSJ;
	}

	public static void setKSLX2LBXSSJ(String kSLX2LBXSSJ) {
		KSLX2LBXSSJ = kSLX2LBXSSJ;
	}

	public static String getAppewmpictureServer() {
		return appewmpictureServer;
	}

	public static void setAppewmpictureServer(String appewmpictureServer) {
		SxAppConfig.appewmpictureServer = appewmpictureServer;
	}

	public static String getZmpictureServer() {
		return zmpictureServer;
	}

	public static void setZmpictureServer(String zmpictureServer) {
		SxAppConfig.zmpictureServer = zmpictureServer;
	}

	public static String getQQGWURL() {
		return QQGWURL;
	}

	public static void setQQGWURL(String qQGWURL) {
		QQGWURL = qQGWURL;
	}

	public static String getFJSCCUTOUTLJ() {
		return FJSCCUTOUTLJ;
	}

	public static String getDYAPPID() {
		return DYAPPID;
	}

	public static void setDYAPPID(String dYAPPID) {
		DYAPPID = dYAPPID;
	}

	public static void setFJSCCUTOUTLJ(String fJSCCUTOUTLJ) {
		FJSCCUTOUTLJ = fJSCCUTOUTLJ;
	}

	public static String getGSDZ() {
		return GSDZ;
	}

	public static void setGSDZ(String gSDZ) {
		GSDZ = gSDZ;
	}

	public static String getZWS() {
		return ZWS;
	}

	public static void setZWS(String zWS) {
		ZWS = zWS;
	}

	public static String getSJUSER() {
		return SJUSER;
	}

	public static void setSJUSER(String sJUSER) {
		SJUSER = sJUSER;
	}

	public static String getSJPWD() {
		return SJPWD;
	}

	public static void setSJPWD(String sJPWD) {
		SJPWD = sJPWD;
	}

	public static String getNGINXSERVER() {
		return NGINXSERVER;
	}

	public static void setNGINXSERVER(String nGINXSERVER) {
		NGINXSERVER = nGINXSERVER;
	}

	public static String getNGINXSNAME() {
		return NGINXSNAME;
	}

	public static void setNGINXSNAME(String nGINXSNAME) {
		NGINXSNAME = nGINXSNAME;
	}

	public static String getNGINXSPWD() {
		return NGINXSPWD;
	}

	public static void setNGINXSPWD(String nGINXSPWD) {
		NGINXSPWD = nGINXSPWD;
	}

	public static String getSERVERHOST() {
		return SERVERHOST;
	}

	public static void setSERVERHOST(String sERVERHOST) {
		SERVERHOST = sERVERHOST;
	}

	public static String getSERVERPOST() {
		return SERVERPOST;
	}

	public static void setSERVERPOST(String sERVERPOST) {
		SERVERPOST = sERVERPOST;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public static String getNOTIFYURL() {
		return NOTIFYURL;
	}

	public static void setNOTIFYURL(String nOTIFYURL) {
		NOTIFYURL = nOTIFYURL;
	}

	public static String getRETURNURL() {
		return RETURNURL;
	}

	public static void setRETURNURL(String rETURNURL) {
		RETURNURL = rETURNURL;
	}

	public static String getAPPID() {
		return APPID;
	}

	public static void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public static String getALIPAYURL() {
		return ALIPAYURL;
	}

	public static void setALIPAYURL(String aLIPAYURL) {
		ALIPAYURL = aLIPAYURL;
	}

	public static String getNETWORKSERVER() {
		return NETWORKSERVER;
	}

	public static void setNETWORKSERVER(String nETWORKSERVER) {
		NETWORKSERVER = nETWORKSERVER;
	}

	public static String getGYWMLXDH() {
		return GYWMLXDH;
	}

	public static void setGYWMLXDH(String gYWMLXDH) {
		GYWMLXDH = gYWMLXDH;
	}

	public static String getGYWMRCJS() {
		return GYWMRCJS;
	}

	public static void setGYWMRCJS(String gYWMRCJS) {
		GYWMRCJS = gYWMRCJS;
	}

	public static String getGYWMWZ() {
		return GYWMWZ;
	}

	public static void setGYWMWZ(String gYWMWZ) {
		GYWMWZ = gYWMWZ;
	}

	public static String getPICTURESERVER() {
		return PICTURESERVER;
	}

	public static void setPICTURESERVER(String pICTURESERVER) {
		PICTURESERVER = pICTURESERVER;
	}

	public static String getSUCCODE() {
		return SUCCODE;
	}

	public static void setSUCCODE(String sUCCODE) {
		SUCCODE = sUCCODE;
	}

	public static String getSCJLYXQ() {
		return SCJLYXQ;
	}

	public static void setSCJLYXQ(String sCJLYXQ) {
		SCJLYXQ = sCJLYXQ;
	}

	public static String getWSYDXCZWJZSJ() {
		return WSYDXCZWJZSJ;
	}

	public static void setWSYDXCZWJZSJ(String wSYDXCZWJZSJ) {
		WSYDXCZWJZSJ = wSYDXCZWJZSJ;
	}

	public static String getWSZFKDF() {
		return WSZFKDF;
	}

	public static void setWSZFKDF(String wSZFKDF) {
		WSZFKDF = wSZFKDF;
	}

	public static String getDXDJ() {
		return DXDJ;
	}

	public static void setDXDJ(String dXDJ) {
		DXDJ = dXDJ;
	}

	public static String getZPDSDJ() {
		return ZPDSDJ;
	}

	public static void setZPDSDJ(String zPDSDJ) {
		ZPDSDJ = zPDSDJ;
	}

	public static String getEJYMHZ() {
		return EJYMHZ;
	}

	public static void setEJYMHZ(String eJYMHZ) {
		EJYMHZ = eJYMHZ;
	}

	public static String getJLDSDJ() {
		return JLDSDJ;
	}

	public static void setJLDSDJ(String jLDSDJ) {
		JLDSDJ = jLDSDJ;
	}

	public static String getXSZWYXQ() {
		return XSZWYXQ;
	}

	public static void setXSZWYXQ(String xSZWYXQ) {
		XSZWYXQ = xSZWYXQ;
	}

	public static String getRDTBDJ() {
		return RDTBDJ;
	}

	public static void setRDTBDJ(String rDTBDJ) {
		RDTBDJ = rDTBDJ;
	}

	public static String getBANNERDJ() {
		return BANNERDJ;
	}

	public static void setBANNERDJ(String bANNERDJ) {
		BANNERDJ = bANNERDJ;
	}

	public static String getWTZPDJ() {
		return WTZPDJ;
	}

	public static void setWTZPDJ(String wTZPDJ) {
		WTZPDJ = wTZPDJ;
	}

	public static String getBHSCCSZ() {
		return BHSCCSZ;
	}

	public static void setBHSCCSZ(String bHSCCSZ) {
		BHSCCSZ = bHSCCSZ;
	}

	public static void setTEST(String tEST) {
		TEST = tEST;
	}

	public static String getSFKQ3LZW() {
		return SFKQ3LZW;
	}

	public static void setSFKQ3LZW(String sFKQ3LZW) {
		SFKQ3LZW = sFKQ3LZW;
	}

	public static String getSFKQ2LZW() {
		return SFKQ2LZW;
	}

	public static void setSFKQ2LZW(String sFKQ2LZW) {
		SFKQ2LZW = sFKQ2LZW;
	}

	public static int getPAGESIZE() {
		return PAGESIZE;
	}

	public static void setPAGESIZE(int pAGESIZE) {
		PAGESIZE = pAGESIZE;
	}

	public static String getSQZWSL() {
		return SQZWSL;
	}

	public static void setSQZWSL(String sQZWSL) {
		SQZWSL = sQZWSL;
	}

	public static String getSCZWYXQ() {
		return SCZWYXQ;
	}

	public static void setSCZWYXQ(String sCZWYXQ) {
		SCZWYXQ = sCZWYXQ;
	}

	public static String getXCZPZWSDSJ() {
		return XCZPZWSDSJ;
	}

	public static void setXCZPZWSDSJ(String xCZPZWSDSJ) {
		XCZPZWSDSJ = xCZPZWSDSJ;
	}

	public static String getZPHLC2L() {
		return ZPHLC2L;
	}

	public static void setZPHLC2L(String zPHLC2L) {
		ZPHLC2L = zPHLC2L;
	}

	public static String getZPHLC3L() {
		return ZPHLC3L;
	}

	public static void setZPHLC3L(String zPHLC3L) {
		ZPHLC3L = zPHLC3L;
	}

	public static String getJLSL() {
		return JLSL;
	}

	public static void setJLSL(String jLSL) {
		JLSL = jLSL;
	}

	public static String getJYBJSL() {
		return JYBJSL;
	}

	public static void setJYBJSL(String jYBJSL) {
		JYBJSL = jYBJSL;
	}

	public static String getGZJYSL() {
		return GZJYSL;
	}

	public static void setGZJYSL(String gZJYSL) {
		GZJYSL = gZJYSL;
	}

	public static String getXMJYSL() {
		return XMJYSL;
	}

	public static void setXMJYSL(String xMJYSL) {
		XMJYSL = xMJYSL;
	}

	public static String getGRZSSL() {
		return GRZSSL;
	}

	public static void setGRZSSL(String gRZSSL) {
		GRZSSL = gRZSSL;
	}

	public static String getYYNLSL() {
		return YYNLSL;
	}

	public static void setYYNLSL(String yYNLSL) {
		YYNLSL = yYNLSL;
	}

	public static String getTDJLYXQ() {
		return TDJLYXQ;
	}

	public static void setTDJLYXQ(String tDJLYXQ) {
		TDJLYXQ = tDJLYXQ;
	}

	public static String getXCTDJLYXQ() {
		return XCTDJLYXQ;
	}

	public static void setXCTDJLYXQ(String xCTDJLYXQ) {
		XCTDJLYXQ = xCTDJLYXQ;
	}

	public static String getJLBCKYXQ() {
		return JLBCKYXQ;
	}

	public static void setJLBCKYXQ(String jLBCKYXQ) {
		JLBCKYXQ = jLBCKYXQ;
	}

	public static String getJLBSCYXQ() {
		return JLBSCYXQ;
	}

	public static void setJLBSCYXQ(String jLBSCYXQ) {
		JLBSCYXQ = jLBSCYXQ;
	}

	public static String getPBDWSL() {
		return PBDWSL;
	}

	public static void setPBDWSL(String pBDWSL) {
		PBDWSL = pBDWSL;
	}

	public static String getGMJLYXQ() {
		return GMJLYXQ;
	}

	public static void setGMJLYXQ(String gMJLYXQ) {
		GMJLYXQ = gMJLYXQ;
	}

	public static String getJLDS() {
		return JLDS;
	}

	public static void setJLDS(String jLDS) {
		JLDS = jLDS;
	}

	public static String getDXTS() {
		return DXTS;
	}

	public static void setDXTS(String dXTS) {
		DXTS = dXTS;
	}

	public static String getWTZPZWSDSJ() {
		return WTZPZWSDSJ;
	}

	public static void setWTZPZWSDSJ(String wTZPZWSDSJ) {
		WTZPZWSDSJ = wTZPZWSDSJ;
	}

	public static String getSPJJYXQ() {
		return SPJJYXQ;
	}

	public static void setSPJJYXQ(String sPJJYXQ) {
		SPJJYXQ = sPJJYXQ;
	}

	public static String getWSPYXQ() {
		return WSPYXQ;
	}

	public static void setWSPYXQ(String wSPYXQ) {
		WSPYXQ = wSPYXQ;
	}

	public static String getXCZPZWYXQ() {
		return XCZPZWYXQ;
	}

	public static void setXCZPZWYXQ(String xCZPZWYXQ) {
		XCZPZWYXQ = xCZPZWYXQ;
	}

	public static String getSJYZMYXQ() {
		return SJYZMYXQ;
	}

	public static void setSJYZMYXQ(String sJYZMYXQ) {
		SJYZMYXQ = sJYZMYXQ;
	}

	public static String getYXJHMYXQ() {
		return YXJHMYXQ;
	}

	public static void setYXJHMYXQ(String yXJHMYXQ) {
		YXJHMYXQ = yXJHMYXQ;
	}

	public static String getGYRCZYWZ() {
		return GYRCZYWZ;
	}

	public static void setGYRCZYWZ(String gYRCZYWZ) {
		GYRCZYWZ = gYRCZYWZ;
	}

	public static String getWZYHHCWJLJ() {
		return WZYHHCWJLJ;
	}

	public static void setWZYHHCWJLJ(String wZYHHCWJLJ) {
		WZYHHCWJLJ = wZYHHCWJLJ;
	}

	public static String getJLHCWJLJ() {
		return JLHCWJLJ;
	}

	public static void setJLHCWJLJ(String jLHCWJLJ) {
		JLHCWJLJ = jLHCWJLJ;
	}

	public static String getHTTJBANNERSL() {
		return HTTJBANNERSL;
	}

	public static void setHTTJBANNERSL(String hTTJBANNERSL) {
		HTTJBANNERSL = hTTJBANNERSL;
	}

	public static String getDWGMBANNERSL() {
		return DWGMBANNERSL;
	}

	public static void setDWGMBANNERSL(String dWGMBANNERSL) {
		DWGMBANNERSL = dWGMBANNERSL;
	}

	public static String getTPYSMODENAME() {
		return TPYSMODENAME;
	}

	public static void setTPYSMODENAME(String tPYSMODENAME) {
		TPYSMODENAME = tPYSMODENAME;
	}

	public static String getTPYSXZSIZE() {
		return TPYSXZSIZE;
	}

	public static void setTPYSXZSIZE(String tPYSXZSIZE) {
		TPYSXZSIZE = tPYSXZSIZE;
	}

	public static String getTPYSQUALITY() {
		return TPYSQUALITY;
	}

	public static void setTPYSQUALITY(String tPYSQUALITY) {
		TPYSQUALITY = tPYSQUALITY;
	}

	public static String getFXCZPZWSDSJ() {
		return FXCZPZWSDSJ;
	}

	public static void setFXCZPZWSDSJ(String fXCZPZWSDSJ) {
		FXCZPZWSDSJ = fXCZPZWSDSJ;
	}

	public static String getDDHYZLJ() {
		return DDHYZLJ;
	}

	public static void setDDHYZLJ(String dDHYZLJ) {
		DDHYZLJ = dDHYZLJ;
	}

	public static String getDDHEWM() {
		return DDHEWM;
	}

	public static void setDDHEWM(String dDHEWM) {
		DDHEWM = dDHEWM;
	}

	public static String getKJZMHJYZ() {
		return KJZMHJYZ;
	}

	public static void setKJZMHJYZ(String kJZMHJYZ) {
		KJZMHJYZ = kJZMHJYZ;
	}

	public static String getRSDLRYWYH() {
		return RSDLRYWYH;
	}

	public static void setRSDLRYWYH(String rSDLRYWYH) {
		RSDLRYWYH = rSDLRYWYH;
	}

	/**
	 * 家庭成员数量
	 */
	private static String JTCYSL;
	/**
	 * 申请服务数量
	 */
	private static String SQFWSL;
	/**
	 * 医保兑现数量
	 */
	private static String YBDXSL;
	/**
	 * 生活补贴数量
	 */
	private static String SHBTSL;
	/**
	 * 住房补贴数量
	 */
	private static String ZFBTSL;
	/**
	 * 专业技术职务数量
	 */
	private static String ZYJSZWSL;
	/**
	 * 职业资格等级证书数量
	 */
	private static String ZYZGDJZSSL;

	/**
	 * 人工排序重点企业数
	 */
	private static String RGPXZDQYS;

	/**
	 *活跃度排序重点企业
	 */
	private static String HYPXZDQY;
	/**
	 * 置顶重点企业数
	 */
	private static String ZDZDQYS;
	/***
	 * 富文本文件地址
	 * @return
	 */
	private static String FWBWJDZ;

	public static String getJTCYSL() {
		return JTCYSL;
	}

	public static void setJTCYSL(String jTCYSL) {
		JTCYSL = jTCYSL;
	}

	public static String getSQFWSL() {
		return SQFWSL;
	}

	public static void setSQFWSL(String sQFWSL) {
		SQFWSL = sQFWSL;
	}

	public static String getYBDXSL() {
		return YBDXSL;
	}

	public static void setYBDXSL(String yBDXSL) {
		YBDXSL = yBDXSL;
	}

	public static String getSHBTSL() {
		return SHBTSL;
	}

	public static void setSHBTSL(String sHBTSL) {
		SHBTSL = sHBTSL;
	}

	public static String getZFBTSL() {
		return ZFBTSL;
	}

	public static void setZFBTSL(String zFBTSL) {
		ZFBTSL = zFBTSL;
	}

	public static String getZYJSZWSL() {
		return ZYJSZWSL;
	}

	public static void setZYJSZWSL(String zYJSZWSL) {
		ZYJSZWSL = zYJSZWSL;
	}

	public static String getZYZGDJZSSL() {
		return ZYZGDJZSSL;
	}

	public static void setZYZGDJZSSL(String zYZGDJZSSL) {
		ZYZGDJZSSL = zYZGDJZSSL;
	}

	public static String getDWXYZ() {
		return DWXYZ;
	}

	public static void setDWXYZ(String DWXYZ) {
		SxAppConfig.DWXYZ = DWXYZ;
	}

	public static String getFWBZSZDZ() {
		return FWBZSZDZ;
	}

	public static void setFWBZSZDZ(String fWBZSZDZ) {
		FWBZSZDZ = fWBZSZDZ;
	}

	public static String getRGPXZDQYS() {
		return RGPXZDQYS;
	}

	public static void setRGPXZDQYS(String rGPXZDQYS) {
		RGPXZDQYS = rGPXZDQYS;
	}

	public static String getHYPXZDQY() {
		return HYPXZDQY;
	}

	public static void setHYPXZDQY(String hYPXZDQY) {
		HYPXZDQY = hYPXZDQY;
	}

	public static String getZDZDQYS() {
		return ZDZDQYS;
	}

	public static void setZDZDQYS(String zDZDQYS) {
		ZDZDQYS = zDZDQYS;
	}

	public static String getFWBWJDZ() {
		return FWBWJDZ;
	}

	public static void setFWBWJDZ(String fWBWJDZ) {
		FWBWJDZ = fWBWJDZ;
	}

}
