package com.ray.study.dockercompose.productservice.service;

import com.ray.study.dockercompose.dcmodel.entity.product.Product;

import java.util.List;

/**
 * 商品 service
 *
 * @author shira 2019/06/04 14:26
 */
public interface ProductService {


	/**
	 * 获取用户列表
	 * @return
	 */
	List<Product> list();

	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	Product query(Long id);

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	Product insert(Product user);

	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	Product update(Product user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	void delete(Long id);


}
