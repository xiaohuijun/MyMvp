#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

/**
 * 生产环境(正式)
 */
#define URL_OFFICAL "http://www.lie98.com/lieyu/"
#define URL_OFFICAL_PORTAL "http://www.lie98.com/portal/"

/**
 * 测试环境( 阿里云主机测试)
 */
#define URL_PRE_OFFICAL "http://121.40.229.133:9080/lieyu/"
#define URL_PRE_OFFICAL_PORTAL "http://121.40.229.133:8090/portal/"

/**
 * 本地主机测试环境(本地主机测试)
 */
#define URL_LOCAL_TEST "http://121.40.229.133:9080/lieyu/"
#define URL_LOCAL_TEST_PORTAL "http://121.40.229.133:8090/portal/"
/**
 *App更新
 */
#define APP_VERSION "versionAction.do?action=list"
/**
 *目前未使用
 */
#define UM_DEVICES_TOKEN ""

/**
 *  Alipay 回调地址
 */
#define ALIPAY_NOTIFY_URL "alipayOrderAction.do"
/**
 * RongIM
 *
 */
/**
 * 获取融云token
 */
#define IM_TOKEN "friendAction.do?action=custom"
/**
 *  获取好友列表
 */
#define GET_FRIEND_LIST "friendAction.do?action=list"

/**
 *  请求心跳 7牛图片
 */
#define QN_PIC "fileServerAction.do?action=cancel"

/**
 *  请求心跳 7牛视频
 */
#define QN_VIDEO "fileServerAction.do?action=login"

/**
 * 绑定QQ、微信、微博（已注册、未登录）
 **/
#define BIND_NOLOGIN "osregisterAction.do?action=cancel"

/**
 * 绑定QQ、微信、微博（已注册、已登录）
 **/
#define BIND_LOGIN "usersAction.do?action=expand"

/**
 * 登录发送验证码
 **/
#define MINE_QRCODE "lyQRCodeAction?action=custom"
/**
 * 注册发送验证码 绑定手机使用
 **/
#define VERIFY_CODE_BIND "registerAction.do?action=login"
/**
 * 登录
 **/
#define LOGIN "accountAction.do?action=login"
/**
 * 注册
 **/
#define REGISTER "registerAction.do?action=add"
/**
 * 注册发送验证码
 **/
#define REGISTER_VERIFYCODE "registerAction.do?action=custom"
/**
 * 获取推荐玩友列表
 */
#define ACTIVUSER "app/api/user/activeUser"
/**
 * 提交选中推荐玩友
 */
#define ACTIVUSER_FOLLOW "app/api/sns/followUserList"
/**
 * 忘记密码
 **/
#define FORGET_PWD "registerAction.do?action=update"
/**
 * 忘记密码发送验证码
 **/
#define FORGET_PWD_VERIFYCODE "registerAction.do?action=list"
/**
 * 修改昵称和头像
 **/
#define USER_MODIFY_INFO "accountAction.do?action=save"
/**
 * 首页“娱乐顾问”页面使用方法
 */
#define LIE_ENTERTAINMENT_CONSULTANTS "lyUsersVipApplyOutAction.do?action=logout"
/**
 * 首页“夜店、酒吧” 搜索酒吧,夜店
 */
#define ENTERTAINMENT_HUNTING_SEARCH_BAR_NIGHT_CLUB "toPlayAction.do?action=list"
/**
 * 首页“夜店、酒吧” 搜索直播
 */
#define ENTERTAINMENT_HUNTING_SEARCH_LIVING "app/api/liveroom/list"
/**
 * 首页“夜店、酒吧”页面使用方法
 */
#define LIE_BAR_NIGHTCLUBS "toPlayAction.do?action=list"
/**
  * 获取城市是否开通
  */
#define ENTERTAINMENT_HUNTING_BAR_CITY_STATUS "lieAction.do?action=custom"
/**
 * 首页“夜店、酒吧”页面使用方法(上部分)
 */
#define ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS_TOP "lieAction.do?action=list"
/**
 * 首页“夜店、酒吧”页面使用方法(下部分)
 */
#define ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS "lieAction.do?action=expand"
/**
 * 首页 获取界面banner
 * {
 * "interfaceTypeId":"页面类型ID" //1：我要玩，2：一起玩，3：娱乐顾问，4：直播，5：活动派对"，
 * p=1(页码)
 * per=20(每页多少笔记录 默认20)
 * <p/>
 * }
 */
#define ENTERTAINMENT_HUNTING_BANNER "lybannerimagesAction2.do?action=expand"
/**
 * 获取话题类别
 * {
 * 两个参数都不传，获取所有话题；type为1，barid不传，获取所有酒吧话题；type为1，barid传值，获取相应酒吧话题；type为2，获取除酒吧话题之外的话题
 * "type":"话题类别类型",
 * "barid":"酒吧Id"
 * }
 */
#define TOPIC_TYPE "lyTopicTypeAction.do?action=list"

/**
 * 根据话题ID获取玩友圈动态
 */
#define TOPIC_TYPE_MOVING_LIST "lyMomentsOutAction.do?action=expand"
/**
 * 攻略
 */
/**
 * 获取攻略列表
 */
#define RAIDERS_LIST "strategyAction.do?action=expand"
/**
 * 获取攻略详情
 */
#define RAIDERS_INFO "strategyAction.do?action=custom"
/**
 * 获取攻略评论
 */
#define RAIDERS_COMMENT_LIST "lyStrategyCommentAction.do?action=list"
/**
 * 攻略评论
 * {
 * "strategyId":"攻略ID",
 * "toUserId":"对某人评论，空表示对攻略的评论",
 * "comment":"评论内容"
 * }
 */
#define RAIDERS_COMMENT_ADD "lyStrategyCommentAction.do?action=add"
/**
 * 攻略删除评论
 */
#define RAIDERS_COMMENT_DEL "lyStrategyCommentAction.do?action=delete"
/**
 * 攻略点赞
 */
#define RAIDERS_LIKE_ADD "strategyAction.do?action=login"
/**
 * 攻略取消点赞
 */
#define RAIDERS_LIKE_CANCLE "strategyAction.do?action=logout"
/**
 * 攻略收藏
 */
#define RAIDERS_COLLECT_ADD "strategyAction.do?action=importExcel"
/**
 * 攻略取消收藏
 */
#define RAIDERS_COLLECT_CANCLE "strategyAction.do?action=exportExcel"
/**
 * 讨论组
 */
/**
 * 创建群
 */
#define IM_GROUP_CREATE "lyGroupManageAction.do?action=custom"
/**
 * 加入群
 */
#define IM_GROUP_JOIN "groupAction.do?action=save"

/**
 * 退出群
 */
#define IM_GROUP_QUIT "groupAction.do?action=update"
/**
 * 获取群内成员
 */
#define IM_GROUP_MEMBERS_USER_LIST "lyGroupManageAction.do?action=login"
/**
 * 添加禁言群成员
 */
#define IM_GROUP_MEMBERS_USER_GAG "groupAction.do?action=login"
/**
 * 解除禁言群成员
 */
#define IM_GROUP_MEMBERS_USER_DEL_GAG "groupAction.do?action=login"
/**
 * 申请成为酒吧群主
 */
#define IM_GROUP_MEMBERS_APPLY_MANAGER "lyGroupManageAction.do?action=expand"

/**
 * 普通聊天室
 */
/**
 * 获取聊天室成员
 */
#define IM_CAHTROOM_MEMBERS_USER_LIST "lyRequireAction.do?action=expand"
/**
 * 销毁聊天室
 */
#define IM_CAHTROOM_QUIT "friendAction.do?action=logout"

/**
 * 活动
 */
/**
 * 获取活动列表
 */
#define SPREAD_LIST "activitiesOutAction.do?action=list"
/**
 * 获取活动详情
 */
#define SPREAD_INFO "activitiesOutAction.do?action=custom"

/**
 * 首页:覆盖地区
 */
#define LIE_LOCATION_ADDRESS "versionAction.do?action=add"
/**
 * 首页/娱乐顾问/直播
 */
#define LIE_BAR_LIFE "lyMomentsAction.do?action=logout"
/**
 * 根据用户ID，获取好友详情
 */
