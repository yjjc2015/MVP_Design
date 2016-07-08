package com.wxj.mvp_design.global;

import android.util.LruCache;

public class Constant {
     public static final String BASE_URL = "http://112.124.61.7:8086/";//测试地址
    /**
     * 请求验证码（新接口 判断是否注册过e修）
     */
    public static final String REQUEST_CODE = BASE_URL + "exiu/sendWorkerSms";
    /**
     * 检查验证码是否匹配(2016/5/3)
     */
    public static final String CHECK_CODE = BASE_URL + "exiu/checkWorkerSms";
    /**
     * 修改密码(2016/5/3)
     */
    public static final String ALTER_PWD = BASE_URL + "exiu/changeWorkerPwd";
    /**
     * 登录请求地址(2016/5/3)
     */
    public static final String WORKER_LOGIN = BASE_URL + "exiu/workerLogin2";
    /**
     * 修改设计师信息
     * 修改工长信息
     */
    public static final String UPDATE_DESIGNER_INFO = BASE_URL + "exiu/updatedesignerInfo";
    public static final String UPDATE_WORKER_INFO = BASE_URL + "exiu/updateworkerInfo";
    public static final String ALTER_INFO22 = BASE_URL + "exiu/updateworkerInfos";
    /**
     * 提交设计师认证信息
     * 提交工长认证信息
     */
    public static final String DESIGNER_CERTIFICATE = BASE_URL + "exiu/updatedesignersignInfo";
    public static final String WORKER_CERTIFICATE = BASE_URL + "exiu/updateWorkerSignInfo";
    /**
     * 获取设计师工地列表
     * 获取工长工地列表
     */
    //public static final String WORKER_SITE_LIST = BASE_URL + "exiu/getWorkerHouseList";

    public static final String WORKER_SITE_LIST = BASE_URL + "exiu/getWorkerSignList";

    /**
     * 设置工地状态为待确认
     */
    public static final String UPDATE_HOUSE_PROGRESS = BASE_URL + "exiu/updateHouseProgress";

    /**
     * 发布工地动态 （新接口）
     */
    public static final String WORKER_MOMENTS = BASE_URL + "exiu/addWorkerDyna2";
    /**
     * 删除工地动态
     */
    public static final String WORKER_MOMENTS_DELETE = BASE_URL + "exiu/delHouseDyna";

    /**
     * 发布设计师作品
     */
    public static final String DESIGNER_CASE = BASE_URL + "exiu/adddesignercase";
    /**
     * 获取账户总金额
     */
    public static final String HQJE = BASE_URL + "exiu/gettotalfee";
    /**
     * 申请提现
     */
    public static final String SQTX = BASE_URL + "exiu/applytakecash";
    /**
     * 获取设计师入账列表
     * 获取工长入账列表
     */
    public static final String DSRZ = BASE_URL + "exiu/getdesignersignlist";
    public static final String GZRZ = BASE_URL + "exiu/getworkerputinlist";
    /**
     * 获取设计师出账列表
     * 获取工长出账列表
     */
    public static final String DGCZ = BASE_URL + "exiu/gettakecashlist";
    /**
     * 获取设计师签约列表
     * 获取工长签约列表
     */
    public static final String SIGN = BASE_URL + "exiu/getdesignersignlist";

    public static final String SIGNG = BASE_URL + "exiu/getWorkerSignList";
    /**
     * 根据工地ID，查询工地详情
     */
    public static final String GET_HOUSE_DETAIL = BASE_URL + "exiu/gethousedetail";
    /**
     * 获取指定工地的付款
     */
    public static final String GET_HOUSE_PAY_STATUS = BASE_URL + "exiu/getPayPhaseByHouseId";

    /**
     * 获取分期工程款列表
     */
    public static final String GET_STAGE_ORDER_LIST = BASE_URL + "exiu/getHouseOrderList";
    /**
     * 设计师签约
     * 工长签约
     */
    public static final String SJSSIGN = BASE_URL + "exiu/adddesignersign";
    public static final String GZSIGN = BASE_URL + "exiu/addWorkerSign2";//工长签约2.0版接口  新接口
    /**
     * <pre>
     * 31.	获取工地动态列表
     * 	参数： 	houseId 工地id
     * 		currentNum(可选) 当前页
     * </pre>
     */
    public static final String GET_SITE_MOMENTS = BASE_URL + "exiu/getHouseDynaList2";

