package com.wxj.mvp_design.bean;

/**
 * Created by chen on 2016/7/8 0008.
 */
public class WorkerInfo {
    private boolean status;
    private String info;
    private Data data;

    public class Data {
        private String workerName;
        private int workerId;
        private String style;
        private String experience;
        private String photo;
        private String brief;
        private String lng;
        private String lat;
        private String name;
        private String telephone;
        private String idNumber;
        private String idNumberImage;
        private String idNumberImage2;
        private String address;
        private int isCheck;
        private String bankCardNumber;
        private int designerType;// (必选)：设计师类型   0：家装，1：工装
        private String firstLinkName;//亲属姓名
        private String firstLinkTel;//亲属电话
        private String secondLinkName;//
        private String secondLinkTel;
        private double totalFee;

        public String getWorkerName() {
            return workerName;
        }

        public void setWorkerName(String workerName) {
            this.workerName = workerName;
        }

        public int getWorkerId() {
            return workerId;
        }

        public void setWorkerId(int workerId) {
            this.workerId = workerId;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getIdNumberImage() {
            return idNumberImage;
        }

        public void setIdNumberImage(String idNumberImage) {
            this.idNumberImage = idNumberImage;
        }

        public String getIdNumberImage2() {
            return idNumberImage2;
        }

        public void setIdNumberImage2(String idNumberImage2) {
            this.idNumberImage2 = idNumberImage2;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIsCheck() {
            return isCheck;
        }

        public void setIsCheck(int isCheck) {
            this.isCheck = isCheck;
        }

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        public int getDesignerType() {
            return designerType;
        }

        public void setDesignerType(int designerType) {
            this.designerType = designerType;
        }

        public String getFirstLinkName() {
            return firstLinkName;
        }

        public void setFirstLinkName(String firstLinkName) {
            this.firstLinkName = firstLinkName;
        }

        public String getFirstLinkTel() {
            return firstLinkTel;
        }

        public void setFirstLinkTel(String firstLinkTel) {
            this.firstLinkTel = firstLinkTel;
        }

        public String getSecondLinkName() {
            return secondLinkName;
        }

        public void setSecondLinkName(String secondLinkName) {
            this.secondLinkName = secondLinkName;
        }

        public String getSecondLinkTel() {
            return secondLinkTel;
        }

        public void setSecondLinkTel(String secondLinkTel) {
            this.secondLinkTel = secondLinkTel;
        }

        public double getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(double totalFee) {
            this.totalFee = totalFee;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