#define USER_INFO "lyQRCodeAction.do?action=expand"
/**
 * 我的 获取申请专属经理是否需要微信支付
 */
#define USER_INFO_APPLY_STATUS "lyUsersVipApplyAction.do?action=expand"
/**
 * 我的 粉丝数\关注数
 */
#define USER_INFO_FANS_ATTENTION_NUM "app/api/sns/snscount"
/**
 * 用户添加专属经理
 */
#define USER_VIP_ADD "lyUsersVipStoreAction.do?action=add"
/**
 * 用户删除收藏的VIP专属经理
 */
#define USER_VIP_DELETE "lyUsersVipStoreAction.do?action=delete"

/**
 *  打招呼
 */
#define SAY_HELLO "lyUserShakeAction.do?action=custom"
/**
 * 获取打招呼列表 "type":"打招呼类别，1：摇一摇；2：附近的人； 3:扫一扫； 4:搜索添加"
 */
#define TO_HAVE_LOOK_LIST "/lyUserShakeAction.do?action=expand"
/**
 * 获取推送配置
 */
#define SYSTEM_NOTIFY_GET_PUSH_CONFIG "userPushAction.do?action=list"
/**
 * 修改用户的推送配置
 */
#define SYSTEM_NOTIFY_PUSH_CONFIG_UPDATE "userPushAction.do?action=update"
/**
 * 将推送信息标识为已读
 * "read":"0表示未读，1表示已读"
 */
#define INDENT_HAS_READ "userPushLogAction.do?action=update"
/**
 * 接受消息
 */
#define TO_ACCEPT_MESSAGE "lyUserShakeAction.do?action=save"
/**
 * 忽略消息
 */
#define TO_CANCEL_MESSAGE "lyUserShakeAction.do?action=delete"
/**
 * 获取用户推送记录
 */
#define GET_PUSH_LOG "userPushLogAction.do?action=list"
/**
 * 根据手机号查询
 */
#define TO_GET_FRIEND_BY_MOBILE "usersAction.do?action=cancel"

/**
 * 扫一扫加好友或速核码
 */
#define FAST_QR_CODE "lyQRCodeAction.do?action=custom"
/**
 * 免费订台
 */
#define FREE_ORDER_ADD "lyOrderFreeAction.do?action=add"
/**
 * 请求套餐列表（套餐）
 */
#define PACKAGE_LIST "toPlayAction.do?action=expand"
/**
 * 请求拼客列表（组局）
 */
#define TOGETHER_LIST "togetherAction.do?action=list"
/**
 * 请求拼客详情
 */
#define TOGETHER_DETAIL "togetherAction.do?action=custom"
/**
 * 请求酒吧下的专属经理列表
 */
#define BAR_EXCLUSIVE_MANAGER_LIST "toPlayGetVipAction.do?action=list"
/**
 * 请求微信支付
 */
#define ORDER_PAY_WX "tenpayOrderAction.do?action=custom"
/**
 * 余额消费
 */
#define ORDER_PAY_BALANCE "dailyCoinAction.do?action=add"
/**
 * 获取DES加密key
 */
#define DES_KEY "lyOrderAction.do?action=login"
/**
 * 请求酒吧明细
 */
#define BAR_DETAIL "toPlayAction.do?action=custom"
/**
 * 请求酒水类型
 */
#define BAR_ORDER_SINGLE_CATEGORY "productcategoryAction.do?action=list"

/**
 * 请求酒水列表
 */
#define BAR_ORDER_SINGLE_COMMODITY_LIST "drinksAction.do?action=list"

/**
 * 请求酒水详情
 */
#define COMMODITY_DETAIL "drinksAction.do?action=custom"
/**
 * 请求购物车列表
 */
#define BAR_ORDER_SHOP_CART_LIST "cartAction.do?action=list"
/**
 * 请求录入订单(购物车)
 */
#define BAR_ORDER_SHOP_CART_CONFIRM "cartAction.do?action=addToOrder"

/**
 * 请求加入购物车
 */
#define ADD_SHOP_CART "cartAction.do?action=add"
/**
 * 请求修改购物车数量
 */
#define UPDATE_SHOP_CART "cartAction.do?action=update"
/**
 * 请求删除购物车
 */
#define DEL_SHOP_CART "cartAction.do?action=delete"
/**
 * 获取签到列表
 */
#define GET_SIGN_LIST "userSignAction.do?action=list"
/**
 * 请求我的订单列表
 */
#define MINE_ORDER_LIST "lyOrderAction.do?action=list"

/**
 * 请求我的订单删除
 */
#define MINE_ORDER_DEL "lyOrderAction.do?action=delete"
/**
 * 请求我的订单取消
 */
#define MINE_ORDER_CANCLE "lyOrderAction.do?action=cancel"

/**
 * 请求我的订单详情
 */
#define MINE_ORDER_INFO "smOrderAction.do?action=custom"

/**
 * 评价订单
 */
#define MINE_ORDER_EVALUATION "lyOrderEvaluationAction.do?action=add"

/**
 * 个人中心角标
 */
#define MINE_ORDER_NUM "lyOrderAction.do?action=expand"
/**
 * 收藏列表
 */
#define MINE_COLLECT "userStoreAction.do?action=list"
/**
 * 酒吧  收藏
 */
#define BAR_COLLECT_ADD "userStoreAction.do?action=add"
/**
 * 酒吧  收藏 取消
 */
#define BAR_COLLECT_CANCLE "userStoreAction.do?action=delete"
/**
 * 酒吧  签到
 */
#define BAR_SINGIN_IN_ADD "userSignAction.do?action=add"

/**
 * 酒吧  点赞
 */
#define BAR_LIKED_ADD "userPraisedAction.do?action=add"
/**
 * 酒吧  点赞 取消
 */

#define BAR_LIKED_CANCLE "userPraisedAction.do?action=delete"

/**
 * 获取免费订台列表
 */
#define MINE_ORDER_LIST_FREE "lyOrderFreeAction.do?action=list"
/**
 * 取消免费订台
 */
#define MINE_ORDER_LIST_FREE_CANCLE "lyOrderFreeAction.do?action=delete"
/**
 * 删除免费订台
 */
#define MINE_ORDER_LIST_FREE_DEL "lyOrderFreeAction.do?action=delete"
/**
 * 更改免费订台订单状态
 */
#define MINE_ORDER_LIST_FREE_EVALUATION "lyOrderFreeAction.do?action=update"
/**
 * 获取所有标签
 */
#define MINE_TAG_LIST "brandAction.do?action=custom"

/**
 * 获取聊天室成员
 */
#define CHART_ROOM_USER_LIST "lyRequireAction.do?action=expand"
/**
 * 请求人员列表、点赞
 * chatNum  聊天数------主播端发
 * liveChatId 直播聊天ID
 */
#define LIVING_CHART_ROOM_USER_LIST "app/api/liveroom/roomUserList"
/**
 * 直播列表（目前直播的和回放的）
 * cityCode   城市编号
 * livetype   直播类型    live:直播  playback:回放
 * sort       排序条件    hot：最热   recent：最新
 * page       分页查询    每页10个，默认从1开始
 */
#define LIVE_LIST "app/api/liveroom/list"
/**
 * 直播（回放）间
 * /app/api/liveroom/live?roomid=
 * roomid
 */
#define LIVE_INFO "app/api/liveroom/live"
/**
 * 点赞接口
 * /app/api/liveroom/likeLiveRoom?liveChatId=
 * liveChatId
 */
#define LIVE_PRAISE_SEND "app/api/liveroom/likeLiveRoom"
/**
 * 发起直播
 * cityCode 城市编号
 * liveimg  封面图片
 * livename 直播间名称
 * livekey  true 密钥直播
 */
#define LIVE_CREATE "app/api/liveroom/create"
/**
 * /app/api/liveroom/close?roomid=2222&closeType=save
 * closeType   save:保存视频    delete:不保存视频
 */
#define LIVE_QUITE "app/api/liveroom/close"
/**
 * 分享直播
 * roomid
 */
#define LIVE_SHARE "app/api/liveroom/share"
/**
 * 直播是否结束
 * roomid
 */
