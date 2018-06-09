package xyz.liweichao.auth.core.social.ways.qq.api;

/**
 * QQUserInfo
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class QQUserInfo {

    /**
     * 返回码
     */
    private String ret;
    /**
     * 如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
     */
    private String msg;
    /**
     *
     */
    private String openId;
    /**
     * 不知道什么东西，文档上没写，但是实际api返回里有。
     */
    private String isLost;
    /**
     * 省(直辖市)
     */
    private String province;
    /**
     * 市(直辖市区)
     */
    private String city;
    /**
     * 出生年月
     */
    private String year;
    /**
     * 用户在QQ空间的昵称。
     */
    private String nickname;
    /**
     * 大小为30×30像素的QQ空间头像URL。
     */
    private String figureurl;
    /**
     * 大小为50×50像素的QQ空间头像URL。
     */
    private String figureurl1;
    /**
     * 大小为100×100像素的QQ空间头像URL。
     */
    private String figureurl2;
    /**
     * 大小为40×40像素的QQ头像URL。
     */
    private String figureurlQq1;
    /**
     * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100×100的头像，但40×40像素则是一定会有。
     */
    private String figureurlQq2;
    /**
     * 性别。 如果获取不到则默认返回”男”
     */
    private String gender;
    /**
     * 标识用户是否为黄钻用户（0：不是；1：是）。
     */
    private String isYellowVip;
    /**
     * 标识用户是否为黄钻用户（0：不是；1：是）
     */
    private String vip;
    /**
     * 黄钻等级
     */
    private String yellowVipLevel;
    /**
     * 黄钻等级
     */
    private String level;
    /**
     * 标识是否为年费黄钻用户（0：不是； 1：是）
     */
    private String isYellowYearVip;

    public String getRet() {
        return ret;
    }

    public QQUserInfo setRet(String ret) {
        this.ret = ret;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public QQUserInfo setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public QQUserInfo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getIsLost() {
        return isLost;
    }

    public QQUserInfo setIsLost(String isLost) {
        this.isLost = isLost;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public QQUserInfo setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public QQUserInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public String getYear() {
        return year;
    }

    public QQUserInfo setYear(String year) {
        this.year = year;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public QQUserInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public QQUserInfo setFigureurl(String figureurl) {
        this.figureurl = figureurl;
        return this;
    }

    public String getFigureurl1() {
        return figureurl1;
    }

    public QQUserInfo setFigureurl1(String figureurl1) {
        this.figureurl1 = figureurl1;
        return this;
    }

    public String getFigureurl2() {
        return figureurl2;
    }

    public QQUserInfo setFigureurl2(String figureurl2) {
        this.figureurl2 = figureurl2;
        return this;
    }

    public String getFigureurlQq1() {
        return figureurlQq1;
    }

    public QQUserInfo setFigureurlQq1(String figureurlQq1) {
        this.figureurlQq1 = figureurlQq1;
        return this;
    }

    public String getFigureurlQq2() {
        return figureurlQq2;
    }

    public QQUserInfo setFigureurlQq2(String figureurlQq2) {
        this.figureurlQq2 = figureurlQq2;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public QQUserInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIsYellowVip() {
        return isYellowVip;
    }

    public QQUserInfo setIsYellowVip(String isYellowVip) {
        this.isYellowVip = isYellowVip;
        return this;
    }

    public String getVip() {
        return vip;
    }

    public QQUserInfo setVip(String vip) {
        this.vip = vip;
        return this;
    }

    public String getYellowVipLevel() {
        return yellowVipLevel;
    }

    public QQUserInfo setYellowVipLevel(String yellowVipLevel) {
        this.yellowVipLevel = yellowVipLevel;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public QQUserInfo setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getIsYellowYearVip() {
        return isYellowYearVip;
    }

    public QQUserInfo setIsYellowYearVip(String isYellowYearVip) {
        this.isYellowYearVip = isYellowYearVip;
        return this;
    }
}
