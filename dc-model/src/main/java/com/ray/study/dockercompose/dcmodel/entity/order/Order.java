package com.ray.study.dockercompose.dcmodel.entity.order;

import com.ray.study.dockercompose.dcmodel.entity.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author shira 2019/06/04 15:44
 */
@ApiModel(description = "订单信息实体")
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

	@ApiModelProperty(value = "订单ID", example = "10001")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 简单起见，暂时只支持一个订单只有一个商品
	 */
	@ApiModelProperty("商品ID")
	private Long productId;

	@ApiModelProperty("付款金额")
	private BigDecimal payment;

	/**
	 * 0 支付宝
	 * 1 微信
	 * 2 银行卡
	 */
	@ApiModelProperty("付款方式")
	private Integer paymentType;

	/**
	 * 0 创建，但未支付
	 * 1 已支付，但未发货
	 * 2 已发货
	 * 3 已收货
	 * 4 订单取消
	 */
	@ApiModelProperty("订单状态")
	private Integer status;

	@ApiModelProperty("付款时间")
	private Date paymentDate;

	@ApiModelProperty("发货时间")
	private Date sendDate;

	@ApiModelProperty("收货时间")
	private Date endDate;

	@ApiModelProperty("订单关闭时间")
	private Date closeDate;

	@ApiModelProperty("订单创建时间")
	private Date createDate;

	@ApiModelProperty("订单上次修改时间")
	private Date lastUpdateDate;


	@Transient
	private Product product;

}