#define LIVE_IS_FINISH "app/api/liveroom/getLiveStatus"
/**
 * 获取直播间打赏金额
 * roomid
 */
#define LIVE_REWARD_NUM "app/api/liveroom/rewardNum"
/**
 * 本地分享直播地址
 */
#define LIVE_SHARE_LOCAL "app/api/liveroom/share"
/**
 * 关注好友
 */
#define ATTENTION "lyMomentAttentionAction.do?action=add"

/**
 * 获取关注/粉丝列表
 */
#define ATTENTION_LIKS_LIST "lyMomentAttentionAction.do?action=list"

/**
 * 通讯录生日管家
 */
#define FRIEND_UPLOAD_CONTACT "lyPhonebookAction.do?action=importExcel"


/**
 * 玩友圈首页
 */
#define PLAY_TOGETHER "lyMomentsAction.do?action=list"
/**
 * 获取指定用户玩友圈信息 －－我的以及玩友的动态
 */
#define PLAY_TOGETHER_USER_MOVING "lyMomentsAction.do?action=custom"
/**
 * 获取朋友圈反馈的最新消息数量
 */
#define MOVING_RECENT_MSG_NUM "lyMomentsAction.do?action=login"
/**
 * 获取朋友圈反馈的最新消息列表
 */
#define MOVING_RECENT_MSG_LIST "lyMomentsAction.do?action=expand"

/**
 * 获取动态评论
 */
#define MOVING_COMMENT_LIST "lyMomentCommentAction.do?action=list"
/**
 * 删除动态评论
 */
#define MOVING_COMMENT_DEL "lyMomentCommentAction.do?action=delete"
/**
 * 评论
 */
#define MOVING_COMMENT_ADD "lyMomentCommentAction.do?action=add"

/**
 * 赞
 */
#define MOVING_COMMENT_LIKED "lyMomentLikeAction.do?action=add"
/**
 * 用户屏蔽
 */
#define MOVING_SHIELD "lyMomentsAction.do?action=update"

/**
 * 用户举报
 */
#define MOVING_REPORT "lyMomentCommentAction.do?action=update"
/**
 * 发布个人动态
 */
#define MOVING_PUBLISH "lyMomentsAction.do?action=add"
/**
 * 删除个人动态 －－我的玩友圈
 */
#define MOVING_DEL "lyMomentsAction.do?action=delete"
/**
 * 删除个人动态 －－我的玩友圈
 */
#define MOVING_TOP_BG "accountAction.do?action=save"
/**
 *玩友列表
 */

/**
 * 获取好友列表
 */
#define FRIEND_LIST "app/api/sns/friendsGroup"
/**
 * 好友列表 新关注
 * /app/api/sns/newFansList?newFansSize=
 * newFansSize 新粉丝数
 */
#define FRIEND_LIST_NEW_ATTENTION "app/api/sns/newFansList"

/**
 * 好友列表 新关注 关注用户
 * /app/api/sns/follow?followid=
 */
#define FRIEND_LIST_NEW_ATTENTION_ADD "app/api/sns/follow"

/**
 * 好友列表 新关注 取消关注
 * /app/api/sns/removefollow?followid=
 * newFansSize 新粉丝数
 */
#define FRIEND_LIST_NEW_ATTENTION_DEL "app/api/sns/removefollow"

/**
 * 获取发布的需求
 */
#define DEMAND_LIST "lyRequireAction.do?action=list"
/**
 * 获取所有需求标签
 */
#define DEMAND_PUBLISH_TAGS_GET "lyRequireAction.do?action=importExcel"
/**
 * 发布个人需求
 */
#define DEMAND_PUBLISH_ADD "lyRequireAction.do?action=add"
/**
 * 删除个人需求
 */
#define DEMAND_PUBLISH_DEL "lyRequireAction.do?action=delete"
/**
 * 我的 关注列表
 */
#define MINE_ATTENTION_LIST "app/api/sns/followlist"
/**
 * 我的 关注列表  取消关注
 */
#define MINE_ATTENTION_DEL "app/api/sns/removefollow"
/**
 * 我的 关注列表   关注
 */
#define MINE_ATTENTION_ADD "app/api/sns/follow"
/**
 * 我的 粉丝列表
 */
#define MINE_FANS_LIST "app/api/sns/newFansList"

/**
 * 我的 钱包 绑定账户
 */
#define MINE_WALLET_BINDACCOUNT "dailyCoinAction.do?action=expand"
/**
 * 我的 钱包 获取账户余额记录
 */
#define MINE_WALLET_INFO "managerAccountAction.do?action=expand"
/**
 * 我的 钱包 获取提现记录
 */
#define MINE_WALLET_INFO_LIST "managerAccountAction.do?action=list"
/**
 * 我的 钱包 生成充值余额预支付订单
 */
#define MINE_WALLET_BALANCE_RECHARGE "lyRechargeAction.do?action=add"
/**
 * 我的 钱包 娱币商城
 */
#define MINE_WALLET_SHOP_CURRENCY "app/api/user/coinmall/autologin"
/**
 * 我的 钱包 娱币 娱币兑换余额
 */
#define MINE_WALLET_CURRENCY_PRESENT "dailyCoinAction.do?action=save"
/**
 * 我的 娱客帮  获取娱客帮信息
 */
#define MINE_YU_TEAM_INFO "app/api/yukegroup/groupList"
/**
 * 我的 娱客帮  获取生成二维码内容
 */
#define MINE_YU_TEAM_QR_CONTENT "app/api/yukegroup/getShareUrl"

/**
 * 我的 商家入驻请求酒吧列表 （复用我要玩酒吧列表）
 */
#define MERCHANTS_SETTLED_BAR_LIST "toPlayAction.do?action=list"
/**
 * 我的 商家入驻 请求成为专属经理,生成微信支付订单
 */
#define MERCHANTS_SETTLED_APPLY_WX_PAY "smOrderAction.do?action=login"
/**
 * 我的 商家入驻 请求成为专属经理
 */
#define MERCHANTS_SETTLED_APPLY "lyUsersVipApplyAction.do?action=add"
/**
 * 我的 商家入驻 修改专属经理申请信息
 */
#define MERCHANTS_SETTLED_APPLY_UPDATE "lyUsersVipApplyAction.do?action=update"
/**
 * 我的 商家入驻  获取专属经理申请信息
 */
#define MERCHANTS_SETTLED_APPLY_USER_INFO "lyUsersVipApplyAction.do?action=list"
/**
 * 打赏
 */
/**
 * 获取打赏列表
 */
#define REWARD_LIST "app/api/reward/rewardTypeList"
/**
 * 打赏
 */
#define REWARD_ADD "dailyCoinAction.do?action=custom"
/**
 * 商户中心
 */
/**
 * vip经理专属经理  直接核对消费码
 */
#define BUSINESS_CENTER_CONSUMER_CODE "lyOrderAction.do?action=update"
/**
 * vip经理专属经理 获取账户余额记录
 */
#define BUSINESS_CENTER_BALANCE "managerAccountAction.do?action=expand"
/**
 * vip经理专属经理 获取提现记录
 */
#define BUSINESS_CENTER_PRESENT_HISTORY "managerAccountAction.do?action=list"
/**
 * vip经理专属经理 申请提现
 */
#define BUSINESS_CENTER_PRESENT "managerAccountAction.do?action=add"

/**
 * vip经理请求vip订单列表
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_LIST "smOrderAction.do?action=list"
/**
 * vip经理经理取消订单
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_CANCLE "lyOrderAction.do?action=mangerCancel"
/**
 * vip经理确认留座
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_SEAT "lyOrderAction.do?action=managerConfirmSeat"
/**
 * vip经理确认消费码
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_CONSUMER_CODE "lyOrderAction.do?action=managerConfirmOrder"
/**
 * vip经理获取免费订台列表
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_LIST "lyOrderFreeAction.do?action=list"
/**
 * vip经理 确认留座 更改免费订台订单状态
 * {
 * "id":"订单ID",
 * "orderStatus":"订单状态", //2：专属经理确认订单时传的状态 3：用户确认完成时的状态
 * "isSatisfaction":"用户是否满意" //订单状态传2时，无需传值；传3时，1：满意 0：不满意
 * }
 */
#define BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_CONFIRM_SEAT "lyOrderFreeAction.do?action=update"

