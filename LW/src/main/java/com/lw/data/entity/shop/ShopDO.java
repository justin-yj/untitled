package com.lw.data.entity.shop;


import com.lw.data.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 李宣宣 on 2018/7/18.
 */
public class ShopDO extends BaseEntity {

    private Long id;
    private String company_nm;
    private String stco;
    private String name;
    private Date open_date;
    private String area_co;
    private String area_nm;
    private String location;
    private String sv_code;
    private String sv_name;
    private String shoptype;
    private String address;
    private String tel;
    private String shoptype_co;
    private String business;
    private String businesstime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany_nm() {
        return company_nm;
    }

    public void setCompany_nm(String company_nm) {
        this.company_nm = company_nm;
    }

    public String getStco() {
        return stco;
    }

    public void setStco(String stco) {
        this.stco = stco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public String getArea_co() {
        return area_co;
    }

    public void setArea_co(String area_co) {
        this.area_co = area_co;
    }

    public String getArea_nm() {
        return area_nm;
    }

    public void setArea_nm(String area_nm) {
        this.area_nm = area_nm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSv_code() {
        return sv_code;
    }

    public void setSv_code(String sv_code) {
        this.sv_code = sv_code;
    }

    public String getSv_name() {
        return sv_name;
    }

    public void setSv_name(String sv_name) {
        this.sv_name = sv_name;
    }

    public String getShoptype() {
        return shoptype;
    }

    public void setShoptype(String shoptype) {
        this.shoptype = shoptype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getShoptype_co() {
        return shoptype_co;
    }

    public void setShoptype_co(String shoptype_co) {
        this.shoptype_co = shoptype_co;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinesstime() {
        return businesstime;
    }

    public void setBusinesstime(String businesstime) {
        this.businesstime = businesstime;
    }
}
