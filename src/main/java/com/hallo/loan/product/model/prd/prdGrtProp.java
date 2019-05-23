package com.hallo.loan.product.model.prd;

import java.math.BigDecimal;

public class prdGrtProp {
    /**
     * 主键
     */
    private String id;

    /**
     * 
     */
    private String grtNo;

    /**
     * 产品编号
     */
    private String prdCode;

    /**
     * 
     */
    private String grtName;

    /**
     * 担保公司账号
     */
    private String grtAccountNo;

    /**
     * 担保公司担保额度
     */
    private BigDecimal grtAmt;

    /**
     * 状态：0 失效 1 生效
     */
    private String sts;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最低控制金额(担保额度小于最低控制金额则担保公司不可用)
     */
    private BigDecimal minControlAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrtNo() {
        return grtNo;
    }

    public void setGrtNo(String grtNo) {
        this.grtNo = grtNo;
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public String getGrtName() {
        return grtName;
    }

    public void setGrtName(String grtName) {
        this.grtName = grtName;
    }

    public String getGrtAccountNo() {
        return grtAccountNo;
    }

    public void setGrtAccountNo(String grtAccountNo) {
        this.grtAccountNo = grtAccountNo;
    }

    public BigDecimal getGrtAmt() {
        return grtAmt;
    }

    public void setGrtAmt(BigDecimal grtAmt) {
        this.grtAmt = grtAmt;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getMinControlAmt() {
        return minControlAmt;
    }

    public void setMinControlAmt(BigDecimal minControlAmt) {
        this.minControlAmt = minControlAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", grtNo=").append(grtNo);
        sb.append(", prdCode=").append(prdCode);
        sb.append(", grtName=").append(grtName);
        sb.append(", grtAccountNo=").append(grtAccountNo);
        sb.append(", grtAmt=").append(grtAmt);
        sb.append(", sts=").append(sts);
        sb.append(", remark=").append(remark);
        sb.append(", minControlAmt=").append(minControlAmt);
        sb.append("]");
        return sb.toString();
    }
}