/**
 * vip经理  卡座一周是否满座
 */
#define BUSINESS_CENTER_CASSETTE_SETTING "lySetDeckFullAction.do?action=list"
/**
 * vip经理  设置某天卡座(未)满座
 */
#define BUSINESS_CENTER_CASSETTE_SETTING_AVAILABLE "lySetDeckFullAction.do?action=delete"
/**
 * vip经理  设置某天卡座满座
 */
#define BUSINESS_CENTER_CASSETTE_SETTING_UNAVAILABLE "lySetDeckFullAction.do?action=add"

/**
 * vip经理  获取好友列表
 */
#define BUSINESS_CENTER_CLIENT_MANAGER_LIST "lyUsersFriendAction.do?action=list"
/**
 * vip经理  生日管家（好友生日列表）
 */
#define BUSINESS_CENTER_BIRTHDAY_MANAGER_LIST "lyPhonebookAction.do?action=list"
/**
 * vip经理  生日管家 条添加或更新好友生日
 * {
 * "mobile":"手机号",
 * "name":"姓名",
 * "birthday":"生日",
 * "headUrl":"头像地址",
 * "id":"记录id" //如果传说明是更新,
 * "sex":"性别"
 * }
 */
#define BUSINESS_CENTER_BIRTHDAY_UPDATE "lyPhonebookAction.do?action=add"
/**
 * vip经理  生日管家（删除好友生日）
 * "ids":"记录ID" //传多个时用逗号分割
 */
#define BUSINESS_CENTER_BIRTHDAY_DEL "lyPhonebookAction.do?action=delete"
/**
 * vip经理  生日管家（今天好友生日列表）
 */
#define BUSINESS_CENTER_BIRTHDAY_TODAY_LIST "lyPhonebookAction.do?action=expand"
/**
 * vip经理  生日管家 送完生日祝福后，改变是否送祝福状态
 */
#define BUSINESS_CENTER_BIRTHDAY_UPDATE_BLESSING_STATUS "lyPhonebookAction.do?action=update"
/**
 * 根据后缀(suffix)返回完整地址
 */
