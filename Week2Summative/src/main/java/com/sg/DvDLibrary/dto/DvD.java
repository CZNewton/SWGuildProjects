/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.dto;

/**
 *
 * @author apprentice
 */
public class DvD {
    private String title;
    private String rDate;
    private String rating;
    private String directorName;
    private String studioName;
    private String userRating;
    private String addInfo;

    /**
     * @return the addInfo
     */
    public String getAddInfo() {
        return addInfo;
    }

    /**
     * @param addInfo the addInfo to set
     */
    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the rDate
     */
    public String getrDate() {
        return rDate;
    }

    /**
     * @param rDate the rDate to set
     */
    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the directorName
     */
    public String getDirectorName() {
        return directorName;
    }

    /**
     * @param directorName the directorName to set
     */
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    /**
     * @return the studioName
     */
    public String getStudioName() {
        return studioName;
    }

    /**
     * @param studioName the studioName to set
     */
    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    /**
     * @return the userRating
     */
    public String getUserRating() {
        return userRating;
    }

    /**
     * @param userRating the userRating to set
     */
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
}