    /**
     * <pre>
     * 40.	对工长动态点赞
     * 	参数： 	gsonStr：（必选）其中封装
     *        {
     *        dynaId (必选): 用户动态Id
     * 		userId (必选): 用户Id
     * 		commentTime (必选): 评论时间}
     * </pre>
     */
    public static final String COMMIT_GANGMASTER_DIANZAN_URL = BASE_URL + "exiu/addworkerdynapraise";
    /**
     * <pre>
     * 39.	对工长动态评论
     * 	参数： 	gsonStr：（必选）其中封装
     *        {
     *        dynaId (必选): 用户动态Id
     * 		userId (必选): 用户Id
     * 		toUserId (可选)：目标用户Id
     * 		commentContent (必选): 评论内容
     * 		commentTime (必选): 评论时间}
     *        }
     * </pre>
     */
    public static final String COMMIT_GANGMASTER_PINGLUN_URL = BASE_URL + "exiu/addworkerdynacomment";

    /**
     * <pre>
     * 11.	获取设计师作品
     * 	参数： 	designerId (可选): 设计师id
     * 		currentNum(可选) 当前页
     * </pre>
     */
    public static final String GET_DESGINER_CASES = BASE_URL + "exiu/getdesignercase";

    /**
     * <pre>
     * 13.	获取设计师作品点赞列表
     * 	参数： 	caseId (必选): 设计师作品id
     * 		currentNum(可选) 当前页 //不需要
     * </pre>
     */
    public static final String GET_DESIGNER_CASE_LIKES = BASE_URL + "exiu/getdesignercasepraiselist";

    /**
     * <pre>
     * 14.	获取设计师作品点赞列表
     * 	参数： 	caseId (必选): 设计师作品id
     * 		currentNum(可选) 当前页 //不需要
     * </pre>
     */
    public static final String GET_DESIGNER_CASE_COMMENTS = BASE_URL + "exiu/getdesignercasecommentlist";
    //    /**
//     * 工长动态列表(与工地动态列表共用一个接口)
//     */
    public static final String WORKER_MOMENTS_LIST = BASE_URL + "exiu/getHouseDynaList2";

    /**
     * 新接口,用来对数据的实时刷新
     */
    public static final String NEW = BASE_URL + "exiu/distinguish";
    /**
     * 获取合同
     */
    public static final String ORDERS = BASE_URL + "exiu/getContract";
    /**
     * 获取融云Token
     */
    public static final String TOKEN_DESIGNER = BASE_URL + "exiu/getDesignerToken";
    public static final String TOKEN_WORKER = BASE_URL + "exiu/getWorkerToken";
    /**
     * 获取系统信息
     */
    public static final String SYSTEM = BASE_URL + "wanmin/getsysteminfo";
    /**
     * 存储json到内存
     */
    private static LruCache<String, String> mMemoryCache;


    /**
     * 获取OSS临时秘钥
     */
    public static final String GET_OSSACCESS_KEY = BASE_URL + "exiu/getOSSAccessKey";


    /**
     * 存储压缩照片的临时文件夹名称
     */
    public static final String TEMP_IMAGE_DIR_NAME = "formats";

    /**
     * 更新工长联系人
     */
    public static final String UPDATE_WORKER_CONTACTS = BASE_URL + "exiu/updateWorkerContacts";

    /**
     * 更新工长常住区域
     */
    public static final String UPDATE_WORKER_ADDRESS = BASE_URL + "exiu/updateWorkerAddress";

    /**
     * 获取工长简历
     */
    public static final String GET_WORKER_RESUME = BASE_URL + "exiu/getWorkerResume";

    /**
     * 更新工长简历
     */
    public static final String UPDATE_WORKER_RESUME = BASE_URL + "exiu/updateWorkerResume";

