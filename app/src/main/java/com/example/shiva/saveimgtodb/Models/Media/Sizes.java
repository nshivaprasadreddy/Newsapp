
package com.example.shiva.saveimgtodb.Models.Media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("small-wide")
    @Expose
    private SmallWide smallWide;
    @SerializedName("small-wide-hd")
    @Expose
    private SmallWideHd smallWideHd;
    @SerializedName("related-posts")
    @Expose
    private RelatedPosts relatedPosts;
    @SerializedName("cats_horz_menu")
    @Expose
    private CatsHorzMenu catsHorzMenu;
    @SerializedName("ajax-search-small")
    @Expose
    private AjaxSearchSmall ajaxSearchSmall;
    @SerializedName("posts-slider-widget")
    @Expose
    private PostsSliderWidget postsSliderWidget;
    @SerializedName("scrolling-box")
    @Expose
    private ScrollingBox scrollingBox;
    @SerializedName("news_box3")
    @Expose
    private NewsBox3 newsBox3;
    @SerializedName("news_box_big")
    @Expose
    private NewsBoxBig newsBoxBig;
    @SerializedName("news_in_pics")
    @Expose
    private NewsInPics newsInPics;
    @SerializedName("news_in_pics_big")
    @Expose
    private NewsInPicsBig newsInPicsBig;
    @SerializedName("blog_medium")
    @Expose
    private BlogMedium blogMedium;
    @SerializedName("mom-portfolio-four")
    @Expose
    private MomPortfolioFour momPortfolioFour;
    @SerializedName("mom-portfolio-three")
    @Expose
    private MomPortfolioThree momPortfolioThree;
    @SerializedName("mom-portfolio-two")
    @Expose
    private MomPortfolioTwo momPortfolioTwo;
    @SerializedName("mom-portfolio-one")
    @Expose
    private MomPortfolioOne momPortfolioOne;
    @SerializedName("big-wide-img")
    @Expose
    private BigWideImg bigWideImg;
    @SerializedName("full")
    @Expose
    private Full full;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public SmallWide getSmallWide() {
        return smallWide;
    }

    public void setSmallWide(SmallWide smallWide) {
        this.smallWide = smallWide;
    }

    public SmallWideHd getSmallWideHd() {
        return smallWideHd;
    }

    public void setSmallWideHd(SmallWideHd smallWideHd) {
        this.smallWideHd = smallWideHd;
    }

    public RelatedPosts getRelatedPosts() {
        return relatedPosts;
    }

    public void setRelatedPosts(RelatedPosts relatedPosts) {
        this.relatedPosts = relatedPosts;
    }

    public CatsHorzMenu getCatsHorzMenu() {
        return catsHorzMenu;
    }

    public void setCatsHorzMenu(CatsHorzMenu catsHorzMenu) {
        this.catsHorzMenu = catsHorzMenu;
    }

    public AjaxSearchSmall getAjaxSearchSmall() {
        return ajaxSearchSmall;
    }

    public void setAjaxSearchSmall(AjaxSearchSmall ajaxSearchSmall) {
        this.ajaxSearchSmall = ajaxSearchSmall;
    }

    public PostsSliderWidget getPostsSliderWidget() {
        return postsSliderWidget;
    }

    public void setPostsSliderWidget(PostsSliderWidget postsSliderWidget) {
        this.postsSliderWidget = postsSliderWidget;
    }

    public ScrollingBox getScrollingBox() {
        return scrollingBox;
    }

    public void setScrollingBox(ScrollingBox scrollingBox) {
        this.scrollingBox = scrollingBox;
    }

    public NewsBox3 getNewsBox3() {
        return newsBox3;
    }

    public void setNewsBox3(NewsBox3 newsBox3) {
        this.newsBox3 = newsBox3;
    }

    public NewsBoxBig getNewsBoxBig() {
        return newsBoxBig;
    }

    public void setNewsBoxBig(NewsBoxBig newsBoxBig) {
        this.newsBoxBig = newsBoxBig;
    }

    public NewsInPics getNewsInPics() {
        return newsInPics;
    }

    public void setNewsInPics(NewsInPics newsInPics) {
        this.newsInPics = newsInPics;
    }

    public NewsInPicsBig getNewsInPicsBig() {
        return newsInPicsBig;
    }

    public void setNewsInPicsBig(NewsInPicsBig newsInPicsBig) {
        this.newsInPicsBig = newsInPicsBig;
    }

    public BlogMedium getBlogMedium() {
        return blogMedium;
    }

    public void setBlogMedium(BlogMedium blogMedium) {
        this.blogMedium = blogMedium;
    }

    public MomPortfolioFour getMomPortfolioFour() {
        return momPortfolioFour;
    }

    public void setMomPortfolioFour(MomPortfolioFour momPortfolioFour) {
        this.momPortfolioFour = momPortfolioFour;
    }

    public MomPortfolioThree getMomPortfolioThree() {
        return momPortfolioThree;
    }

    public void setMomPortfolioThree(MomPortfolioThree momPortfolioThree) {
        this.momPortfolioThree = momPortfolioThree;
    }

    public MomPortfolioTwo getMomPortfolioTwo() {
        return momPortfolioTwo;
    }

    public void setMomPortfolioTwo(MomPortfolioTwo momPortfolioTwo) {
        this.momPortfolioTwo = momPortfolioTwo;
    }

    public MomPortfolioOne getMomPortfolioOne() {
        return momPortfolioOne;
    }

    public void setMomPortfolioOne(MomPortfolioOne momPortfolioOne) {
        this.momPortfolioOne = momPortfolioOne;
    }

    public BigWideImg getBigWideImg() {
        return bigWideImg;
    }

    public void setBigWideImg(BigWideImg bigWideImg) {
        this.bigWideImg = bigWideImg;
    }

    public Full getFull() {
        return full;
    }

    public void setFull(Full full) {
        this.full = full;
    }

}
