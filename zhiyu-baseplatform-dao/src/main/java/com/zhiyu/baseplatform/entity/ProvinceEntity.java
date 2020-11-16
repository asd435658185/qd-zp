package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 省实体类
 */

@Table(name="province")
@Entity
public class ProvinceEntity {
	  /**
	  * 省id
	  * */
	   private Integer provinceId;
	   /**
	    * 省编号
	    * */
	   private String provinceCode;
	   /**
	    * 省名称
	    * */
	   private String provinceName;
	   /**
	    * 省序号
	    * */
	   private Integer provinceSort;
	   /**
	    * 省备注
	    * */
	   private String provinceRemark;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="province_id")
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	@Column(name="province_code")
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@Column(name="province_name")
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	@Column(name="province_sort")
	public Integer getProvinceSort() {
		return provinceSort;
	}
	public void setProvinceSort(Integer provinceSort) {
		this.provinceSort = provinceSort;
	}
	
	@Column(name="province_remark")
	public String getProvinceRemark() {
		return provinceRemark;
	}
	public void setProvinceRemark(String provinceRemark) {
		this.provinceRemark = provinceRemark;
	}
	   
	   
}
