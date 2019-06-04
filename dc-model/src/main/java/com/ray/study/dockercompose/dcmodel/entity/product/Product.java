package com.ray.study.dockercompose.dcmodel.entity.product;

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
 * @author shira 2019/06/04 14:20
 */
@ApiModel(description = "商品信息实体")
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

	@ApiModelProperty(value = "商品ID", example = "10001")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty("商品名称")
	private String name;

	@ApiModelProperty("商品详细信息")
	private String detail;

	@ApiModelProperty("商品价格")
	private BigDecimal price;

	@ApiModelProperty("商品创建日期")
	private Date creationDate;

	@ApiModelProperty("商品上次修改日期")
	private Date lastUpdateDate;

}