JNIEXPORT jstring JNICALL JNICALL Java_com_java02014_utils_NetUtils_getUrl(
		JNIEnv *env, jclass clazz, jstring urlType, jstring Suffix) {
	const char *str = (*env)->GetStringUTFChars(env, Suffix, JNI_FALSE);
	const char *urlTypeStr = (*env)->GetStringUTFChars(env, urlType, JNI_FALSE);
	char buf[1024];

	/*
	 * 正式服务器
	 */
	if (strcmp(urlTypeStr, "URL_OFFICAL") == 0) {
		strcpy(buf, URL_OFFICAL);
	} else if (strcmp(urlTypeStr, "URL_PRE_OFFICAL") == 0) {
		/*
		 * 预生产服务器
		 */
		strcpy(buf, URL_PRE_OFFICAL);
	} else if (strcmp(urlTypeStr, "URL_LOCAL_TEST") == 0) {
		/*
		 * 本地测试服务器
		 */
		strcpy(buf, URL_LOCAL_TEST);
	}

	/**
     *  Alipay 回调地址
     */
    if (strcmp(str, "ALIPAY_NOTIFY_URL") == 0) {
    	strcat(buf, ALIPAY_NOTIFY_URL);
    	return (*env)->NewStringUTF(env, buf);
    }
	/**
	 *App更新
	 */
	if (strcmp(str, "APP_VERSION") == 0) {
		strcat(buf, APP_VERSION);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 登录发送验证码
	 */
	if (strcmp(str, "MINE_QRCODE") == 0) {
		strcat(buf, MINE_QRCODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 注册发送验证码 绑定手机使用
	 */
	if (strcmp(str, "VERIFY_CODE_BIND") == 0) {
		strcat(buf, VERIFY_CODE_BIND);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 登录
	 **/
	if (strcmp(str, "LOGIN") == 0) {
		strcat(buf, LOGIN);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 注册
	 **/
	if (strcmp(str, "REGISTER") == 0) {
		strcat(buf, REGISTER);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 注册发送验证码
	 **/
	if (strcmp(str, "REGISTER_VERIFYCODE") == 0) {
		strcat(buf, REGISTER_VERIFYCODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取推荐玩友列表
	 */
	if (strcmp(str, "ACTIVUSER") == 0) {
		strcat(buf, ACTIVUSER);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 提交选中推荐玩友
	 */
	if (strcmp(str, "ACTIVUSER_FOLLOW") == 0) {
		strcat(buf, ACTIVUSER_FOLLOW);
		return (*env)->NewStringUTF(env, buf);
	}
	if (strcmp(str, "FORGET_PWD") == 0) {
		strcat(buf, FORGET_PWD);
		return (*env)->NewStringUTF(env, buf);
	}
	if (strcmp(str, "FORGET_PWD_VERIFYCODE") == 0) {
		strcat(buf, FORGET_PWD_VERIFYCODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 修改昵称和头像
	 **/
	if (strcmp(str, "USER_MODIFY_INFO") == 0) {
		strcat(buf, USER_MODIFY_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页“娱乐顾问”页面使用方法
	 */
	if (strcmp(str, "LIE_ENTERTAINMENT_CONSULTANTS") == 0) {
		strcat(buf, LIE_ENTERTAINMENT_CONSULTANTS);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页“夜店、酒吧” 搜索酒吧,夜店
	 */
	if (strcmp(str, "ENTERTAINMENT_HUNTING_SEARCH_BAR_NIGHT_CLUB") == 0) {
		strcat(buf, ENTERTAINMENT_HUNTING_SEARCH_BAR_NIGHT_CLUB);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页“夜店、酒吧” 搜索直播
	 */
	if (strcmp(str, "ENTERTAINMENT_HUNTING_SEARCH_LIVING") == 0) {
		strcat(buf, ENTERTAINMENT_HUNTING_SEARCH_LIVING);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
  	 * 获取城市是否开通
  	 */
    if (strcmp(str, "ENTERTAINMENT_HUNTING_BAR_CITY_STATUS") == 0) {
  		strcat(buf, ENTERTAINMENT_HUNTING_BAR_CITY_STATUS);
  		return (*env)->NewStringUTF(env, buf);
  	}
	/**
	 * 首页“夜店、酒吧”页面使用方法
	 */
	if (strcmp(str, "LIE_BAR_NIGHTCLUBS") == 0) {
		strcat(buf, LIE_BAR_NIGHTCLUBS);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页“夜店、酒吧”页面使用方法(上部分)
	 */
	if (strcmp(str, "ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS_TOP") == 0) {
		strcat(buf, ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS_TOP);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页“夜店、酒吧”页面使用方法(下部分)
	 */
	if (strcmp(str, "ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS") == 0) {
		strcat(buf, ENTERTAINMENT_HUNTING_BAR_NIGHTCLUBS);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页 获取界面banner
	 * {
	 * "interfaceTypeId":"页面类型ID" //1：我要玩，2：一起玩，3：娱乐顾问，4：直播，5：活动派对"，
	 * p=1(页码)
	 * per=20(每页多少笔记录 默认20)
	 * <p/>
	 * }
	 */
	if (strcmp(str, "ENTERTAINMENT_HUNTING_BANNER") == 0) {
		strcat(buf, ENTERTAINMENT_HUNTING_BANNER);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取话题类别
	 * {
	 * 两个参数都不传，获取所有话题；type为1，barid不传，获取所有酒吧话题；type为1，barid传值，获取相应酒吧话题；type为2，获取除酒吧话题之外的话题
	 * "type":"话题类别类型",
	 * "barid":"酒吧Id"
	 * }
	 */
	if (strcmp(str, "TOPIC_TYPE") == 0) {
		strcat(buf, TOPIC_TYPE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 根据话题ID获取玩友圈动态
	 */
	if (strcmp(str, "TOPIC_TYPE_MOVING_LIST") == 0) {
		strcat(buf, TOPIC_TYPE_MOVING_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取攻略列表
	 */
	if (strcmp(str, "RAIDERS_LIST") == 0) {
		strcat(buf, RAIDERS_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取攻略详情
	 */
	if (strcmp(str, "RAIDERS_INFO") == 0) {
		strcat(buf, RAIDERS_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取攻略评论
	 */
	if (strcmp(str, "RAIDERS_COMMENT_LIST") == 0) {
		strcat(buf, RAIDERS_COMMENT_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略评论
	 * {
	 * "strategyId":"攻略ID",
	 * "toUserId":"对某人评论，空表示对攻略的评论",
	 * "comment":"评论内容"
	 * }
	 */
	if (strcmp(str, "RAIDERS_COMMENT_ADD") == 0) {
		strcat(buf, RAIDERS_COMMENT_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略删除评论
	 */
	if (strcmp(str, "RAIDERS_COMMENT_DEL") == 0) {
		strcat(buf, RAIDERS_COMMENT_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略点赞
	 */
	if (strcmp(str, "RAIDERS_LIKE_ADD") == 0) {
		strcat(buf, RAIDERS_LIKE_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略取消点赞
	 */
	if (strcmp(str, "RAIDERS_LIKE_CANCLE") == 0) {
		strcat(buf, RAIDERS_LIKE_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略收藏
	 */
	if (strcmp(str, "RAIDERS_COLLECT_ADD") == 0) {
		strcat(buf, RAIDERS_COLLECT_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 攻略取消收藏
	 */
	if (strcmp(str, "RAIDERS_COLLECT_CANCLE") == 0) {
		strcat(buf, RAIDERS_COLLECT_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 创建群
	 */
	if (strcmp(str, "IM_GROUP_CREATE") == 0) {
		strcat(buf, IM_GROUP_CREATE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取群内成员
	 */
	if (strcmp(str, "IM_GROUP_MEMBERS_USER_LIST") == 0) {
		strcat(buf, IM_GROUP_MEMBERS_USER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 申请成为酒吧群主
	 */
	if (strcmp(str, "IM_GROUP_MEMBERS_APPLY_MANAGER") == 0) {
		strcat(buf, IM_GROUP_MEMBERS_APPLY_MANAGER);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取聊天室成员
	 */
	if (strcmp(str, "IM_CAHTROOM_MEMBERS_USER_LIST") == 0) {
		strcat(buf, IM_CAHTROOM_MEMBERS_USER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取活动列表
	 */
	if (strcmp(str, "SPREAD_LIST") == 0) {
		strcat(buf, SPREAD_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取活动详情
	 */
	if (strcmp(str, "SPREAD_INFO") == 0) {
		strcat(buf, SPREAD_INFO);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 首页:覆盖地区
	 */
	if (strcmp(str, "LIE_LOCATION_ADDRESS") == 0) {
		strcat(buf, LIE_LOCATION_ADDRESS);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 首页/娱乐顾问/直播
	 */
	if (strcmp(str, "LIE_BAR_LIFE") == 0) {
		strcat(buf, LIE_BAR_LIFE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 根据用户ID，获取好友详情
	 */
	if (strcmp(str, "USER_INFO") == 0) {
		strcat(buf, USER_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 获取申请专属经理是否需要微信支付
	 */
	if (strcmp(str, "USER_INFO_APPLY_STATUS") == 0) {
		strcat(buf, USER_INFO_APPLY_STATUS);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 粉丝数\关注数
	 */
	if (strcmp(str, "USER_INFO_FANS_ATTENTION_NUM") == 0) {
		strcat(buf, USER_INFO_FANS_ATTENTION_NUM);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 用户添加专属经理
	 */
	if (strcmp(str, "USER_VIP_ADD") == 0) {
		strcat(buf, USER_VIP_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 用户删除收藏的VIP专属经理
	 */
	if (strcmp(str, "USER_VIP_DELETE") == 0) {
		strcat(buf, USER_VIP_DELETE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 *  打招呼
	 */
	if (strcmp(str, "SAY_HELLO") == 0) {
		strcat(buf, SAY_HELLO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取打招呼列表 "type":"打招呼类别，1：摇一摇；2：附近的人； 3:扫一扫； 4:搜索添加"
	 */
	if (strcmp(str, "TO_HAVE_LOOK_LIST") == 0) {
		strcat(buf, TO_HAVE_LOOK_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 接受消息
	 */
	if (strcmp(str, "TO_ACCEPT_MESSAGE") == 0) {
		strcat(buf, TO_ACCEPT_MESSAGE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 忽略消息
	 */
	if (strcmp(str, "TO_CANCEL_MESSAGE") == 0) {
		strcat(buf, TO_CANCEL_MESSAGE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 扫一扫加好友或速核码
	 */
	if (strcmp(str, "FAST_QR_CODE") == 0) {
		strcat(buf, FAST_QR_CODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 免费订台
	 */
	if (strcmp(str, "FREE_ORDER_ADD") == 0) {
		strcat(buf, FREE_ORDER_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求套餐列表（套餐）
	 */
	if (strcmp(str, "PACKAGE_LIST") == 0) {
		strcat(buf, PACKAGE_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求拼客列表（组局）
	 */
	if (strcmp(str, "TOGETHER_LIST") == 0) {
		strcat(buf, TOGETHER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求拼客详情
	 */
	if (strcmp(str, "TOGETHER_DETAIL") == 0) {
		strcat(buf, TOGETHER_DETAIL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求酒吧下的专属经理列表
	 */
	if (strcmp(str, "BAR_EXCLUSIVE_MANAGER_LIST") == 0) {
		strcat(buf, BAR_EXCLUSIVE_MANAGER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求微信支付
	 */
	if (strcmp(str, "ORDER_PAY_WX") == 0) {
		strcat(buf, ORDER_PAY_WX);
		return (*env)->NewStringUTF(env, buf);
	}
    /**
	 * 余额消费
	 */
	if (strcmp(str, "ORDER_PAY_BALANCE") == 0) {
		strcat(buf, ORDER_PAY_BALANCE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取DES加密key
	 */
	if (strcmp(str, "DES_KEY") == 0) {
		strcat(buf, DES_KEY);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求酒吧明细
	 */
	if (strcmp(str, "BAR_DETAIL") == 0) {
		strcat(buf, BAR_DETAIL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求酒水类型
	 */
	if (strcmp(str, "BAR_ORDER_SINGLE_CATEGORY") == 0) {
		strcat(buf, BAR_ORDER_SINGLE_CATEGORY);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求酒水列表
	 */
	if (strcmp(str, "BAR_ORDER_SINGLE_COMMODITY_LIST") == 0) {
		strcat(buf, BAR_ORDER_SINGLE_COMMODITY_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求酒水详情
	 */
	if (strcmp(str, "COMMODITY_DETAIL") == 0) {
		strcat(buf, COMMODITY_DETAIL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求购物车列表
	 */
	if (strcmp(str, "BAR_ORDER_SHOP_CART_LIST") == 0) {
		strcat(buf, BAR_ORDER_SHOP_CART_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求录入订单(购物车)
	 */
	if (strcmp(str, "BAR_ORDER_SHOP_CART_CONFIRM") == 0) {
		strcat(buf, BAR_ORDER_SHOP_CART_CONFIRM);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求加入购物车
	 */
	if (strcmp(str, "ADD_SHOP_CART") == 0) {
		strcat(buf, ADD_SHOP_CART);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求修改购物车数量
	 */
	if (strcmp(str, "UPDATE_SHOP_CART") == 0) {
		strcat(buf, UPDATE_SHOP_CART);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求删除购物车
	 */
	if (strcmp(str, "DEL_SHOP_CART") == 0) {
		strcat(buf, DEL_SHOP_CART);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取签到列表
	 */
	if (strcmp(str, "GET_SIGN_LIST") == 0) {
		strcat(buf, GET_SIGN_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求我的订单列表
	 */
	if (strcmp(str, "MINE_ORDER_LIST") == 0) {
		strcat(buf, MINE_ORDER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求我的订单删除
	 */
	if (strcmp(str, "MINE_ORDER_DEL") == 0) {
		strcat(buf, MINE_ORDER_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求我的订单取消
	 */
	if (strcmp(str, "MINE_ORDER_CANCLE") == 0) {
		strcat(buf, MINE_ORDER_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 请求我的订单详情
	 */
	if (strcmp(str, "MINE_ORDER_INFO") == 0) {
		strcat(buf, MINE_ORDER_INFO);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 评价订单
	 */
	if (strcmp(str, "MINE_ORDER_EVALUATION") == 0) {
		strcat(buf, MINE_ORDER_EVALUATION);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 个人中心角标
	 */
	if (strcmp(str, "MINE_ORDER_NUM") == 0) {
		strcat(buf, MINE_ORDER_NUM);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 收藏列表
	 */
	if (strcmp(str, "MINE_COLLECT") == 0) {
		strcat(buf, MINE_COLLECT);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 酒吧  收藏
	 */
	if (strcmp(str, "BAR_COLLECT_ADD") == 0) {
		strcat(buf, BAR_COLLECT_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 酒吧  收藏 取消
	 */
	if (strcmp(str, "BAR_COLLECT_CANCLE") == 0) {
		strcat(buf, BAR_COLLECT_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 酒吧  签到
	 */
	if (strcmp(str, "BAR_SINGIN_IN_ADD") == 0) {
		strcat(buf, BAR_SINGIN_IN_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 酒吧  点赞
	 */
	if (strcmp(str, "BAR_LIKED_ADD") == 0) {
		strcat(buf, BAR_LIKED_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 酒吧  点赞 取消
	 */
	if (strcmp(str, "BAR_LIKED_CANCLE") == 0) {
		strcat(buf, BAR_LIKED_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 获取免费订台列表
	 */
	if (strcmp(str, "MINE_ORDER_LIST_FREE") == 0) {
		strcat(buf, MINE_ORDER_LIST_FREE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 取消免费订台
	 */
	if (strcmp(str, "MINE_ORDER_LIST_FREE_CANCLE") == 0) {
		strcat(buf, MINE_ORDER_LIST_FREE_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 删除免费订台
	 */
	if (strcmp(str, "MINE_ORDER_LIST_FREE_DEL") == 0) {
		strcat(buf, MINE_ORDER_LIST_FREE_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 更改免费订台订单状态
	 */
	if (strcmp(str, "MINE_ORDER_LIST_FREE_EVALUATION") == 0) {
		strcat(buf, MINE_ORDER_LIST_FREE_EVALUATION);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取所有标签
	 */
	if (strcmp(str, "MINE_TAG_LIST") == 0) {
		strcat(buf, MINE_TAG_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 获取聊天室成员
	 */
	if (strcmp(str, "CHART_ROOM_USER_LIST") == 0) {
		strcat(buf, CHART_ROOM_USER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 请求人员列表、点赞
	 * chatNum  聊天数------主播端发
	 * liveChatId 直播聊天ID
	 */
	if (strcmp(str, "LIVING_CHART_ROOM_USER_LIST") == 0) {
		strcat(buf, LIVING_CHART_ROOM_USER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 直播列表（目前直播的和回放的）
	 * cityCode   城市编号
	 * livetype   直播类型    live:直播  playback:回放
	 * sort       排序条件    hot：最热   recent：最新
	 * page       分页查询    每页10个，默认从1开始
	 */
	if (strcmp(str, "LIVE_LIST") == 0) {
		strcat(buf, LIVE_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 直播（回放）间
	 * /app/api/liveroom/live?roomid=
	 * roomid
	 */
	if (strcmp(str, "LIVE_INFO") == 0) {
		strcat(buf, LIVE_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 点赞接口
	 * /app/api/liveroom/likeLiveRoom?liveChatId=
	 * liveChatId
	 */
	if (strcmp(str, "LIVE_PRAISE_SEND") == 0) {
		strcat(buf, LIVE_PRAISE_SEND);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 发起直播
	 * cityCode 城市编号
	 * liveimg  封面图片
	 * livename 直播间名称
	 * livekey  true 密钥直播
	 */
	if (strcmp(str, "LIVE_CREATE") == 0) {
		strcat(buf, LIVE_CREATE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 关闭直播
	 * /app/api/liveroom/close?roomid=2222&closeType=save
	 * closeType   save:保存视频    delete:不保存视频
	 */
	if (strcmp(str, "LIVE_QUITE") == 0) {
		strcat(buf, LIVE_QUITE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 分享直播
	 * roomid
	 */
	if (strcmp(str, "LIVE_SHARE") == 0) {
		strcat(buf, LIVE_SHARE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 直播是否结束
	 * roomid
	 */
	if (strcmp(str, "LIVE_IS_FINISH") == 0) {
		strcat(buf, LIVE_IS_FINISH);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取直播间打赏金额
	 * roomid
	 */
	if (strcmp(str, "LIVE_REWARD_NUM") == 0) {
		strcat(buf, LIVE_REWARD_NUM);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
     * 本地分享直播地址
     */
    if (strcmp(str, "LIVE_SHARE_LOCAL") == 0) {
    	strcat(buf, LIVE_SHARE_LOCAL);
    	return (*env)->NewStringUTF(env, buf);
    }
	/**
	 *  关注好友
	 */
	if (strcmp(str, "ATTENTION") == 0) {
		strcat(buf, ATTENTION);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
     * 获取关注/粉丝列表
     */
    if (strcmp(str, "ATTENTION_LIKS_LIST") == 0) {
    	strcat(buf, ATTENTION_LIKS_LIST);
    	return (*env)->NewStringUTF(env, buf);
    }
	/**
	 * 通讯录生日管家
	 */
	if (strcmp(str, "FRIEND_UPLOAD_CONTACT") == 0) {
		strcat(buf, FRIEND_UPLOAD_CONTACT);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 玩友圈首页
	 */
	if (strcmp(str, "PLAY_TOGETHER") == 0) {
		strcat(buf, PLAY_TOGETHER);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取指定用户玩友圈信息 －－我的以及玩友的动态
	 */
	if (strcmp(str, "PLAY_TOGETHER_USER_MOVING") == 0) {
		strcat(buf, PLAY_TOGETHER_USER_MOVING);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取朋友圈反馈的最新消息数量
	 */
	if (strcmp(str, "MOVING_RECENT_MSG_NUM") == 0) {
		strcat(buf, MOVING_RECENT_MSG_NUM);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取朋友圈反馈的最新消息列表
	 */
	if (strcmp(str, "MOVING_RECENT_MSG_LIST") == 0) {
		strcat(buf, MOVING_RECENT_MSG_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 获取动态评论
	 */
	if (strcmp(str, "MOVING_COMMENT_LIST") == 0) {
		strcat(buf, MOVING_COMMENT_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 删除动态评论
	 */
	if (strcmp(str, "MOVING_COMMENT_DEL") == 0) {
		strcat(buf, MOVING_COMMENT_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 评论
	 */
	if (strcmp(str, "MOVING_COMMENT_ADD") == 0) {
		strcat(buf, MOVING_COMMENT_ADD);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 赞
	 */
	if (strcmp(str, "MOVING_COMMENT_LIKED") == 0) {
		strcat(buf, MOVING_COMMENT_LIKED);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 用户屏蔽
	 */
	if (strcmp(str, "MOVING_SHIELD") == 0) {
		strcat(buf, MOVING_SHIELD);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 用户举报
	 */
	if (strcmp(str, "MOVING_REPORT") == 0) {
		strcat(buf, MOVING_REPORT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 发布个人动态
	 */
	if (strcmp(str, "MOVING_PUBLISH") == 0) {
		strcat(buf, MOVING_PUBLISH);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 删除个人动态 －－我的玩友圈
	 */
	if (strcmp(str, "MOVING_DEL") == 0) {
		strcat(buf, MOVING_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 删除个人动态 －－我的玩友圈
	 */
	if (strcmp(str, "MOVING_TOP_BG") == 0) {
		strcat(buf, MOVING_TOP_BG);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 获取好友列表
	 */
	if (strcmp(str, "FRIEND_LIST") == 0) {
		strcat(buf, FRIEND_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 好友列表 新关注
	 * /app/api/sns/newFansList?newFansSize=
	 * newFansSize 新粉丝数
	 */
	if (strcmp(str, "FRIEND_LIST_NEW_ATTENTION") == 0) {
		strcat(buf, FRIEND_LIST_NEW_ATTENTION);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 好友列表 新关注 关注用户
	 * /app/api/sns/follow?followid=
	 */
	if (strcmp(str, "FRIEND_LIST_NEW_ATTENTION_ADD") == 0) {
		strcat(buf, FRIEND_LIST_NEW_ATTENTION_ADD);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 好友列表 新关注 取消关注
	 * /app/api/sns/removefollow?followid=
	 * newFansSize 新粉丝数
	 */
	if (strcmp(str, "FRIEND_LIST_NEW_ATTENTION_DEL") == 0) {
		strcat(buf, FRIEND_LIST_NEW_ATTENTION_DEL);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 获取发布的需求
	 */
	if (strcmp(str, "DEMAND_LIST") == 0) {
		strcat(buf, DEMAND_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取所有需求标签
	 */
	if (strcmp(str, "DEMAND_PUBLISH_TAGS_GET") == 0) {
		strcat(buf, DEMAND_PUBLISH_TAGS_GET);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 发布个人需求
	 */
	if (strcmp(str, "DEMAND_PUBLISH_ADD") == 0) {
		strcat(buf, DEMAND_PUBLISH_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 删除个人需求
	 */
	if (strcmp(str, "DEMAND_PUBLISH_DEL") == 0) {
		strcat(buf, DEMAND_PUBLISH_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 *  我的 关注列表
	 */
	if (strcmp(str, "MINE_ATTENTION_LIST") == 0) {
		strcat(buf, MINE_ATTENTION_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 关注列表  取消关注
	 */
	if (strcmp(str, "MINE_ATTENTION_DEL") == 0) {
		strcat(buf, MINE_ATTENTION_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 关注列表   关注
	 */
	if (strcmp(str, "MINE_ATTENTION_ADD") == 0) {
		strcat(buf, MINE_ATTENTION_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 粉丝列表
	 */
	if (strcmp(str, "MINE_FANS_LIST") == 0) {
		strcat(buf, MINE_FANS_LIST);
		return (*env)->NewStringUTF(env, buf);
	}


	/**
	 * 我的 钱包 绑定账户
	 */
	if (strcmp(str, "MINE_WALLET_BINDACCOUNT") == 0) {
		strcat(buf, MINE_WALLET_BINDACCOUNT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 钱包 获取账户余额记录
	 */
	if (strcmp(str, "MINE_WALLET_INFO") == 0) {
		strcat(buf, MINE_WALLET_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 钱包 获取提现记录
	 */
	if (strcmp(str, "MINE_WALLET_INFO_LIST") == 0) {
		strcat(buf, MINE_WALLET_INFO_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 钱包 生成充值余额预支付订单
	 */
	if (strcmp(str, "MINE_WALLET_BALANCE_RECHARGE") == 0) {
		strcat(buf, MINE_WALLET_BALANCE_RECHARGE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 钱包 娱币商城
	 */
	if (strcmp(str, "MINE_WALLET_SHOP_CURRENCY") == 0) {
		strcat(buf, MINE_WALLET_SHOP_CURRENCY);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 钱包 娱币 娱币兑换余额
	 */
	if (strcmp(str, "MINE_WALLET_CURRENCY_PRESENT") == 0) {
		strcat(buf, MINE_WALLET_CURRENCY_PRESENT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 娱客帮  获取娱客帮信息
	 */
	if (strcmp(str, "MINE_YU_TEAM_INFO") == 0) {
		strcat(buf, MINE_YU_TEAM_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 娱客帮  获取生成二维码内容
	 */
	if (strcmp(str, "MINE_YU_TEAM_QR_CONTENT") == 0) {
		strcat(buf, MINE_YU_TEAM_QR_CONTENT);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 我的 商家入驻请求酒吧列表 （复用我要玩酒吧列表）
	 */
	if (strcmp(str, "MERCHANTS_SETTLED_BAR_LIST") == 0) {
		strcat(buf, MERCHANTS_SETTLED_BAR_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 商家入驻 请求成为专属经理,生成微信支付订单
	 */
	if (strcmp(str, "MERCHANTS_SETTLED_APPLY_WX_PAY") == 0) {
		strcat(buf, MERCHANTS_SETTLED_APPLY_WX_PAY);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 商家入驻 请求成为专属经理
	 */
	if (strcmp(str, "MERCHANTS_SETTLED_APPLY") == 0) {
		strcat(buf, MERCHANTS_SETTLED_APPLY);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 商家入驻 修改专属经理申请信息
	 */
	if (strcmp(str, "MERCHANTS_SETTLED_APPLY_UPDATE") == 0) {
		strcat(buf, MERCHANTS_SETTLED_APPLY_UPDATE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 我的 商家入驻  获取专属经理申请信息
	 */
	if (strcmp(str, "MERCHANTS_SETTLED_APPLY_USER_INFO") == 0) {
		strcat(buf, MERCHANTS_SETTLED_APPLY_USER_INFO);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 打赏
	 */
	/**
	 * 获取打赏列表
	 */
	if (strcmp(str, "REWARD_LIST") == 0) {
		strcat(buf, REWARD_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 打赏
	 */
	if (strcmp(str, "REWARD_ADD") == 0) {
		strcat(buf, REWARD_ADD);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 商户中心
	 */
	/**
	 * vip经理专属经理  直接核对消费码
	 */
	if (strcmp(str, "BUSINESS_CENTER_CONSUMER_CODE") == 0) {
		strcat(buf, BUSINESS_CENTER_CONSUMER_CODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理专属经理 获取账户余额记录
	 */
	if (strcmp(str, "BUSINESS_CENTER_BALANCE") == 0) {
		strcat(buf, BUSINESS_CENTER_BALANCE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理专属经理 获取提现记录
	 */
	if (strcmp(str, "BUSINESS_CENTER_PRESENT_HISTORY") == 0) {
		strcat(buf, BUSINESS_CENTER_PRESENT_HISTORY);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理专属经理 申请提现
	 */
	if (strcmp(str, "BUSINESS_CENTER_PRESENT") == 0) {
		strcat(buf, BUSINESS_CENTER_PRESENT);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * vip经理请求vip订单列表
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_LIST") == 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理经理取消订单
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_CANCLE") == 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_CANCLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理确认留座
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_SEAT") == 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_SEAT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理确认消费码
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_CONSUMER_CODE")
			== 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_CONFIRM_CONSUMER_CODE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理获取免费订台列表
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_LIST") == 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理 确认留座 更改免费订台订单状态
	 * {
	 * "id":"订单ID",
	 * "orderStatus":"订单状态", //2：专属经理确认订单时传的状态 3：用户确认完成时的状态
	 * "isSatisfaction":"用户是否满意" //订单状态传2时，无需传值；传3时，1：满意 0：不满意
	 * }
	 */
	if (strcmp(str, "BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_CONFIRM_SEAT")
			== 0) {
		strcat(buf, BUSINESS_CENTER_ODER_MANAGER_ORDER_FREE_CONFIRM_SEAT);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * vip经理  卡座一周是否满座
	 */
	if (strcmp(str, "BUSINESS_CENTER_CASSETTE_SETTING") == 0) {
		strcat(buf, BUSINESS_CENTER_CASSETTE_SETTING);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  设置某天卡座(未)满座
	 */
	if (strcmp(str, "BUSINESS_CENTER_CASSETTE_SETTING_AVAILABLE") == 0) {
		strcat(buf, BUSINESS_CENTER_CASSETTE_SETTING_AVAILABLE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  设置某天卡座满座
	 */
	if (strcmp(str, "BUSINESS_CENTER_CASSETTE_SETTING_UNAVAILABLE") == 0) {
		strcat(buf, BUSINESS_CENTER_CASSETTE_SETTING_UNAVAILABLE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * vip经理  获取好友列表
	 */
	if (strcmp(str, "BUSINESS_CENTER_CLIENT_MANAGER_LIST") == 0) {
		strcat(buf, BUSINESS_CENTER_CLIENT_MANAGER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  生日管家（好友生日列表）
	 */
	if (strcmp(str, "BUSINESS_CENTER_BIRTHDAY_MANAGER_LIST") == 0) {
		strcat(buf, BUSINESS_CENTER_BIRTHDAY_MANAGER_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  生日管家 条添加或更新好友生日
	 * {
	 * "mobile":"手机号",
	 * "name":"姓名",
	 * "birthday":"生日",
	 * "headUrl":"头像地址",
	 * "id":"记录id" //如果传说明是更新,
	 * "sex":"性别"
	 * }
	 */
	if (strcmp(str, "BUSINESS_CENTER_BIRTHDAY_UPDATE") == 0) {
		strcat(buf, BUSINESS_CENTER_BIRTHDAY_UPDATE);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  生日管家（删除好友生日）
	 * "ids":"记录ID" //传多个时用逗号分割
	 */
	if (strcmp(str, "BUSINESS_CENTER_BIRTHDAY_DEL") == 0) {
		strcat(buf, BUSINESS_CENTER_BIRTHDAY_DEL);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  生日管家（今天好友生日列表）
	 */
	if (strcmp(str, "BUSINESS_CENTER_BIRTHDAY_TODAY_LIST") == 0) {
		strcat(buf, BUSINESS_CENTER_BIRTHDAY_TODAY_LIST);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * vip经理  生日管家 送完生日祝福后，改变是否送祝福状态
	 */
	if (strcmp(str, "BUSINESS_CENTER_BIRTHDAY_UPDATE_BLESSING_STATUS") == 0) {
		strcat(buf, BUSINESS_CENTER_BIRTHDAY_UPDATE_BLESSING_STATUS);
		return (*env)->NewStringUTF(env, buf);
	}

	return (*env)->NewStringUTF(env, buf);
}
/**
 * 根据后缀(suffix)返回完整地址
 */
JNIEXPORT jstring JNICALL JNICALL Java_com_java02014_utils_NetUtils_getUrlPortal(
		JNIEnv *env, jclass clazz, jstring urlType, jstring Suffix) {
	const char *str = (*env)->GetStringUTFChars(env, Suffix, JNI_FALSE);
	const char *urlTypeStr = (*env)->GetStringUTFChars(env, urlType, JNI_FALSE);
	char buf[1024];

	/*
	 * 正式服务器
	 */
	if (strcmp(urlTypeStr, "URL_OFFICAL") == 0) {
		strcpy(buf, URL_OFFICAL_PORTAL);
	} else if (strcmp(urlTypeStr, "URL_PRE_OFFICAL") == 0) {
		/*
		 * 预生产服务器
		 */
		strcpy(buf, URL_PRE_OFFICAL_PORTAL);
	} else if (strcmp(urlTypeStr, "URL_LOCAL_TEST") == 0) {
		/*
		 * 本地测试服务器
		 */
		strcpy(buf, URL_LOCAL_TEST_PORTAL);
	}
	/**
	 * 获取融云token
	 *
	 */
	if (strcmp(str, "IM_TOKEN") == 0) {
		strcat(buf, IM_TOKEN);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 *  获取好友列表
	 */
	if (strcmp(str, "GET_FRIEND_LIST") == 0) {
		strcat(buf, GET_FRIEND_LIST);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 *  请求心跳 7牛图片
	 */
	if (strcmp(str, "QN_PIC") == 0) {
		strcat(buf, QN_PIC);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 *  请求心跳 7牛视频
	 */
	if (strcmp(str, "QN_VIDEO") == 0) {
		strcat(buf, QN_VIDEO);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 绑定QQ、微信、微博（已注册、未登录）
	 **/
	if (strcmp(str, "BIND_NOLOGIN") == 0) {
		strcat(buf, BIND_NOLOGIN);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 绑定QQ、微信、微博（已注册、已登录）
	 **/
	if (strcmp(str, "BIND_LOGIN") == 0) {
		strcat(buf, BIND_LOGIN);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 加入群
	 */
	if (strcmp(str, "IM_GROUP_JOIN") == 0) {
		strcat(buf, IM_GROUP_JOIN);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 退出群
	 */
	if (strcmp(str, "IM_GROUP_QUIT") == 0) {
		strcat(buf, IM_GROUP_QUIT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 添加禁言群成员
	 */
	if (strcmp(str, "IM_GROUP_MEMBERS_USER_GAG") == 0) {
		strcat(buf, IM_GROUP_MEMBERS_USER_GAG);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 解除禁言群成员
	 */
	if (strcmp(str, "IM_GROUP_MEMBERS_USER_DEL_GAG") == 0) {
		strcat(buf, IM_GROUP_MEMBERS_USER_DEL_GAG);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 销毁聊天室
	 */
	if (strcmp(str, "IM_CAHTROOM_QUIT") == 0) {
		strcat(buf, IM_CAHTROOM_QUIT);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取推送配置
	 */
	if (strcmp(str, "SYSTEM_NOTIFY_GET_PUSH_CONFIG") == 0) {
		strcat(buf, SYSTEM_NOTIFY_GET_PUSH_CONFIG);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 修改用户的推送配置
	 */
	if (strcmp(str, "SYSTEM_NOTIFY_PUSH_CONFIG_UPDATE") == 0) {
		strcat(buf, SYSTEM_NOTIFY_PUSH_CONFIG_UPDATE);
		return (*env)->NewStringUTF(env, buf);
	}

	/**
	 * 将推送信息标识为已读
	 * "read":"0表示未读，1表示已读"
	 */
	if (strcmp(str, "INDENT_HAS_READ") == 0) {
		strcat(buf, INDENT_HAS_READ);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 获取用户推送记录
	 */
	if (strcmp(str, "GET_PUSH_LOG") == 0) {
		strcat(buf, GET_PUSH_LOG);
		return (*env)->NewStringUTF(env, buf);
	}
	/**
	 * 根据手机号查询
	 */
	if (strcmp(str, "TO_GET_FRIEND_BY_MOBILE") == 0) {
		strcat(buf, TO_GET_FRIEND_BY_MOBILE);
		return (*env)->NewStringUTF(env, buf);
	}
	return (*env)->NewStringUTF(env, buf);
}
/**
 *根据后缀(isOfficialServer)返回正确的主机地址
 */

JNIEXPORT jstring JNICALL Java_com_xiaohuijun_administrator_NetUtils_getHost(JNIEnv *env,
		jclass clazz, jstring urlType) {
	const char *urlTypeStr = (*env)->GetStringUTFChars(env, urlType, JNI_FALSE);
	char buf[1024];
	/*
	 * 正式服务器
	 */
	if (strcmp(urlTypeStr, "URL_OFFICAL") == 0) {
		strcpy(buf, URL_OFFICAL);
		return (*env)->NewStringUTF(env, buf);
	}
	/*
	 * 预生产服务器
	 */
	if (strcmp(urlTypeStr, "URL_PRE_OFFICAL") == 0) {
		strcpy(buf, URL_PRE_OFFICAL);
		return (*env)->NewStringUTF(env, buf);
	}
	/*
	 * 本地测试服务器
	 */
	if (strcmp(urlTypeStr, "URL_LOCAL_TEST") == 0) {
		strcpy(buf, URL_LOCAL_TEST);
		return (*env)->NewStringUTF(env, buf);
	}
	return (*env)->NewStringUTF(env, buf);

}/**
 *根据后缀(isOfficialServer)返回正确的主机地址
 */
JNIEXPORT jstring JNICALL Java_com_java02014_utils_NetUtils_getHostPortal(
		JNIEnv *env, jclass clazz, jstring urlType) {
	const char *urlTypeStr = (*env)->GetStringUTFChars(env, urlType, JNI_FALSE);
	char buf[1024];
	/*
	 * 正式服务器
	 */
	if (strcmp(urlTypeStr, "URL_OFFICAL") == 0) {
		strcpy(buf, URL_OFFICAL_PORTAL);
		return (*env)->NewStringUTF(env, buf);
	}
	/*
	 * 预生产服务器
	 */
	if (strcmp(urlTypeStr, "URL_PRE_OFFICAL") == 0) {
		strcpy(buf, URL_PRE_OFFICAL_PORTAL);
		return (*env)->NewStringUTF(env, buf);
	}
	/*
	 * 本地测试服务器
	 */
	if (strcmp(urlTypeStr, "URL_LOCAL_TEST") == 0) {
		strcpy(buf, URL_LOCAL_TEST_PORTAL);
		return (*env)->NewStringUTF(env, buf);
	}
	return (*env)->NewStringUTF(env, buf);
}

