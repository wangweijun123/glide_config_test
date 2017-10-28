package com.example.wangweijun.glide_config_test.model;

import java.io.Serializable;
import java.util.List;

/**
 * 示例数据 "packageName": "com.kugou.android", "appName": "酷狗音乐", "installedCount": "97110000",
 * "likeCount": "13068", "commentCount": "17568", "updateDate": "2014-05-28", "superScriptImgUrl":
 * null, "size": "8831266",
 * 
 * @author Will
 */
public class AppBaseModel implements Serializable,Comparable<AppBaseModel> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4320944522301838836L;
	/**
	 * 
	 */
	public String keySetGuide;
	public int keyGroup;
	
	public static final String MODEL_FOCUSPIC="focuspic";
	public static final String MODEL_ITEM="item";
	public static final String MODEL_LIST="list";
	public static final String DATATYPE_APP="app";
	public static final String DATATYPE_THEME="theme";
	public static final String DATATYPE_ACTION="action";
	public static final String DATATYPE_GIFT="gift";
	public static final String DATATYPE_VIDEO = "video";
	public static final String DATATYPE_PIC = "pic";
	public static final String DATATYPE_RESERVE="reserve";
	public static final String DATATYPE_1010="1010";
	public static final String DETAIL_TYPE_RESERVEACTION="reserveaction";
	public static final String DETAIL_TYPE_COUPONACTION="couponaction";
	public static final String DETAIL_TYPE_AGIOACTION="agioaction";
	public static final String DETAIL_TYPE_GIFT="gift";
	public static final String DETAIL_TYPE_SECKILLACTION="seckillaction";
	
	/** 免费下载 */ 
	public static final int DOWNLOAD_TYPE_FREE = 0;
	/** 付费下载 */
	public static final int DOWNLOAD_TYPE_PAY = 1;
	/** 未购买 */
	public static final int PURCHASED_NEED = 0;
	/** 已购买 */
	public static final int PURCHASED_ALREADY = 1;
	/** 限免 */
	public static final int SALESOFF_LIMIT_FREE = 0;
	/** 优惠 */
	public static final int SALESOFF_FAVORABLE = 1;
	
	/** 1：删档内测 */
	public static final int OPEN_TEST_TYPE_DELETE_FILES_INNER_TEST = 1;
	/** 2: 删档封测 */
	public static final int OPEN_TEST_TYPE_DELETE_FILES_ONLINE_TEST = 2;
	/** 3: 不删档测试  */
	public static final int OPEN_TEST_TYPE_SAVE_FILES_INNER_TEST = 3;
	/** 4: 公测 */
	public static final int OPEN_TEST_TYPE_ONLINE_TEST = 4;

	public static final String DOWNLOAD_FILE_TYPE_APK = "apk";

	public static final String DOWNLOAD_FILE_TYPE_DIFF = "diff";
	
	public String appName;
	public String installedCount;
	public int commentcount;
	public String releasedate;
	public String superScriptImgUrl;
	public String url;
	public String actionurl;
	public int ad;
	public int useAge;
	public String datatype;
	public String detailtype;
	public int downloadcount;
	public String editorcomment;
	public int zancount;
	public float score;
	public int categoryid;
	public int subcategoryid;
	public String categoryname;
    public String subcategoryname;
    public String subsubcategoryname;
    public int subsubcategoryid;
	public String from_page;
	public int from_position;

	public boolean isFromUpdateAll;
    // 是否适配超级手机
    public int accommodable;
    // super 超级标签
    public String superscript;
    //官方标签
    public String official;
    //首发角标
    public int firstpublish;
    //礼包标签
    public int hasgift;//0没有礼包，1是有礼包
    public int hasaction;//0没有，1是有奖
    public int coupon;//1是返利
	public class Icon implements Serializable {
		public String url;
	}

	public Icon icon = new Icon();
	public int id;
	public String global_id;
	public String model;
	public String name;
	public String packagename;
	public int reservecount;
	public String publishdate;

	public class Pic implements Serializable {
		public String url;
	}

	public Pic pic;
	public int seq;
    public long showtime;// 文档未定义
	public long size;
	public String subname;

    public String keyWord;
	public class SuperScriptimg implements Serializable {
		public String url;
	}

	public SuperScriptimg superscriptimg;
    public int tvappid;// 文档未定义
	public String version;
	public int versioncode;
	public int zan;

    public int collect; // 1:表示收藏 0：表示未收藏
    public String likeCount;// 有页面依赖此进行分类做假数据，稍后需要修改
	
	public String downloadurl;
	public String diffdownloadurl;
	public int diffsize;
	public int diffeconomizesize;

    public String downloadFrom;
    
    public String eidstring;
    
    public Saction saction;
	public boolean isExpand;
	public String themeUrl;
	public String btColor;
	
	public int onebox;
	public String screenshotmodel;//vertical,horizontal
	public List<String> screenshot;

	public static class Saction implements Serializable {
		public int id;
		public String name;
		public String expiredate;
		public String shortDesc;
		public int partinNo;
		public Icon pic;
	}
	

	public boolean isReserve;
	public String reserveUrl;
	
	/** 付费下载相关 */
	public int ispay;
	public int purchased;
	public float price;
	public int salesoff;
	
	/** mode是否为下载推荐 */
	public boolean isDownloadRecommand = false;
	/** 是否显示分割线 */
	public boolean showSeparateLine = false;
	
	public String giftName;
	
	public boolean isChecked = false;
	public boolean isInstalled = false;
	public int defaultInstall = 0;
	
	/** 标识mode是否来自FocusList */
	public boolean isFromFocusList = false;
	
	/** 如下字段为统计使用 */
	public String source;
	public String reid;
	public String bucket;
	public String eid;
	public String experiment_str;
	public String trigger_str;
	public String mseid;// 应用商店eid
	public String adeid;
	public String adid;
	/** AD 广告url */
	public String adexposeurl;
	public String adclickurl;
	public String adtrackurl;
	public String adinstallurl;
   	public String adOpenDeepLink;
	public String adOpenAppUrl;
	//deepLink intent,如果此字段不为空，则使用匿名intent方式打开应用
	public String deepLink;
	//下载来源标记，标记是否是用户点击发起的下载
	public String fromFlag;

	// 历史版本apk的md5值，与本地apk文件MD5做对比
	public String historyversionmd5;
	// 下载类型
	public String downloadFiletype;
	public int isshow;


	@Override
	public String toString() {
		return "AppBaseModel [appName=" + appName + ", installedCount=" + installedCount + ", commentCount=" + commentcount + ", releasedate=" + releasedate + ", superScriptImgUrl=" + superScriptImgUrl + ", url=" + url + ", actionurl=" + actionurl
				+ ", ad=" + ad + ", datatype=" + datatype + ", detailtype:"+detailtype +  ", downloadcount=" + downloadcount + ", editorcomment=" + editorcomment + ", zancount=" + zancount + ", score=" + score + ", subcategoryid=" + subcategoryid + ", icon=" + icon + ", id="
				+ id + ", model=" + model + ", name=" + name + ", packagename=" + packagename + ", pic=" + pic + ", price=" + price + ", seq=" + seq + ", showtime=" + showtime + ", size=" + size + ", subname=" + subname + ", superscriptimg="
				+ superscriptimg + ", tvappid=" + tvappid + ", version=" + version + ", versioncode=" + versioncode + ", zan=" + zan + ", likeCount=" + likeCount + "]";
	}

	@Override
	public int compareTo(AppBaseModel another) {
		int result = 0;
		if(useAge < another.useAge)
		{
			result = -1;
		}else if (useAge > another.useAge){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}
}