    /**
     * 获取地域
     */
    public static final String FIND_REGIONS = BASE_URL + "exiu/findRegions";

    //========================辅料==================================================
    /**
     * 获得辅料类别列表
     */
    public static final String GET_ACCESSORY_TYPE_LIST = BASE_URL + "exiu/getAccessoryTypeList";
    /**
     * 根据类别获得辅料列表
     */
    public static final String GET_ACCESSORY_LIST = BASE_URL + "exiu/getAccessoryList";
    /**
     * 根据名称查询辅料列表
     */
    public static final String SEARCH_ACCESSORY_LIST = BASE_URL + "exiu/searchAccessoryList";
    /**
     * 添加辅料购物车
     */
    public static final String ADD_ACCESSORY_CART = BASE_URL + "exiu/addAccessoryCart";
    /**
     * 取消辅料购物车
     */
    public static final String CANCEL_ACCESSORY_CART = BASE_URL + "exiu/cancelAccessoryCart";
    /**
     * 根据订单ID获得辅料购物车
     */
    public static final String GET_ACCESSORY_CART_INORDER = BASE_URL + "exiu/getAccessoryCartInOrder";
    /**
     * 根据工长ID获得辅料购物车
     */
    public static final String GET_CART_ACCESSORY_LIST = BASE_URL + "exiu/getCartAccessoryList";
    /**
     * 添加辅料订单信息
     */
    public static final String ADD_ACCESSORY_ORDER = BASE_URL + "exiu/addAccessoryOrder";
    /**
     * 取消辅料订单信息
     */
    public static final String CANCEL_ACCESSORY_ORDER = BASE_URL + "exiu/cancelAccessoryOrder";
    /**
     * 根据工长ID获得全部订单列表
     */
    public static final String GET_ACCESSORY_ORDER_LIST = BASE_URL + "exiu/getWorkerAccessoryOrder";
    /**
     * 根据工长ID获得未发货订单列表
     */
    public static final String GET_WAIT_DELIEVE_ACCESSORY_ORDER_LIST = BASE_URL + "exiu/getWaitDelieveAccessoryOrderList";
    /**
     * 根据工长ID获得未付款订单列表
     */
    public static final String GET_WAIT_PAY_ACCESSORY_ORDER_LIST = BASE_URL + "exiu/getWaitPayAccessoryOrderList";
    /**
     * 更新辅料订单的支付类型
     */
    public static final String UPDATEA_CCESSORY_ORDER_PAY_TYPE = BASE_URL + "exiu/updateAccessoryOrderPayType";
    /**
     * 辅料订单支付宝付款
     */
    public static final String PAY_ACCESSORY_ORDER = BASE_URL + "exiu/payAccessoryOrder";
    /**
     * 确认辅料订单付款状态
     */
    public static final String CONFIRM_ACCESSORY_PAY = BASE_URL + "exiu/confirmAccessoryPay";
    /**
     * 确认辅料订单发货状态
     */
    public static final String CONFIRM_ACCESSORY_DELIVER = BASE_URL + "exiu/confirmAccessoryDeliver";

    /**
     * 压缩后的图片最大宽高
     */
    public static final int MAX_COMPRESSED_IMAGE_WIDTH = 1000;
    public static final int MAX_COMPRESSED_IMAGE_HEIGHT = 1000;

    public static void initData() {
        // 获取到可用内存的最大值，使用内存超出这个值会引起OutOfMemory异常。
        // LruCache通过构造函数传入缓存值，以KB为单位。
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 使用最大可用内存值的1/8作为缓存的大小。
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, String>(cacheSize) {
            @Override
            protected int sizeOf(String key, String str) {
                // 重写此方法来衡量每张图片的大小，默认返回图片数量。
                return str.getBytes().length / 1024;
            }
        };
    }

    public static void addJsonToMemoryCache(String key, String json) {
        mMemoryCache.put(key, json);
    }

    public static void delJsonToMemoryCache(String key) {
        mMemoryCache.put(key, "");
    }

    public static String getJsonFromMemCache(String key) {
        return mMemoryCache.get(key);
    }

    public static final String LOG_TAG = " _always_a_good_time";

}
