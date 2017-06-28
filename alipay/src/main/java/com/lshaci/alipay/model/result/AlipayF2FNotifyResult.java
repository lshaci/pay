package com.lshaci.alipay.model.result;

import java.math.BigDecimal;
import java.util.Date;

public class AlipayF2FNotifyResult {
	
	private Date notifyTime;// *通知时间(yyyy-MM-dd HH:mm:ss)
	
	private String notifyType;// *通知类型(trade_status_sync)
	
	private String notifyId;// *通知校验ID
	
	private String signType;// *签名类型(目前支持RSA2和RSA，推荐使用RSA2)
	
	private String sign;// *签名
	
	private String tradeNo;// *支付宝交易号
	
	private String appId;// *开发者的app_id
	
	private String outTradeNo;// *商户订单号
	
	private String outBizNo;// 商户业务号(主要是退款通知中返回退款申请的流水号)
	
	private String buyerId;// 买家支付宝用户号(买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字)
	
	private String buyerLogonId;// 买家支付宝账号
	
	private String sellerId;// 卖家支付宝用户号(2088101106499364)
	
	private String sellerEmail;// 卖家支付宝账号
	
	private String tradeStatus;// 交易状态
	
	private BigDecimal totalAmount;// 订单金额(单位为人民币（元）)
	
	private BigDecimal receiptAmount;// 实收金额(商家在交易中实际收到的款项)
	
	private BigDecimal invoiceAmount;// 开票金额(用户在交易中支付的可开发票的金额)
	
	private BigDecimal buyerPayAmount;// 付款金额(用户在交易中支付的金额)
	
	private BigDecimal pointAmount;// 集分宝金额(使用集分宝支付的金额)
	
	private BigDecimal refundFee;// 总退款金额(退款通知中，返回总退款金额，单位为元，支持两位小数)
	
	private BigDecimal sendBackFee;// 实际退款金额(商户实际退款给用户的金额，单位为元，支持两位小数)
	
	private String subject;// 订单标题
	
	private Date body;// 商品描述
	
	private Date gmtCreate;// 交易创建时间
	
	private Date gmtPayment;// 交易付款时间
	
	private Date gmtRefund;// 交易退款时间
	
	private Date gmtClose;// 交易结束时间
	
	private String fundBillList;// 支付金额信息[{"amount":"15.00","fundChannel":"ALIPAYACCOUNT"}]

	public Date getNotifyTime() {
		return notifyTime;
	}

	public void setNotify_time(Date notifyTime) {
		setNotifyTime(notifyTime);
	}
	public void setNotifyTime(Date notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotify_type(String notifyType) {
		setNotifyType(notifyType);
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotify_id(String notifyId) {
		setNotifyId(notifyId);
	}
	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSign_type(String signType) {
		setSignType(signType);
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTrade_no(String tradeNo) {
		setTradeNo(tradeNo);
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getAppId() {
		return appId;
	}

	public void setApp_id(String appId) {
		setAppId(appId);
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOut_trade_no(String outTradeNo) {
		setOutTradeNo(outTradeNo);
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutBizNo() {
		return outBizNo;
	}

	public void setOut_biz_no(String outBizNo) {
		setOutBizNo(outBizNo);
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyer_id(String buyerId) {
		setBuyerId(buyerId);
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyer_logon_id(String buyerLogonId) {
		setBuyerLogonId(buyerLogonId);
	}
	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSeller_id(String sellerId) {
		setSellerId(sellerId);
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSeller_email(String sellerEmail) {
		setSellerEmail(sellerEmail);
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTrade_status(String tradeStatus) {
		setTradeStatus(tradeStatus);
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotal_amount(BigDecimal totalAmount) {
		setTotalAmount(totalAmount);
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceipt_amount(BigDecimal receiptAmount) {
		setReceiptAmount(receiptAmount);
	}
	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoice_amount(BigDecimal invoiceAmount) {
		setInvoiceAmount(invoiceAmount);
	}
	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public BigDecimal getBuyerPayAmount() {
		return buyerPayAmount;
	}

	public void setBuyer_pay_amount(BigDecimal buyerPayAmount) {
		setBuyerPayAmount(buyerPayAmount);
	}
	public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	public void setPoint_amount(BigDecimal pointAmount) {
		setPointAmount(pointAmount);
	}
	public void setPointAmount(BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefund_fee(BigDecimal refundFee) {
		setRefundFee(refundFee);
	}
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public BigDecimal getSendBackFee() {
		return sendBackFee;
	}

	public void setSend_back_fee(BigDecimal sendBackFee) {
		setSendBackFee(sendBackFee);
	}
	public void setSendBackFee(BigDecimal sendBackFee) {
		this.sendBackFee = sendBackFee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getBody() {
		return body;
	}

	public void setBody(Date body) {
		this.body = body;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmt_create(Date gmtCreate) {
		setGmtCreate(gmtCreate);
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtPayment() {
		return gmtPayment;
	}

	public void setGmt_payment(Date gmtPayment) {
		setGmtPayment(gmtPayment);
	}
	public void setGmtPayment(Date gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

	public Date getGmtRefund() {
		return gmtRefund;
	}

	public void setGmt_refund(Date gmtRefund) {
		setGmtRefund(gmtRefund);
	}
	public void setGmtRefund(Date gmtRefund) {
		this.gmtRefund = gmtRefund;
	}

	public Date getGmtClose() {
		return gmtClose;
	}

	public void setGmt_close(Date gmtClose) {
		setGmtClose(gmtClose);
	}
	public void setGmtClose(Date gmtClose) {
		this.gmtClose = gmtClose;
	}

	public String getFundBillList() {
		return fundBillList;
	}

	public void setFund_bill_list(String fundBillList) {
		setFundBillList(fundBillList);
	}
	public void setFundBillList(String fundBillList) {
		this.fundBillList = fundBillList;
	}

	@Override
	public String toString() {
		return "AlipayF2FNotifyResult [notifyTime=" + notifyTime + ", notifyType=" + notifyType + ", notifyId="
				+ notifyId + ", signType=" + signType + ", sign=" + sign + ", tradeNo=" + tradeNo + ", appId=" + appId
				+ ", outTradeNo=" + outTradeNo + ", outBizNo=" + outBizNo + ", buyerId=" + buyerId + ", buyerLogonId="
				+ buyerLogonId + ", sellerId=" + sellerId + ", sellerEmail=" + sellerEmail + ", tradeStatus="
				+ tradeStatus + ", totalAmount=" + totalAmount + ", receiptAmount=" + receiptAmount + ", invoiceAmount="
				+ invoiceAmount + ", buyerPayAmount=" + buyerPayAmount + ", pointAmount=" + pointAmount + ", refundFee="
				+ refundFee + ", sendBackFee=" + sendBackFee + ", subject=" + subject + ", body=" + body
				+ ", gmtCreate=" + gmtCreate + ", gmtPayment=" + gmtPayment + ", gmtRefund=" + gmtRefund + ", gmtClose="
				+ gmtClose + ", fundBillList=" + fundBillList + "]";
	}


}
