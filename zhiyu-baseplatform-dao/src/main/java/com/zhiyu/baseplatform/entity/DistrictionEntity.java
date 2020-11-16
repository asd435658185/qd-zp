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
 * @Description 县实体类
 */

@Table(name="distriction")
@Entity
public class DistrictionEntity {
	
	/**
	 * 县id
	 * */
    private Integer districtId;
    /**
	 * 县编号
	 * */
    private String districtCode;
    /**
	 * 县名称
	 * */
    private String districtName;
    /**
	 * 县序号
	 * */
    private Integer districtSort;
    /**
	 * 所属市id
	 * */
    private Integer cityId;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="district_id")
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	@Column(name="district_code")
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	@Column(name="district_name")
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	@Column(name="district_sort")
	public Integer getDistrictSort() {
		return districtSort;
	}
	public void setDistrictSort(Integer districtSort) {
		this.districtSort = districtSort;
	}
	
	@Column(name="city_id")
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
    
    
}
