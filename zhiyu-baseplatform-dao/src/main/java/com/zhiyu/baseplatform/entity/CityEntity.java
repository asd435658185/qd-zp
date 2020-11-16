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
 * @Description 市实体类
 */

@Table(name="city")
@Entity
public class CityEntity {
  /**
  * 市id
  * */
   private Integer cityId;
   /**
    * 市编号
    * */
   private String cityCode;
   /**
    * 市名称
    * */
   private String cityName;
   /**
    * 市序号
    * */
   private Integer citySort;
   /**
    * 所属省id
    * */
   private Integer provinceId;
   
    @Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	@Column(name="city_id")
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	@Column(name="city_code")
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Column(name="city_name")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Column(name="city_sort")
	public Integer getCitySort() {
		return citySort;
	}
	public void setCitySort(Integer citySort) {
		this.citySort = citySort;
	}
	@Column(name="province_id")
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
   
   
   
}
