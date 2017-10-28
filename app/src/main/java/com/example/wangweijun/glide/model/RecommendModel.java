package com.example.wangweijun.glide.model;

import java.util.List;

/**
 * "name": "首页精品推荐", "code": "REC_CLASSIC_INDEX", "subname": "", "items": [ {
 * "datatype": "app", "name": "去哪儿旅行", "showtime": -1, "seq": 1, "id": 127092,
 * "model": "", "pic": { "url": "" }, "packagename": "com.Qunar", "tvappid": -1,
 * "subname": "机票酒店火车票旅游", "editorcomment":
 * "总有你要的低价。机票酒店.火车票.旅游团购.出租叫车.景点门票，应有尽有。", "versioncode": -1, "version":
 * "7.2.7", "price": 0, "ad": -1, "size": 15731886, "zancount": 0,
 * "downloadcount": 6635898, "tag": "出行必用,便捷生活,旅游,票务,", "icon": { "url":
 * "http://img.wdjimg.com/mms/icon/v1/6/4e/01602a98d5813728b8cc200e994de4e6_256_256.png"
 * }, "superscriptimg": { "url": "" }, "actionurl": "" },
 * 
 * @author Will
 */
public class RecommendModel {
	/** 定义四种不同的type-------------------------------- */
	public static final String TYPE_URL = "action";
	public static final String TYPE_SUBJECT = "theme";
	public static final String TYPE_APP = "app";
	public static final String TYPE_GIFT = "gift";
	public static final String TYPE_AGIOURL = "agioaction";
	/**------------------------------------------------*/
	
	public String name;
	public String code;
	public String subname;
	public int total;
	public List<RankRecommedModel> items;
	
	public class RankRecommedModel extends AppBaseModel{
		public boolean hasUpdate;
		public boolean isCanDiffUpdate = false;
	
	}
}
