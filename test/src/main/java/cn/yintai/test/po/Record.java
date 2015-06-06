package cn.yintai.test.po;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Record {
	
	public static final Integer ORDER_TYPE_OF_PAY = 101;
	public static final Integer ORDER_TYPE_OF_PAYBACK = 201;
	public static final String ORDER_TYPE_OF_PAY_VIEW = "支付";
	public static final String ORDER_TYPE_OF_PAYBACK_VIEW = "退款";
	
	public static final Integer ORDER_STATUS_OF_WAIT = 2;
	public static final Integer ORDER_STATUS_OF_SUCCESS = 1;
	public static final Integer ORDER_STATUS_OF_FAIL = 0;
	public static final String ORDER_STATUS_OF_SUCCESS_VIEW = "支付成功";
	public static final String ORDER_STATUS_OF_FAIL_VIEW = "支付失败";
	public static final String ORDER_STATUS_OF_WAIT_VIEW = "等待付款";
	
	public static final Integer ORDER_TRADE_OF_RMB = 1;
	public static final Integer ORDER_TRADE_OF_DOLLAR = 0;
	public static final String ORDER_TRADE_OF_RMB_VIEW = "人名币";
	public static final String ORDER_TRADE_OF_DOLLAR_VIEW = "美元";
	
	private static final Map<Integer, String> typeMap = new HashMap<Integer, String>();
	private static final Map<Integer, String> statusMap = new HashMap<Integer, String>();
	private static final Map<Integer, String> tradeMap = new HashMap<Integer, String>();
	static{
		typeMap.put(ORDER_TYPE_OF_PAY, ORDER_TYPE_OF_PAY_VIEW);
		typeMap.put(ORDER_TYPE_OF_PAYBACK, ORDER_TYPE_OF_PAYBACK_VIEW);
		
		statusMap.put(ORDER_STATUS_OF_WAIT, ORDER_STATUS_OF_WAIT_VIEW);
		statusMap.put(ORDER_STATUS_OF_SUCCESS, ORDER_STATUS_OF_SUCCESS_VIEW);
		statusMap.put(ORDER_STATUS_OF_FAIL, ORDER_STATUS_OF_FAIL_VIEW);
		
		tradeMap.put(ORDER_TRADE_OF_RMB, ORDER_TRADE_OF_RMB_VIEW);
		tradeMap.put(ORDER_TRADE_OF_DOLLAR, ORDER_TRADE_OF_DOLLAR_VIEW);
	}
	
	
	private String id;
	private Date createTime;
	private Double price;
	private String clientId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
		this.orderStatusView = statusMap.get(orderStatus);
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
		this.orderTypeView = typeMap.get(orderType);
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
		this.tradeTypeView = tradeMap.get(tradeType);
	}
	public String getOrderStatusView() {
		return orderStatusView;
	}
	public String getOrderTypeView() {
		return orderTypeView;
	}
	public String getTradeTypeView() {
		return tradeTypeView;
	}
	private Integer orderStatus;
	private String orderStatusView;
	private Integer orderType;
	private String orderTypeView;
	private Integer tradeType;
	private String tradeTypeView;
	
	
	
	
}
